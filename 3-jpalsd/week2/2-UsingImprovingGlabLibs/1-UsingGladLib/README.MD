# Assignment: Verbs and Fruits

Run the __GladLib.java__ program that is provided. You should also have a __data__ folder with several files. This program should generate a story using the file __madtemplate.txt__, which is also in the __data__ folder.

This program creates a story by replacing placeholder words such as `<noun>` by looking for a random word of that type. This approach uses multiple private ArrayLists, one for each type of word, to store each type of replacement. For example, one ArrayList stores different nouns. These nouns are initially read in from a file called `noun.txt` and stored in the _ArrayList_ named `nounList`. Whenever the templated word `<noun>` is found in the story, a random noun from the __nounList__ is used in place of `<noun>`.

You will now modify the `GladLib.java` file to handle two additional categories—verbs and fruits. Specifically, you should make the following adjustments to your program:

- Modify the program to handle replacing verbs with `<verb>` tags and fruits with `<fruit>` tags. You will read in choices of verbs from the file `verb.txt` and choices for fruit from the file `fruit.txt`. These files are already in the __data__ folder. There are several parts of the program that you will need to modify.

- Add private ArrayLists, one for verbs and one for fruits.
- Modify the method `initializeFromSource` to read the data from these two files.
- Modify the method `getSubstitute` to handle the replacements of `<verb>` and `<fruit>` with random words of those types.
- Modify the file `makeStory` to read in the template file `madtemplate2.txt` that also uses the `<verb>` and `<fruit>` tags.
- Run your program to make sure it works before making additional changes.
- Now modify your program so that once it uses a word, it never uses that word again.

    - You should __declare__ and __initialize__ an additional private `ArrayList` to keep track of words that have been seen.
    - HINT: You will need to modify the method `processWord`.
        - Once it finds a word to use, check to see if that word has been used before or not.
        - You should also be sure that you clear out this new ArrayList in `makeStory` before each run of your program.
        - The folder `datalong` with longer data files is provided.
    - Modify your program to print out the total number of words that were replaced right after the story is printed.
