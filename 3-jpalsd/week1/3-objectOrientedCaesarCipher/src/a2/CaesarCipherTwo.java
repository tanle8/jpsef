
/**
 * Put together the CaesarCipherTwo class that
 * encrypts a message with two keys
 * (the same way as the previous lesson)
 * 
 * @author (Tan Le) 
 * @version (07-07-2018)
 */
import edu.duke.*;

public class CaesarCipherTwo {
    // Create the class's private fields
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    // Create the constructor
    public CaesarCipherTwo(int key1, int key2)
    {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);;
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);;
        mainKey1 = key1;
        mainKey2 = key2;
    }

    /**
     * This method returns a String that is the input encrypted using
     * the two shifted alphabets 
     * @param input the message we want to encrypt
     * @return encrypted the encrypted message from
     * the input message
     */
    public String encrypt(String input)
    {
        StringBuilder sb = new StringBuilder(input.toUpperCase()); 
        for (int i = 0; i < sb.length(); i++)
        {
            if (i % 2 == 0) // If current index is a even number
            {
        	    char currentChar = sb.charAt(i);
        	    int idx = alphabet.indexOf(currentChar); 
                if (idx != -1) {
                    currentChar = shiftedAlphabet2.charAt(idx);
                    sb.setCharAt(i, currentChar); 
                }
            }
            else            // The current index is an odd number
            {
    		    char currentChar = sb.charAt(i);
        	    int idx = alphabet.indexOf(currentChar); 
                if (idx != -1)
                {
                    currentChar = shiftedAlphabet1.charAt(idx);
                    sb.setCharAt(i, currentChar); 
                }
    		}
        }
        
        return sb.toString();
    }

    /**
     * This method decrypts a input encrypted message and return the 
     * original message
     * @param input the encrypted message
     * @return decrypted the original message before encrypting
     */
    public String decrypt(String input)
    {
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey2, 26 - mainKey1);
        return cc.encrypt(input);

    }
}
