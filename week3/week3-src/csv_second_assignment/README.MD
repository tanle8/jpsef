------------------------------------------------------------------------
This project is aim to find the useful information from data.
In details, we work with weather data which stored in CSV file.
------------------------------------------------------------------------

PROJECT TITLE: Parsing Weather Data
PURPOSE OF PROJECT: Find the useful weather information from data in CSV files.
VERSION or DATE: (06-20-2018)
HOW TO START THIS PROJECT:
AUTHORS: Tan Le
USER INSTRUCTIONS:

You will write a program to find the __coldest day__ of the year and other interesting facts about the `temperature` and `humidity` in a day.

To test your program, you will use the `nc_weather` data folder that has a folder for each year; you can download a `.zip` folder with these files by clicking here. In the year folder there is a CSV file for every day of the year; each file has the following information. For example: in the 2014 folder, we show parts of the file __weather-2014-01-08.csv__, the weather data from January 8, 2014.

You will write a program with several methods and tester methods to test each method you write. You should start with the methods from the lesson to find the hottest temperature in a day (and thus in a file) and the hottest temperature in many files and their tester methods. You can use these to write similar methods to find the coldest temperatures.

Specifically you should write the following methods.

1. Write a method named __coldestHourInFile__ that:
- has one parameter, a `CSVParser` named _parser_.
- This method returns the `CSVRecord` with the coldest temperature in the file and thus all the information about the coldest temperature, such as the hour of the coldest temperature.
- You should also write a void method named __testColdestHourInFile()__ to test this method and print out information about that coldest temperature, such as the time of its occurrence.
- __NOTE:__ Sometimes there was not a valid reading at a specific hour, so the temperature field says `-9999`. You should _ignore_ these bogus temperature values when calculating the lowest temperature.

2. Write the method __fileWithColdestTemperature__ that:
- has no parameters.
- This method should return a string that is the name of the file from selected files that has the coldest temperature.
- You should also write a void method named __testFileWithColdestTemperature()__ to test this method. Note that after determining the filename, you could call the method __coldestHourInFile__ to determine the coldest temperature on that day. When __fileWithColdestTemperature__ runs and selects the files for __January 1–3 in 2014__, the method should print out:

    ```text
    Coldest day was in file weather-2014-01-03.csv
    Coldest temperature on that day was 21.9
    All the Temperatures on the coldest day were:
    2014-01-03 05:51:00: 41.0
    2014-01-03 06:51:00: 39.0
    2014-01-03 07:51:00: 35.1
    2014-01-03 08:51:00: 30.9
    2014-01-03 09:51:00: 28.0
    2014-01-03 10:51:00: 25.0
    2014-01-03 11:51:00: 24.1
    2014-01-03 12:51:00: 23.0
    2014-01-03 13:51:00: 25.0
    2014-01-03 14:51:00: 26.1
    2014-01-03 15:51:00: 28.0
    2014-01-03 16:51:00: 30.0
    2014-01-03 17:51:00: 30.9
    2014-01-03 18:51:00: 33.1
    2014-01-03 19:51:00: 33.1
    2014-01-03 20:51:00: 33.1
    2014-01-03 21:51:00: 30.9
    2014-01-03 22:51:00: 28.9
    2014-01-03 23:51:00: 28.9
    2014-01-04 00:51:00: 26.1
    2014-01-04 01:51:00: 24.1
    2014-01-04 02:51:00: 24.1
    2014-01-04 03:51:00: 23.0
    2014-01-04 04:51:00: 21.9
    ```

3. Write a method named __lowestHumidityInFile__ that:
- has one parameter, a CSVParser named parser.
- This method returns the CSVRecord that has the lowest humidity. If there is a tie, then return the first such record that was found.
- __Note:__
  - that sometimes there is not a number in the Humidity column but instead there is the string “N/A”. This only happens very rarely. You should check to make sure the value you get is not “N/A” before converting it to a number.

  - Also note that the header for the time is either `TimeEST` or `TimeEDT`, depending on the time of year. You will instead use the `DateUTC` field at the right end of the data file to get both the date and time of a temperature reading.

- You should also write a void method named __testLowestHumidityInFile()__ to test this method that starts with these lines:

    ```java
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    CSVRecord csv = lowestHumidityInFile(parser);
    ```

    and then prints the lowest humidity AND the time the lowest humidity occurred. For example, for the file __weather-2014-01-20.csv__, the output should be:

    ```text
    Lowest Humidity was 24 at 2014-01-20 19:51:00
    ```

    __NOTE:__ If you look at the data for January 20, 2014, you will note that the Humidity was also 24 at 3:51pm, but you are supposed to return the first such record that was found.

4. Write the method __lowestHumidityInManyFiles__ that:
- has no parameters.
- This method returns a CSVRecord that has the lowest humidity over all the files. If there is a tie, then return the first such record that was found. - - You should also write a void method named _testLowestHumidityInManyFiles()__ to test this method and to print the _lowest_ humidity AND the _time_ the lowest humidity occurred. Be sure to test this method on two files so you can check if it is working correctly. If you run this program and select the files for January 19, 2014 and January 20, 2014, you should get:

    ```text
    Lowest Humidity was 24 at 2014-01-20 19:51:00
    ```

5. Write the method __averageTemperatureInFile__ that:
- has one parameter, a CSVParser named parser.
- This method returns a double that represents the average temperature in the file. You should also write a void method named __testAverageTemperatureInFile()__ to test this method. When this method runs and selects the file for January 20, 2014, the method should print out

    ```text
    Average temperature in file is 44.93333333333334
    ```

6. Write the method __averageTemperatureWithHighHumidityInFile__ that:
- has two parameters, a CSVParser named parser and an integer named value.
- This method returns a double that represents the average temperature of only those temperatures when the humidity was greater than or equal to value.
- You should also write a void method named `testAverageTemperatureWithHighHumidityInFile()` to test this method. When this method runs checking for humidity greater than or equal to 80 and selects the file for January 20, 2014, the method should print out

    ```text
    No temperatures with that humidity
    ```

    If you run the method checking for humidity greater than or equal to 80 and select the file March 20, 2014, a wetter day, the method should print out

    ```text
    Average Temp when high Humidity is 41.78666666666667
    ```
