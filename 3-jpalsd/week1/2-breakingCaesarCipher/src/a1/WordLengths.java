
/**
 * This program figures out the most common word length of words from a file.
 * 
 * @author (Tan Le) 
 * @version (05-07-2018)
 */

import edu.duke.FileResource;

public class WordLengths {
    
    public int[] countWordLengths(FileResource resource, int[] counts)
    {
        for (String word: resource.words())
        {
            int n = word.length();  // 
            int len = 0;
            for (int i = 0; i < n; i++)
            {
                if (Character.isLetter(word.charAt(i)))
                {
                    len += 1;
                }
            }
            if (len <= counts.length && len != 0)
            {
                counts[len - 1] += 1;
            }
            else
            {
                System.out.println("The length of the array counts");
            }
        }
        return counts;
    }
    
    public void testCountWordLengths()
    {
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        int[] result = countWordLengths(resource, counts);
        
        for (int i = 0; i < counts.length; i++)
        {
            System.out.println(result[i] + " words of length " + (i + 1) + ": " );
        }
    }
}
