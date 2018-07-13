# Assignment 1: Most Frequent Word

You will write a program to determine the word that occurs the most often in a file. If more than one word occurs as the most often, then return the first such word found. You should make all words lowercase before counting them. Thus, “This” and “this” will both be counted as the lowercase version of “this”. You should not consider punctuation, so “end” and “end,” will be considered different words. Use the __WordFrequencies__ program in the lesson as a starting point.

Specifically, you should do the following:

- Create a new project in BlueJ and then create a new class called `WordFrequencies`. Put all the following items in this class.
- Create two private variables.
    - One is called `myWords` and should be an ArrayList of type String to store unique words from a file, and
    - one is called `myFreqs` and should be an ArrayList of type Integer. The kth position in `myFreqs` should represent the number of times the kth word in `myWords` occurs in the file.
- Write a constructor `WordFrequencies`, and initialize the private variables.
- Write a void method `findUnique` that has no parameters.
    - This method should first clear both `myWords` and `myFreqs`, using the __.clear()__ method. 
    - Then it selects a file and then iterates over every word in the file, putting the unique words found into `myWords`.
    - For each word in the kth position of `myWords`, it puts the count of how many times that word occurs from the selected file into the kth position of `myFreqs`, as was demonstrated in the lesson.
- Write a void `tester` method that has no parameters.
    - This method should call `findUnique`.
    - Then print out the number of unique words, and for each unique word, print the frequency of each word and the word, as was demonstrated in the lesson.
- Write the method `findIndexOfMax` that has no parameters.
    - This method returns an int that is the index location of the largest value in `myFreqs`.
    - If there is a tie, then return the first such value.
- Add code to the `tester` method to determine and print the word that occurs the most often in a selected file and how many times it occurs. You should find it helpful to call `findIndexOfMax`.
    - For example, if the file were `testwordfreqs.txt`:
    ```text
        This is a test. Yes a test of a test. Test.
    ```
    - Then the output would be:

        ```text
        Number of unique words: 7
        1 this
        1 is
        3 a
        3 test.
        1 yes
        1 test
        1 of
        The word that occurs most often and its count are: a 3
        ```

We are ignoring `punctuation`, so note that “test.” and “test” are different, as the first one has a period with it. Also note that there is a tie—two words are counted three times; you should return the first such word found which is “a”.
