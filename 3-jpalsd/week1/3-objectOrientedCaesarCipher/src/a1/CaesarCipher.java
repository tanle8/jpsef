
/**
 * Put together the `CaesarCipher` class from the lesson
 * and add a decrypt method to decrypt with the same key
 * in Object-Oriented way.
 * 
 * @author (Tan Le) 
 * @version (07-07-2018)
 */

public class CaesarCipher {
    // Create private fields for the `alphabet` and `shiftedAlphabet`
    private String alphabet;
    private String shiftedAlphabet;
    // Create another private field using in decrypt method
    private int mainKey;
    
    // Create constructor `CaesarCipher`, this method initialize all
    // the private fields of the class
    public CaesarCipher(int key)
    {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    
    // Create encrypt method
    public String encrypt(String input)
    {
        StringBuilder encrypted = new StringBuilder(input);

        for (int i = 0; i < encrypted.length(); i++)
        {
            char currentChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currentChar));
            if (idx != -1)
            {
                if (currentChar == Character.toUpperCase(currentChar))
                {
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
                else
                {
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
            }
        }
        
        return encrypted.toString();
    }
    // Create decrypt method
    public String decrypt(String input)
    {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        String decrypted = cc.encrypt(input);
        
        return decrypted;
    }   
}
