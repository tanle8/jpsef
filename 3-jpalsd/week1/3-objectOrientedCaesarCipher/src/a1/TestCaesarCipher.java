
/**
 * .
 * 
 * @author (Tan Le) 
 * @version (07-072018)
 */
import edu.duke.FileResource;

public class TestCaesarCipher {
    // Include the methods `countLetters` and `maxIndex` that you wrote in the previous lesson.
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
            System.out.println(frequencies[i] + "\t");
            if (frequencies[i] > frequencies[maxValueIdx])
            {
                maxValueIdx = i;
            }
        }   
        return maxValueIdx;
    }
    
    // Write the void methods `simpleTests` ...
    public void simpleTests()
    {
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        CaesarCipher cc = new CaesarCipher(18);
        // Encrypt the string & Print the encrypted string
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        // Decrypt the previous encrypted string & Print the decrypted string
        String decrypted = cc.decrypt(encrypted);
        System.out.println(decrypted);
        // Break the Caesar cipher on the encrypted string
        breakCaesarCipher(encrypted);
    }
    
    // Write the method `breakCaesarCipher`
    public void breakCaesarCipher(String input)
    {
        int[] frequencies = countLetters(input);
        int maxIdx = maxIndex(frequencies);
        int key = maxIdx - 4;
        if (maxIdx < 4) {
            key = 26 - (4 - maxIdx);
        }
        CaesarCipher cc = new CaesarCipher(key);
        System.out.println("Encrypted message: \t" + input);
        System.out.println("\nThe encrypting key: \t" + key);
        System.out.println("\nDecrypted message: \t" + cc.decrypt(input));
    }
}
