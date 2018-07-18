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

    - verbList for verb

- Good design or good judgment comes from experience

    - Experience comes from bad judgment!

- Software can be brittle
- Open/Closed: open for extension, closed for modification