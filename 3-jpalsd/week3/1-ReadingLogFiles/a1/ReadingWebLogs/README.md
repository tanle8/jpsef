# Assignment: Reading Web Logs

In this assignment you will complete the program to read and print web logs that was described in the lesson.

You will start with the files provided, which include:

- The class __LogEntry__ from the lesson that has:
    - five private variables,
    - a constructor,
    - five get methods to access the private fields, and
    - a __toString__ method for printing out a LogEntry.
- The Class __LogAnalyzer__, which has been started for you.
- The Class __WebLogParser__, which we are providing. You should not edit this file—just use its __parseEntry__ method.
- The __Tester__ class from the lesson, which has been started for you.

Specifically, you should do the following:

- In the `LogAnalyzer` class you will need to
    - complete the constructor to initialize `records` to an empty ArrayList and
    - complete the `readFile` method to create a FileResource and to iterate over all the lines in the file.
    - For each line,
        - create a __LogEntry__ and store it in the `records` ArrayList. (Refer to the lecture on parsing log files for help.)

- In the `Tester` class you will need to complete the `testLogAnalyzer` method, which
    - creates a `LogAnalyzer` object,
    - calls `readFile` on the data file `short-test_log`, and then
    - calls `printAll` to print all the web logs.

Note: if your time zone is different from Durham, USA, you may want to temporarily change the time zone on your computer as the time zone setting of your computer affects the output value from the `getAccessTime` method.

Link to FAQ page for this course: http://www.dukelearntoprogram.com/course3/faq.php