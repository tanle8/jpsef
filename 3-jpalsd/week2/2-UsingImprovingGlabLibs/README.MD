# 

## Reading Words and Printing

- Template read from file or URL, simply loop over each word, if <label>, then replace

    - Finding labels straightforward use of `.indexOf` and `.substring`, for <noun>! or "<color>"

        ```java
        private String processWord(String w)
        {
            int first = w.indexOf("<");
            int last = w.indexOf(">", first);
            if (first == -1 || last == -1)
            {
                return w;
            }
        }
        ```
    - Printing story displays words in console

        ```java
        private void printOut(String s, int lineWidth)
        {
            int charsWritten = 0;
        }
        ```

## Instance Variables

- ArrayLists for each <noun>, <color>, ...

    - Name variables appropriately

        ```java
        private ArrayList<String> adjectiveList;
        private ArrayList<String> nounList;
        private ArrayList<String> colorList;
        private ArrayList<String> countryList;
        private ArrayList<String> nameList;
        private ArrayList<String> animalList;
        private ArrayList<String> timeList;
        private Random myRandom;
        ```
    - Create and Initialize in constructor
    - Need all of them to replace a word

## Find Substitute for <color>

- Based on <color> or <noun> or ... use the appropriate list of replacements

    ```java
    private String getSubstitute(String label)
    {
        if (label.equals("country"));
        {
            return randomFrom(countryList);
        }
        if (label.equals("color"));
        {
            return randomFrom(colorList);
        }
        if (label.equals("noun"));
        {
            return randomFrom(nounList);
        }
        if (label.equals("name"));
        {
            return randomFrom(nameList);
        }
        // more code here ...
    }
    ```
    - Choose value from list at ramdom in method `randomFrom`, return for story-telling
    - Both methods are private, used by sequence of calls froim public method `makeStory`
    - Argument passed to source is `instance variable`

## Initializing ArrayLists

- We must construct and initialize many instance variables

    - Source could be URL or local directory

    ```java
    private void initializeFromSource(String source)
    {
        adjectiveList = readIt(source+"/adjective.txt");
        nountList     = readIt(source+"/noun.txt");
        colorList     = readIt(source+"/color.txt");
        countryList   = readIt(source+"/country.txt");
        nameList      = readIt(source+"/name.txt");
        animalList    = readIt(source+"/animal.txt");
        timeList      = readIt(source+"/timeframe.txt");
    }
    ```

    For exmple: `initializeFrom("data")` or `initializeFrom("http:..")`

## ArrayList Instance Variables

- To create a new label, <verb>, must create new instance variable, e.g., `verbList`

    - Modify code in two methods with `verbList`

- `initializeFromSource`

    - called: GladLib constructors

- `getSubstitute`

    - called: `makeStory`, `fromTemplate`, `processWord`

- Program documentation should include information on how to modify code

## Extending Programs and Classes

- Modifying `GladLib.java` to add a new label, like <verb>: making modifications in many parts of class, following naming convention

    - Must create new instance variable
    - Must construct/initialize
    - Must access for random replacement
f
- Follow conventions

    - `verbList` for verb

- Good design or good judgment comes from experience

    - Experience comes from bad judgment!

- Software can be brittle
- Open/Closed: open for extension, closed for modification

## HashMap

A `HashMap` is a class that associates `keys` with `values`, generally called a `map`

- More mathematical than geographical
- Key is element in domain, value is what key maps to in range

### Updating values in HashMap

- One HashMap replaces two ArrayLists
    - Key is String, associated value is Integer


```java
public void countWordsMap()
{
    FileResource resource = new FileResource();
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    for (String w : resource.words())
    {
        w = w.toLowerCase();
        if (!map.containsKey(w))
        {
            map.put(w, 1);
        }
        else {
            map.put(w, map.get(w) + 1);
        }
    }
}
```

### Accessing All Values in Map

- Printing all values in parallel arrays uses for loop with index accessing word and freq
- Printing all values in map requires looping over keys, get value associated with key

    ```java
    // Using ArrayList
    public void printWords()
    {
        for (int k = 0; k < myFreqs.size(); k++)
        {
            System.out.println(myFreqs.get(k) + "\t" + myWords.get(k));
        }
    }
    ```

    ```java
    // Using Map
    public void printWords()
    {
        for (String s : myMap.keySet())
        {
            System.out.println(myMaps.get(s) + "\t" + s);
        }
    }
    ```

