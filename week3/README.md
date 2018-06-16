# Module Learning Outcomes: CSV Files and Basic Statistics in Java Module

A common format for storing __tabular data__ (any data organized into columns and rows) is in __comma separated values (CSV)__ files. In this module, you will learn how to `analyze` and `manipulate` data from multiple CSV data files using a powerful open-source software package: __Apache Commons CSV__. Using this library will empower you to solve problems that could prove too complex to solve with a spreadsheet.

By the end of this module, you will be able to:

- Use the open-source Apache Commons CSV package in your own Java programs;
- Access data from one or many CSV files using Java;
- Convert strings into numbers;
- Understand how to use “null” in Java programs (when you want to represent “nothing”);
- Devise an algorithm (and implement in Java) to answer questions about CSV data; and
- Analyze CSV data across multiple CSV files (for example, find maximums, minimums, averages, and other simple statistical results).

__Contents:__

A. Which countries export ...?

    1. CSV Data
    2. Using CSV libraries
    3. Developing an Algorithm
    4. Translating into Code
    5. CSVExport
    6. Programming Exercise: Parsing Export Data
    7. Practice Quiz

B. Weather CSV Problem

    1. Comma Separated Values
    2. Converting Strings to Numbers
    3. Developing an Algorithm
    4. Java for nothing - null: When you don't have an Object
    5. Translating into Code
    6. Testing Code
    7. Multiple Datasets
    8. Refactored
    9. CSVMax
    10. Programming Exercise: Parsing Weather Data
    11. Practice Quiz: Weather Data

C. Review

    Quiz: CSV files and basic Statistics in Java

## Programming Exercise 1 - Parsing Export Data

The CSV file `exportdata.csv` has information on the export products of countries; you can download a .zip folder with this and other export data files [here](http://www.dukelearntoprogram.com/course2/data/exports.zip). In particular it has three column headers labeled __Country__, __Exports__, and __Value__ (dollars).

- The `Country` column represents a country from the world,
- The `Exports` column is a list of export items for a country, and
- The `Value` (dollars) column is the dollar amount in millions of their exports in the format of a dollar sign, followed by an integer number with a comma separator every three digits from the right. An example of such a value might be “$400,000,000”.

The CSV file `exports_small.csv` is a smaller version of the file above with the same columns that you may find helpful in testing your program. We show a picture of it here.

<img src=week3-assets/images/1.png>

Write the following program, be sure to see the sample program in this lesson's videos.

1. Write a method named `tester` that will create your `CSVParser` and call each of the methods below in parts 2, 3, 4, and 5. You would start your code with:

    ```java
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    ```

    Each time you want to use the parser with another method, you will need to reset the parser by calling `fr.getCSVParser()` again to get a new parser.

    ```java
    parser = fr.getCSVParser();
    ```

2. Write a method named `countryInfo` that
    - has two parameters, `parser` is a CSVParser and `country` is a String.
    - This method returns a string of information about the country or returns “NOT FOUND” if there is no information about the country.
    - The format of the string returned is the `country`, followed by “: “, followed by a list of the `countries’ exports`, followed by “`: `“, followed by the `countries export value`.
        - For example, using the file `exports_small.csv` and the country _Germany_, the program returns the string:

        ```text
        Germany: motor vehicles, machinery, chemicals: $1,547,000,  000,000
        ```

3. Write a void method named `listExportersTwoProducts` that
    - has three parameters, `parser` is a CSVParser, `exportItem1` is a String and `exportItem2` is a String.
    - This method prints the names of all the countries that have both `exportItem1` and `exportItem2` as export items.
    - For example, using the file `exports_small.csv`, this method called with the items “gold” and “diamonds” would print the countries

        ```text
        Namibia
        South Africa
        ```

4. Write a method named `numberOfExporters`, which:
    - has two parameters, `parser` is a CSVParser, and `exportItem` is a String.
    - This method returns the number of countries that export `exportItem`.
    - For example, using the file `exports_small.csv`, this method called with the item “gold” would return _3_.

5. Write a void method named `bigExporters` that
    - has two parameters, `parser` is a CSVParser, and `amount` is a String in the format of a dollar sign, followed by an integer number with a comma separator every three digits from the right. An example of such a string might be “$400,000,000”.
    - This method prints the names of countries and their Value amount for all countries whose Value (dollars) string is longer than the amount string.
    - You do not need to parse either string value as an integer, just compare the lengths of the strings. For example, if `bigExporters` is called with the file `exports_small.csv` and amount with the string $999,999,999, then this method would print eight countries and their export values shown here:

        ```text
        Germany $1,547,000,000,000
        Macedonia $3,421,000,000
        Malawi $1,332,000,000
        Malaysia $231,300,000,000
        Namibia $4,597,000,000
        Peru $36,430,000,000
        South Africa $97,900,000,000
        United States $1,610,000,000,000
        ```

## Programming Exercise 2 - Parsing Weather Data