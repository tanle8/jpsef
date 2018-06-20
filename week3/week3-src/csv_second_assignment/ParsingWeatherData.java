
/**
 * Write a description of ParsingWeatherData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import org.apache.commons.csv.*;
import edu.duke.FileResource;
import java.io.*;
import edu.duke.DirectoryResource;


public class ParsingWeatherData {

    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        // Start with smallestSoFar as nothing
        CSVRecord smallestSoFar = null;
        // For each row (currentRow) in the CSV file
        for (CSVRecord currentRow : parser)
        {
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar);
        }
        
        return smallestSoFar;
    }
    
    public void testColdestHourInFile()
    {
        FileResource fr = new FileResource("../../week3-data/nc_weather/2015/weather-2015-01-01.csv");
        CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + smallest.get("TemperatureF") + " at " + smallest.get("TimeEST"));
    }
    
    public String fileWithColdestTemperature()
    {
        File fileName = null;
        CSVRecord coldestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // Iterate over files
        for (File f : dr.selectedFiles())
        {
            // Now we have this file, create a file resource
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord currentRow = coldestHourInFile(parser);
            
            if (coldestSoFar == null)
            {
                coldestSoFar = currentRow;
                fileName = f;
            }
            else
            {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if ((currentTemp < lowestTemp) && (currentTemp != -9999))
                {
                    coldestSoFar = currentRow;
                    fileName = f;
                }
            }
        }
        
        return fileName.getAbsolutePath();   
    }
    
    public void testFileWithColdestTemperature()
    {
        String fileWithColdestTemp = fileWithColdestTemperature();
        File f = new File(fileWithColdestTemp);
        // Get filename
        String fileName = f.getName();
        System.out.println("Coldest day was in file " + fileName);
        
        FileResource fr = new FileResource(f);
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestTemp = coldestHourInFile(parser);
        System.out.println("Coldest temperature on that day was " + lowestTemp.get("TemperatureF"));
        
        System.out.println("All the Temperatures on the coldest day were:");
        CSVParser parser2 = fr.getCSVParser();
        for (CSVRecord currentRow : parser2)
        {
            double temp = Double.parseDouble(currentRow.get("TemperatureF"));
            String date = currentRow.get("DateUTC");
            System.out.println(date + " " + temp);
        }
    }
    
    public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar)
    {
        // If largestSoFar is nothing
        if (smallestSoFar == null)
        {
            smallestSoFar = currentRow;
        }
        // Otherwise
        else
        {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
            // Check if currentRow's temperature < smallestSoFar
            if (currentTemp < smallestTemp)
            {
                // If so update smallestSoFar to currentRow
                smallestSoFar = currentRow;
            }
        }
        
        return smallestSoFar;
    }
}
