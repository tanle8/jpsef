Assignment 2: Words in Files
Write a program to determine which words occur in the greatest number of files, and for each word, which files they occur in.

For example, consider you are given the four files: brief1.txt, brief2.txt, brief3.txt, and brief4.txt.

brief1.txt is:

cats are funny and cute

brief2.txt is:

dogs are silly

brief3.txt is:

love animals cats and dogs

brief4.txt is:

love birds and cats

The greatest number of files a word appears in is three, and there are two such words: “cats” and “and”.

“cats” appears in the files: brief1.txt, brief3.txt, brief4.txt

“and” appears in the files: brief1.txt, brief3.txt, brief4.txt

To solve this problem, you will create a map of words to the names of files they are in. That is, you will map a String to an ArrayList of Strings. Then you can determine which ArrayList value is the largest (has the most filenames) and its key is thus, a word that is in the most number of files.

Specifically, you should do the following:

Create a new class called WordsInFiles. Put all the remaining listed items in this class.
Create a private variable to store a HashMap that maps a word to an ArrayList of filenames.
Write a constructor to initialize the HashMap variable.
Write a private void method named addWordsFromFile that has one parameter f of type File. This method should add all the words from f into the map. If a word is not in the map, then you must create a new ArrayList of type String with this word, and have the word map to this ArrayList. If a word is already in the map, then add the current filename to its ArrayList, unless the filename is already in the ArrayList. You can use the File method getName to get the filename of a file.
Write a void method named buildWordFileMap that has no parameters. This method first clears the map, and then uses a DirectoryResource to select a group of files. For each file, it puts all of its words into the map by calling the method addWordsFromFile. The remaining methods to write all assume that the HashMap has been built.
Write the method maxNumber that has no parameters. This method returns the maximum number of files any word appears in, considering all words from a group of files. In the example above, there are four files considered. No word appears in all four files. Two words appear in three of the files, so maxNumber on those four files would return 3. This method assumes that the HashMap has already been constructed.
Write the method wordsInNumFiles that has one integer parameter called number. This method returns an ArrayList of words that appear in exactly number files. In the example above, the call wordsInNumFiles(3) would return an ArrayList with the words “cats” and “and”, and the call wordsInNumFiles(2) would return an ArrayList with the words “love”, “are”, and “dogs”, all the words that appear in exactly two files.
Write the void method printFilesIn that has one String parameter named word. This method prints the names of the files this word appears in, one filename per line. For example, in the example above, the call printFilesIn(“cats”) would print the three filenames: brief1.txt, brief3.txt, and brief4.txt, each on a separate line.
Write the void method tester that has no parameters. This method should call buildWordFileMap to select a group of files and build a HashMap of words, with each word mapped to an ArrayList of the filenames this word appears in, determine the maximum number of files any word is in, considering all words, and determine all the words that are in the maximum number of files and for each such word, print the filenames of the files it is in. (optional) If the map is not too big, then you might want to print out the complete map, all the keys, and for each key its ArrayList. This might be helpful to make sure the map was built correctly.