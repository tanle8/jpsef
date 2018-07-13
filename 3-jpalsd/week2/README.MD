
Example on how the ArrayList structure work

Counting different words

```java
import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    // Initialize myWords to an ArrayList
    public WordFrequencies()
    {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public void finUniques()
    {
        // Create a FileResource object with no parameter to allow open our file.
        FileResource resource = new FileResource();

        // Loop over every word
        for (String s : resource.words())
        {
            // Turn the word s to lowercase
            s = s.toLowerCase();
            // Find the index of the word s in the ArrayList myWords
            int index = myWords.indexOf(s);
            if (index == -1)
            {
                myWords.add(s);
                myFreqs.add(1);
            }
            else    // If I've seen this word before
            {
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }

    public void tester()
    {
        findUnique();
        System.out.prinln("# unique words: " + myWords.size());
        for (int i = 0; i < myWords.size(); i++)
        {
            System.out.println(myFreqs.get(k) + "\t" + myWords.get(k));
        }
    }
}

```

## Arrays and ArrayList

- `String[] a` and `ArrayList<String> b`
    - access elements: `a[k]` compared `b.get()` and `b.set()`

- `int[]ac` and `ArrayList<Integer> bc`
    - Concerns with int/Integer conversions
    - Incrementing in an array is easier than in an ArrayLlist
        - ac[index]++ works
        - bc.get(index)++ DOES NOT WORK

- Arrays cannot grow! <-- a BIG concern

```java
import java.util.ArrayList;
import edu.duke.*;

public class WordsWithArrays
{
    private StorageResource myWords;

    public WordsWithArrays()
    {
        myWords = new StorageResource();
    }

    public void readWords()
    {
        myWords.clear();
        FileResource resource = new FileResource();
        for (String word : resource.words())
        {
            myWords.add(word.toLowerCase());
        }
    }

    public boolean contains(String[] list, String word, int totalNumberOfWord)
    {
        for (int i = 0; i < totalNumberOfWord; i++)
        {
            if(list[k]).equals(word))
            {
                return true;
            }
        }
        return false;
    }

    public int numberOfUniqueWords()
    {
        int numStored = 0;
        String[] words = new String[myWords.size()];
        for (String s : myWords.data())
        {
            if(!contains(words, s, numStored))
            {
                words[numStored] = s;
                numStored++;
            }
        }
        return numStored;
    }

    public void tester()
    {
        readWords();
        System.out.prinln("number of words read: " + myWords.size());
        int unique = numberOfUniqueWords();
        System.out.println("array count " + unique);
    }
}
```

## Summary

### ArrayList

- Indexable collection, like array, but growable!
    - Access via integer index, start with zero
    - import `java.util.ArrayList` or `java.util.*`
    - Create with generic: `ArrayList<data_type>`

- Common methods for ArrayList
    - `.add(elt)` -- added to end of ArrayList
    - `.size()` -- returns number of elements in ArrayList
    - `.get(index)` -- returns elements at index
    - `.set(index, elt)` -- assign elt to index location

- Access elements via indexing
    - Start with zero, loop to less than `.size()`
    - Access via `.get(index)`
    - Do not call `.remove()` during iteration

    ```java
        ArrayList<String> a = new ArrayList<String>();
        // add elements

        for(int k = 0; k < a.size(); k++) {
            String s = a.get(k);
            // process s
        }
    ```