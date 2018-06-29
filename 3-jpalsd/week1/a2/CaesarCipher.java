
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (Tan Le) 
 * @version (26-06-2018)
 */

import edu.duke.*;

public class CaesarCipher
{
    public String encrypt(String message, int key)
    {
        // Make a StringBuilder with message
        StringBuilder encrypted = new StringBuilder(message);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        String shiftedAlphabetLowerCase = shiftedAlphabet.toLowerCase();
        
        // Count from 0 to < length of encrypted (call it i)
        for (int i = 0; i < encrypted.length(); i++)
        {
            char encryptedChar = encrypted.charAt(i);   // Look at the ith character of encrypted (call it messageChar)
            int encryptedCharIdx = alphabet.indexOf(Character.toUpperCase(encryptedChar));  // Find the index of the messageChar in the alphabet (newChar)
            
            if (encryptedCharIdx != -1)    // If messageChar is in the alphabet
            {
                // If the current character (in message) is in lowercase
                if (Character.isLowerCase(encryptedChar))
                {
                    char newChar = shiftedAlphabetLowerCase.charAt(encryptedCharIdx);
                    encrypted.setCharAt(i, newChar);
                }
                
                // If the current character (in message) is in uppercase
                if (Character.isUpperCase(encryptedChar))
                {
                    char newChar = shiftedAlphabet.charAt(encryptedCharIdx);
                    // Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
            }
            // Otherwise do nothing
        }

        // Your answer is the String inside encrypted
        return encrypted.toString();
    }

    public void testEncrypt()
    {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        // Print out the String before encrypting
        // System.out.println(message);
        // Encrypt the string
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        // Decrypt the encrypted string
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    
    // Refactor code
    public char encryptChar(char input, int key)
    {
        // if character lowercase
        if(Character.isLowerCase(input))
        {
            String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
            String shiftedAlphabet = alphabetLowerCase.substring(key) + alphabetLowerCase.substring(0, key);
            int currentIdx = alphabetLowerCase.indexOf(input);
            char encrypted = shiftedAlphabet.charAt(currentIdx);
            
            return encrypted;
        }
        // if character uppercase
        if(Character.isUpperCase(input))
        {
            String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String shiftedAlphabet = alphabetUpperCase.substring(key) + alphabetUpperCase.substring(0, key);
            int currentIdx = alphabetUpperCase.indexOf(input);
            char encrypted = shiftedAlphabet.charAt(currentIdx);
            
            return encrypted;            
        }
        
        return '\u0000';    // null character
    }
    
    public String encryptTwoKeys(String input, int key1, int key2)
    {
        // Make a StringBuilder with message
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Loop through each character in the input string
        for (int i = 0; i < encrypted.length(); i++)
        {
            char currentChar = input.charAt(i);
            int currentCharIdx = alphabet.indexOf(Character.toUpperCase(currentChar));  // Find the index of the messageChar in the alphabet (newChar)
            if (currentCharIdx != -1)    // If messageChar is in the alphabet, not a space/punctuation
            {
                if (i % 2 == 0)
                {
                    char encrtdChar = encryptChar(currentChar, key1);
                    encrypted.setCharAt(i, encrtdChar);
                }
                else
                {
                    char encrtdChar = encryptChar(currentChar, key2);
                    encrypted.setCharAt(i, encrtdChar);
                }
            }
            // Otherwise do nothing
        }
        
        return encrypted.toString();
    }
    
    public void testEncryptTwoKeys()
    {
        String result = encryptTwoKeys("First Legion", 23, 17);
        String testCase1 = "Czojq Ivdzle";
        
        if(result.equals(testCase1))
        {
            System.out.println("Test case 1: pass \n\t"+ result + "\n\t" + testCase1);
        }
        else
        {
            System.out.println("Test case 1: failed. It's failed! \n\t" + result + "\n\t" + testCase1);
        }
    }
}
