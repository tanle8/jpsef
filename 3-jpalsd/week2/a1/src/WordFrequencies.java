package src;

/**
 * Write a description of WordFrequencies here.
 * 
 * @author (Tan Le) 
 * @version (13-07-2018)
 */

import java.util.ArrayList;
import edu.duke.FileResource;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies()
    {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public void findUnique()
    {
        // First clear both myWords and myFreqs
        myWords.clear();
        myFreqs.clear();

        // Select a file
        FileResource resource = new FileResource();
        // Loop over every word
        for (String word: resource.words())
        {
            // Turn word to lowercase
            word = word.toLowerCase();
            // Find the index of word in the ArrayList myWords
            int wordIdx = myWords.indexOf(word);
            // If word doesn't exist in myWords
            if (wordIdx == -1)
            {
                myWords.add(word);
                myFreqs.add(1);
            }
            else    // If the word is existed in myWords
            {
                int wordFreq = myFreqs.get(wordIdx);
                myFreqs.set(wordIdx, wordFreq + 1);
            }
        }
    }

    /**
     * This method returns an int that is the index location of the largest value in `myFreqs`.
     * If there is a tie, then return the first such value.
     */
    public int findIndexOfMax()
    {
        int idxOfMax = 0;
        int largestSoFar = myFreqs.get(idxOfMax);
        for (int i = 0; i < myFreqs.size(); i++)
        {
            int currentFreq = myFreqs.get(i);
            if (currentFreq > largestSoFar)
            {
                idxOfMax = i;
                largestSoFar = currentFreq;
            }
        }

        return idxOfMax;
    }


    public void tester()
    {
        // 1. findUnique tester
        findUnique();
        // Print the number of unique words
        System.out.println("The number of unique words: " + myWords.size());
        // For each unique word
        for (int i = 0; i < myWords.size(); i++)
        {
            System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
        }

        // 2. findIndexOfMax tester
        int idxMax = findIndexOfMax();
        
        String mostOftenWord = myWords.get(idxMax);
        int mostOftenWordFreq = myFreqs.get(idxMax);
        
        System.out.println("The word that occurs most often and its count are: \
                            " + mostOftenWord + "\t" + mostOftenWordFreq);
    }
}
