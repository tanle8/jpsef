
/**
 * TestCaesarCipher includes the methods: halfOfString, countLetters, maxIndex, getKey
 * 
 * @author (Tan Le) 
 * @version (09-07-2018)
 */
import edu.duke.FileResource;

public class TestCaesarCipher {
    // halfOfString
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
    
    // countLetters
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
    
    // maxIndex
    public int maxIndex(int[] frequencies)
    {
        int maxValueIdx = 0;
        for (int i = 0; i < frequencies.length; i++)
        {
            System.out.println(frequencies[i] + "\t");
            if (frequencies[i] > frequencies[maxValueIdx])
            {
                maxValueIdx = i;
            }
        }   
        return maxValueIdx;
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

    // breakCaesarCipher
    public String breakCaesarCipher(String input)
    {
        String encrypted1 = halfOfString(input, 0);
        String encrypted2 = halfOfString(input, 1);
        int key1 = getKey(encrypted1);
        int key2 = getKey(encrypted2);
        CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
        String decrypted = cc.decrypt(input);

        return decrypted;
    }

    // simpleTests
    public void simpleTests()
    {
        // Read in a file as a String
        FileResource fr = new FileResource();
        String message = fr.asString();

        // Create a `CaesarCipherTwo` object with keys 17 and 3
        CaesarCipherTwo cc = new CaesarCipherTwo(17, 3);

        // Encrypt the String using the `CaesarCipherTwo` object
        String encrypted = cc.encrypt(message);

        // Print the encrypted String
        System.out.println(encrypted);

        // Decrypt the encrypted String using the `decrypt` method
        String decrypted = cc.decrypt(encrypted);

        // Print the decrypted string
        System.out.println(decrypted);
        
        // Break the Caesar cipher on the encrypted string
        String decrypted2 = breakCaesarCipher(encrypted);
        System.out.println(decrypted2);
    }
}
