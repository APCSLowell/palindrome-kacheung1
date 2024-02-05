import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
   String lines[] = {"test","rotator","rewriter","nurses run","Madam, I'm Adam!","A Man! A Plan! A Canal! Panama!"};
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public String noSpaces(String sWord){
  String idk = new String();
  for(int i = 0; i < sWord.length(); i++)
  {
  if(!sWord.substring(i,i+1).equals(" "))
  {
  idk =idk + sWord.substring(i,i+1);
  }
  }
  return idk ;
}

public String onlyLetters(String sString){
  String result= new String();
  for (int i=0; i<sString.length(); i++)
  {
   
if (Character.isLetter(sString.charAt(i)))
result = result + sString.substring(i,i+1);
  }
  return result;
}

public String noCapitals(String sWord){
  return sWord.toLowerCase();
}

public boolean palindrome(String word)
{
  String word1= new String();
  word1=noSpaces(word);
  word1=noCapitals(word1);
  word1=onlyLetters(word1);
  
  if (word1.equals(reverse(word1)))
{
return true;
}
  return false;
}

public String reverse(String str)
{
    String sNew = new String();

  for(int i = str.length()-1; i>=0; i--)
    sNew=sNew+str.charAt(i);
  return sNew;
}

