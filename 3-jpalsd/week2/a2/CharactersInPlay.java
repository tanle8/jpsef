
/**
 * Write a program to determine the characters in one of 
 * Shakespeare’s plays that have the most speaking parts
 * 
 * @author (Tan Le) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> charNames;
    private ArrayList<Integer> charNamesFreqs;
    
    public CharactersInPlay()
    {
        charNames = new ArrayList<String>();
        charNamesFreqs = new ArrayList<Integer>();
    }
    
    public void update(String person)
    {
        // if person is empty
        if (person.length() == 0)
        {
            return;
        }
        // Determine the name is in ArrayList charNames or not
        int personIdx = charNames.indexOf(person);
        // If not in the list, add this person to the list, add 1 in the counting.
        if (personIdx == -1)
        {
            charNames.add(person);
            charNamesFreqs.add(1);
        }
        else // If in the list, 
        {
            int charFreq = charNamesFreqs.get(personIdx);
            charNamesFreqs.set(personIdx, charFreq + 1);
        }
    }
}
