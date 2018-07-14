
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
    
    /**
    * Extract the possible character name from a line
    * @return 
    * */
    private String getCharacter(String line)
    {
        String[] splitLine = line.split("\\.");
        return splitLine[0].trim().toUpperCase();
    }



    /**
    * This method should update the two ArrayList
    * Adding the character's name if it not in already there
    * Counting this line as one speaking part for this person
    * @param person a string is the name of character
    */
    public void update(String person)
    {
        // if person is empty
        if (person.length() == 0)
        {
            return;
        }
        // Determine the name is in ArrayList charNames or not
        int personIdx = charNames.indexOf(person);
        // If not in the list, add this person to the list, add 1 in the counting ArrayList.
        if (personIdx == -1)
        {
            charNames.add(person);
            charNamesFreqs.add(1);
        }
        else // If the name is in the list, 
        {
            int charFreq = charNamesFreqs.get(personIdx);
            charNamesFreqs.set(personIdx, charFreq + 1);
        }
    }

    
    public void findAllCharacters()
    {
        // Open a file
        FileResource resource = new FileResource();
        // For each line
        for (String line : resource.lines())
        {
            if (line.indexOf('.'))
            {
                update(getCharacter(line));
            }
        }

    }

    /**
     * This method returns an int that is the index
     * location of the largest value in `myFreqs`.
     * If there is a tie, then return the first such value.
     */
    public int findIndexOfMax()
    {
        int idxOfMax = 0;
        int largestSoFar = charNamesFreqs.get(idxOfMax);
        for (int i = 0; i < charNamesFreqs.size(); i++)
        {
            int currentFreq = charNamesFreqs.get(i);
            if (currentFreq > largestSoFar)
            {
                idxOfMax = i;
                largestSoFar = currentFreq;
            }
        }

        return idxOfMax;
    }

    /**
    * This method should print out the `names` of all those characters
    * that have exactly number speaking parts, where number is greater
    * than or equal to `num1` and less than or equal to `num2`.
    * @param num1  
    * @param num2
    * */
    public void charactersWithNumParts(int num1, int num2)
    {
        for (int i = 0; i < charNames.size(); i++)
        {
            int currFreq = charNamesFreqs.get(i);
            if (currFreq >= num1 && currFreq <= num2)
            {
                String currName = charNames.get(i);
                System.out.println(currName + "\t" + currFreq + "\n");
            }
        }
    }

    public void tester()
    {
        findAllCharacters();
        // Find main characters
        // In the index of the main character
        int mainCharacterIdx = findIndexOfMax();
        // Get main character's name
        String mainCharacterName = charNames.get(mainCharacterIdx);
        // Get main character's speking count
        int mainCharacterParts = charNamesFreqs.get(mainCharacterIdx);
        // Print out the name of main character and number of speaking parts
        System.out.println("The main character is: " + mainCharacterName \
                            + " with number of speaking parts: " + mainCharacterParts);
        // Test charactersWithNumParts
        System.out.println("3. charactersWithNumParts testing: \n");
        charactersWithNumParts(55, 150);
    }
}
