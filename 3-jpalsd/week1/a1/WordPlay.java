
/**
 * This program transforms words from a file into another form,
 * such as replacing vowels with an asterix
 * 
 * @author (Tan Le) 
 * @version (27-06-2018)
 */

import edu.duke.*;

public class WordPlay {
    public boolean isVowel(char ch)
    {
        Character.toLowerCase(ch);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void testIsVowel()
    {
        char ch1 = 'F';
        char ch2 = 'a';
        
        if(isVowel('F') == false && isVowel('a') == true)
        {
            System.out.println("Test case 1: pass -\t" + "'F' is not a vowel");
            System.out.println("Test case 2: pass -\t" + "'a' is a vowel");
        }
        else
        {
            System.out.println("Test case 1: failed -\t" + "Your algo not good yet! :P");
        }
    }
    
    public String replaceVowels(String phrase, char ch)
    {
        Character.toLowerCase(ch);
        StringBuilder newPhrase = new StringBuilder(phrase.toLowerCase());
        
        for (int i = 0; i < newPhrase.length(); i++)
        {
            // Look at the ith character of pharase
            char ithChar = newPhrase.charAt(i);
            // Check vowel
            if (isVowel(ithChar))
            {
                newPhrase.setCharAt(i, ch);
            }
        }
        
        return newPhrase.toString();
    }
    
    public void testReplacedVowels()
    {
        String output = replaceVowels("Hello World", '*');
        String testCase1 = "H*ll* W*rld";
        if (output.equals(testCase1.toLowerCase()))
        {
            System.out.println("Test case 1: pass - \t" + "Hello World" + "\t" + testCase1);
        }
        else
        {
            System.out.println("Test case 1: failed - \t" + "Check your algo please");
            System.out.println(output + "\n" + testCase1);
        }
    }
    
    public String emphasize(String phrase, char ch)
    {
        int numLoc = 0;
        int idx = 0;
        Character.toLowerCase(ch);
        StringBuilder newPhrase = new StringBuilder(phrase.toLowerCase());
        
        for (idx = 0; idx < phrase.length(); idx++)
        {
            numLoc = idx + 1;
            Character idxChar = newPhrase.charAt(idx);
            if (idxChar.equals(ch))
            {
                if (numLoc % 2 == 0)
                {
                    newPhrase.setCharAt(idx, '+');
                }
                else
                {
                    newPhrase.setCharAt(idx, '*');
                }
            }
        }
        
        return newPhrase.toString();
    }
    
    public void testEmphasize()
    {
        String input1 = "dna ctgaaactga";
        String output1 = emphasize(input1, 'a');
        String input2 = "Mary Bella Abracadabra";
        String output2 = emphasize(input2, 'a');
        String testCase1 = "dn* ctg+*+ctg+";
        String testCase2 = "M+ry Bell+ +br*c*d*br+";
        
        if (output1.equals(testCase1.toLowerCase()) && output2.equals(testCase2.toLowerCase()))
        {
            System.out.println("Test case 1: pass" + "\n" + "Test case 2: pass");
        }
        else
        {
            System.out.println("Test case failed \n" 
                                + input1 + "\t" + output1 + "\t" + testCase1);
            System.out.println("Test case failed \n" 
                                + input1 + "\t" + output1 + "\t" + testCase1);
        }
    }
}
