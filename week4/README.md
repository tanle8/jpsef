# Overview

This module wraps up the course with a mini project that ties together the different practices, skills, and libraries you have gained across the course! Using data on the popularity of different baby names in the United States from the past several decades, you will be able to compare different names’ popularity over time. While the data we have collected for this course is from the United States, we welcome you to share data from other countries in the course discussion forums. Good luck with the mini project!

Finding information in One File

- Using the edu.duke library

  - To access the file  - Create a fileResource for `jobXYZW.txt`
  - Call gerCSVParser(false) - no header row
  - Access CSVRecord data by index: 0-based

```java
public void readOneFile(int year)
{
    String fname = "data/yob" + year + ".txt";
    FileResource fr = new FileResource(fname);
    CSVParser parser = fr.getCSVParser(false);
    for (CSVRecord rec : parser)
    {
        String name = rec.get(0);
        String gender = rec.get(1);
    }
}
```

## Assignment - MiniProject Exercise Guide

For this assignment, we are providing data on baby names from the United States and you will answer questions about this data. The data files:
- give information on the __first names__ of people born in a particular year. We have data from 1880 through 2014 on both boys and girls names.
- You can download a .zip folder of all baby name data by clicking here.

For example, below are two pictures of parts of the file "__yob2014.csv__", for names of babies born in 2014. On the left is the top of the file which shows that _Emma_ is the most popular name, the _F_ is for `female` and the _20799_ indicates the number of Emma’s born in 2014.

The file lists all the girls first, and they are listed in order based on the number of births, from largest numbers to smallest numbers.

On the right is another snapshot of the file, showing the end of the girls and the start of the boys.

You can see that _Noah_ was the most popular boys name in 2014, the _M_ indicates a `male`, and _19144_ is the number of boys named Noah that year.

Also notice there are no headers in this file. The video showed you how to access the fields in a `.csv` file when there are no headers.

<img src="https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/VA4SZ2hiEeWQ2QoGQ8zX1w_11b7ad24a4b160aa1282f5b2a08027db_Screen-Shot-2015-10-01-at-1.30.11-PM.png?expiry=1529712000000&hmac=W5DOO5xo0iuadhFDKAmNYW6pkqVbZ9zBkZ0daum28z0">

Since these data files are quite large, we will also provide three small files with fake data for testing. We show the three files called "yob2012short.csv", "yob2013short.csv" and "yob2014short.csv" below in that order. The three files have only ten lines each, 5 girls and 5 boys names, and smaller numbers to work with. You can download a .zip folder of the shortened baby name data by clicking here.

<img src="https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/Yy81B2hiEeW7ghK3HGMBQw_32775231da216cd474e1a9434706d8c3_Screen-Shot-2015-10-01-at-1.30.30-PM.png?expiry=1529712000000&hmac=QcoO_YtCv149pT1u12vNNUtHy_9L_uG9ZF0fY_tqKPw">

You will write a program with several methods and tester methods to test each method you write. You should start with understanding the methods shown in the video. Specifically you should write the following methods:

-(1) Modify the method __totalBirths__ (shown in the video for this project) to also:
  - `print the number of girls names` ,
  - `the number of boys names` and
  - `the total names in the file`.

-(2) Write the method named __getRank__ that:
  - has three parameters:
    - an integer named year,
    - a string named name, and
    - a string named gender (F for female and M for male).
  - This method returns the `rank of the name` in the file for the given __gender__, where rank 1 is the name with the __largest number__ of births.
    - If the name is not in the file, then `-1` is returned.
  - For example, in the file "__yob2012short.csv__":
    - given the name `Mason`, the year `2012` and the gender `M`, the number returned is __2__, as Mason is the boys name with the second highest number of births.
    - Given the name Mason, the year `2012` and the gender `F`, the number returned is __-1__ as Mason does not appear with an F in that file.

-(3) Write the method named __getName__ that:

  - has three parameters:
    - an integer named year,
    - an integer named rank, and
    - a string named gender (F for female and M for male).
  -  This method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest number of births.
  - If the rank does not exist in the file, then “NO NAME” is returned.

-(4) What would your name be if you were born in a different year? Write the void method named __whatIsNameInYear__ that:
  - has four parameters:
    - a string name,
    - an integer named year representing the year that name was born,
    - an integer named newYear and
    - a string named gender (F for female and M for male).
  - This method determines what name would have been named if they were born in a different year, based on the same popularity. That is, you should determine the rank of name in the year they were born, and then print the name born in newYear that is at the same rank and same gender. For example, using the files "yob2012short.csv" and "yob2014short.csv", notice that in 2012 Isabella is the third most popular girl's name. If Isabella was born in 2014 instead, she would have been named Sophia, the third most popular girl's name that year. The output might look like this:

    ```text
    Isabella born in 2012 would be Sophia if she was born in 2014.
    ```

Link to FAQ page for this course: http://www.dukelearntoprogram.com/course2/faq.php

