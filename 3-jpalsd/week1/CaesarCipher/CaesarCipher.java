
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
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(message);
        // Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);

        // Count from 0 to < length of encrypted (call it i)
        for (int i = 0; i < encrypted.length(); i++)
        {
            // Look at the ith character of encrypted (call it messageChar)
            char messageChar = encrypted.charAt(i);
            // Find the index of the messageChar in the alphabet (newChar)
            int idx = alphabet.indexOf(messageChar);
            // If messageChar is in the alphabet
            if (idx != -1)
            {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                // Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
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
        System.out.println(message);
        // Encrypt the string
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        // Decrypt the encrypted string
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }

}
