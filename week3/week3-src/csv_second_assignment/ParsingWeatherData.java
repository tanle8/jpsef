
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
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        CSVRecord smallest = coldestHourInFile(parser);
        System.out.println("coldest temperature was " + smallest.get("TemperatureF") + " at " + smallest.get("DateUTC"));
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
    
    public CSVRecord lowestHumidityInManyFiles()
    {
        CSVRecord lowestHumRecord = null;
        int currentHum;
        int lowestHum;
        
        DirectoryResource dr = new DirectoryResource();
        // Iterate over files
        for (File f : dr.selectedFiles())
        {
            // Now we have this file, create new file resource
            FileResource fr = new FileResource(f);
            //
            CSVParser parser = fr.getCSVParser();
            // Find the lowest Humidity Record in the file
            CSVRecord currentRow = lowestHumidityInFile(parser);
            
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
    
    public void testLowestHumidityInManyFiles()
    {
        CSVRecord lowestHumRecord = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowestHumRecord.get("Humidity") + " at " + lowestHumRecord.get("DateUTC"));
    }
    
    public double averageTemperatureInFile(CSVParser parser)
    {
        double num = 0.0;
        double sum = 0.0;
        double average = 0.0;
        
        for (CSVRecord currentRow : parser)
        {
            double temperature = Double.parseDouble(currentRow.get("TemperatureF"));
            sum += temperature;
            num++;
        }
        
        average = sum/num;

        return average;
    }
    
    public void testAverageTemperatureInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureInFile(parser);
        
        System.out.println("Average temperature in file is " + average);
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int humidityThreshold)
    {
        double num = 0.0;
        double sum = 0.0;
        double average = 0.0;
        
        for (CSVRecord currentRow : parser)
        {
            if (!currentRow.get("Humidity").equals("N/A"))
            {
                int currentHum = Integer.parseInt(currentRow.get("Humidity"));
                if (currentHum >= humidityThreshold)
                {
                    double temperature = Double.parseDouble(currentRow.get("TemperatureF"));
                    sum += temperature;
                    num++;
                }
            }
        }
        
        average = sum/num;
        
        return average;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureWithHighHumidityInFile(parser, 80);
        
        if (!Double.isNaN(average))
        {
            System.out.println("Average Temp when high Humidity is " + average);
        }
        else
        {
            System.out.println("No Temp found");
        }
        
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
