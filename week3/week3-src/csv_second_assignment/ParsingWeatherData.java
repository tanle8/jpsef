
/**
 * Write a description of ParsingWeatherData here.
 * 
 * @author (Tan Le) 
 * @version (20-09-2018)
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
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar, "TemperatureF");
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
            String date = currentRow.get("DateUTC");
            double temp = Double.parseDouble(currentRow.get("TemperatureF"));
            System.out.println(date + " " + temp);
        }
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        CSVRecord lowestHumRecord = null;
        int currentHum;
        int lowestHum;
        
        for (CSVRecord currentRow : parser)
        {
            if (lowestHumRecord == null)
            {
                lowestHumRecord = currentRow;
            }
            else
            {
                if (!currentRow.get("Humidity").equals("N/A") && !lowestHumRecord.get("Humidity").equals("N/A"))
                {
                    currentHum = Integer.parseInt(currentRow.get("Humidity"));
                    lowestHum = Integer.parseInt(lowestHumRecord.get("Humidity"));
                    
                    if (currentHum < lowestHum)
                    {
                        lowestHumRecord = currentRow;
                    }
                }
            }
        }
        
        return lowestHumRecord;
    }
    
    
    public void testLowestHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumRecord = lowestHumidityInFile(parser);
        
        System.out.println("Lowest Humidity was " + lowestHumRecord.get("Humidity") + " at " + lowestHumRecord.get("DateUTC"));
    }
    
    public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar, String columnName)
    {
        // If largestSoFar is nothing
        if (smallestSoFar == null)
        {
            smallestSoFar = currentRow;
        }
        // Otherwise
        else
        {
            double currentTemp = Double.parseDouble(currentRow.get(columnName));
            double smallestTemp = Double.parseDouble(smallestSoFar.get(columnName));
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
