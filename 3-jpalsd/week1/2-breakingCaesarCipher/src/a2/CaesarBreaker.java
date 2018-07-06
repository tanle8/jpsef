
/**
 * .
 * 
 * @author (Tan Le) 
 * @version (06-07-2018)
 */

import edu.duke.*;

public class CaesarBreaker {
    public int[] countLetters(String encrypted)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < encrypted.length(); i++)
        {
            char ch = Character.toLowerCase(encrypted.charAt(i));
            int chIdx = alphabet.indexOf(ch);
            if (chIdx != -1)
            {
                counts[chIdx] += 1;
            }
        }
        
        return counts;
    }
    
    public int maxIndex(int[] frequencies)
    {
        int maxValueIdx = 0;
        for (int i = 0; i < frequencies.length; i++)
        {
            if (frequencies[i] > frequencies[maxValueIdx])
            {
                maxValueIdx = i;
            }
        }
        return maxValueIdx;
    }
    
    public String decrypt(String encrypted)
    {
        CaesarCipher cc = new CaesarCipher();
        int[] frequencies = countLetters(encrypted);
        int maxIdx = maxIndex(frequencies);
        int key = maxIdx - 4;
        if (maxIdx < 4)
        {
            key = 26 - (4 - maxIdx);
        }
        String decrypted = cc.encrypt(encrypted, 26 - key);
        
        return decrypted;
    }
    
    //public void testDecrypt()
    //{
        //TODO: Find a encrypted String to test the decypted method
    //}
    
    /**
     * This method returns a new String that is every other 
     * character from message starting with the start position.
     * 
     * @Params:
     * - message: A String
     * - start: indicate the starting position in the message string
     * @Returns:
     * - A string which depends on starting position
     */ 
    
    public String halfOfString(String message, int start)
    {
        String strEvenIdx = "";
        String strOddIdx = "";
        
        for (int i = 0; i < message.length(); i++)
        {
            if (i % 2 == 0)
            {
                strEvenIdx += message.charAt(i);
            }
            else
            {
                strOddIdx += message.charAt(i);
            }
        }
        
        if (start == 0)
        {
            return strEvenIdx;
        }
        else
        {
            return strOddIdx;
        }
    }
    
    public void testHalfOfString()
    {
        String testCase1 = halfOfString("Qbkm Zgis", 0);
        String testCase2 = halfOfString("Qbkm Zgis", 1);
        if (testCase1.equals("Qk gs") && testCase2.equals("bmZi"))
        {
            System.out.println("Test cases pass!");
        }
    }
    
    public int getKey(String s)
    {
        int key = 0;
        int[] letterCount = countLetters(s);
        int maxValueIdx = maxIndex(letterCount);
        key = maxValueIdx - 4;
        
        if (maxValueIdx < 4)
        {
            key = 26 - (4 - maxValueIdx);
        }
        
        return key;
    }
    
    public String decryptTwoKeys(String s)
    {
        CaesarCipher cc = new CaesarCipher();
        // Calculate a string of every other character ...
        String firstHalf = halfOfString(s, 0);  // ... which started from even index.
        String secondHalf = halfOfString(s, 1); // ... which started from odd index.

        // Then calculate the key used to encrypt each half string
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
        
        // Print the two keys found
        System.out.println("Key found:\nKey 1\tKey 2\n" + key1 + "\t" + key2 );
        
        // Calculate and return the decrypted string
        String firstHalfStr = cc.encrypt(firstHalf, 26 - key1);
        String secondHalfStr = cc.encrypt(secondHalf, 26 - key2);
        
        StringBuilder sb = new StringBuilder(firstHalfStr + secondHalfStr);
        
        for (int i = 0; i < firstHalfStr.length(); i++)
        {
            sb.setCharAt(2*i, firstHalfStr.charAt(i));
        }
        for (int i = 0; i < secondHalfStr.length(); i++)
        {
            sb.setCharAt(2*i + 1, secondHalfStr.charAt(i));
        }

        return sb.toString();
    }
    
    public void testDecryptTwoKeys()
    {
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        String result = decryptTwoKeys(message);
        System.out.println(result);
    }
}
