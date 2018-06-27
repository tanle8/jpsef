
/**
 * This program transforms words from a file into another form,
 * such as replacing vowels with an asterix
 * 
 * @author (Tan Le) 
 * @version (27-06-2018)
 */


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
}