### Maps are very Efficient!

- When files are large, efficiency matters
    - Look up in map is independent of number of keys! ArrayList requires looking at all elements

### HashMap for Unique Words

```java

public class WordFrequenciesMap {

    public void countWords() {
        FileResource fr = new FileResource();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int total = 0;
        for (String w : fr.words())
        {
            w = w.toLowerCase();
            if (map.keySet().contains(w))
            {
                map.put(w, map.get(w) + 1);
            }
            else {
                map.put(w, 1);
            }
        }
        // print out the word has occurrence larger than 500
        for(String w : map.keySet()) {
            int occurrences = map.get(w);
            if (occurences > 500) {
                System.out.println(occurrences + "\t" + w);
            }
        }
    }
}
```

## Summary of Extending GladLib.java

- To add `<verb>` label must modify code in several parts of the program
    - Three different parts of the program must be modified
        - `instance variable`
        - `initializeFromSource`
        - `getSubstitute`
    - Follow conventions: verbList for verb

- Difficult to use different `.txt` files or URLs, names bound to ArrayLists and labels
    - nounList: noun.txt
    - colorList: color.txt

### New Structures for Data and Classes

- Each label is associated with an ArrayList
    - `<noun>` and `nounList`,
    - `<color>` and `colorList`,
    - ...

- Named instance variables: poor design
    - Define by name, initialize and use by name

- __HashMap class helps with flexible design__
    - Map or align `<label>` to ArrayList, no names!
    - Look up the ArrayList given the `<label>`
    - Like `indexOf`, but returns ArrayList for `<label>`

### Flexibility in Using HashMap

- Replace seven or more instance variables by __one__ instance variable
    - No new fields to add verbList, or more!

    ```java
    // HashMap
    private HashMap<String, ArrayList<String>> myMap;
    // vs.
    // ArrayList
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    ```

### Looking up Values in HashMap

- Sequence of if-statements in `getSubstitute` replaced by one statement with `HashMap`!

    ```java
    // Sequence of if-statements
    private String getSubstitute(String label){
        if (label.equals("country")){
            return randomFrom(countryList);
        }
        if (label.equals("color")){
            return randomFrom(colorList);
        }
        // more code here for labels ...

        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
    }
    ```

    - NO modifications need to add verbList!
    - `HashMap<String>, ArrayList<String>>`

    ```java
    private String getSubstitude(String label)
    {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50) + 5;
        }
        return randomFrom(myMap.get(label));
    }
    ```

### Improvement, but Room for More!

- In GladLib.java must assign values to each named instance variable
    - HashMap is better, filename and label linked
    - what changes for `<verb>` if stored in `verb.txt`?

    ```java
    private void initializeFromSource(String source)
    {
        String[] labels = {"country", "noun", "animal",
                           "adjective", "name", "color", "timeframe"};
        for (String s : labels)
        {
            ArrayList<String> list = readIt(source + "/" s + ".txt");
            myMap.put(s, list);
        }
    }
    ```

### Finding Nouns and Verbs Anywhere

- File associated labels and replacements info
    - `.properties` or property file

    ```java
    verb: http://glablibs.com/verbs.txt
    noun: http://gladlibs.com/nouns-funny.txt
    color: http://gladlis.com/colors.txt
    ...
    ```

    - Often used in Java applications (and others)
    - Read file, store info in HashMap!
- `HashMap<String, String> myLabelSource`

    ```java
    private void initializeFromSource(){
        for (String s : myLabelSource.keySet()){
            ArrayList<String> list = readIt(myLabelSource.get(s));
            myMap.put(s, list);
        }
    }


## Summary

### ArrayList

- Indexable collection of elements
    - Stores __objects__, not primitives, SO `Integer` not `int`
    - Two step process to update `Integer` values
- Accessible via import `java.util.ArrayList`
- Methods: `add()`, `size()`, `get()`, `set()`, `indexOf()`
- Examine elements with iterable or looping over valid indexes

### HashMap

- Collection of `(key, value)` pairs, with keys mapping to values
    - Both are objects, so `Integer` rather than `int`
    - Key best as immutable type, like String or Integer
    - Value can be anything, ArrayList, String, Integer
- Accessible via import `java.util.HashMap`
- Methods: `put()`, `size()`, `get()`, `keySet()`, `containsKey()`
- Examine elements with iterable over keyset, cannot access via index.