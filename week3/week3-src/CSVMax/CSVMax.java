
/**
 * Write a description of CSVMax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax
{
    public CSVRecord hottestHourseInFile(CSVParser parser)
    {
        // Start with largestSoFar as nothing
        CSVRecord largestSoFar = null;
        // For each row (currentRow) in the CSV file
        for (CSVRecord currentRow : parser)
        {
            // If largestSoFar is nothing
            if (largestSoFar == null)
            {
                largestSoFar = currentRow;
            }
            // Otherwise
            else
            {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                // Check if currentRow's temperature > largestSoFar
                if (currentTemp > largestTemp)
                {
                    // If so update largestSoFar to currentRow
                    largestSoFar = currentRow;
                }
            }
        }
        // The largestSoFar is the answer
        return largestSoFar;
    }

    public void testHottestInDay()
    {
        FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
        CSVRecord largest = hottestHourseInFile(fr.getCSVParser());
        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("TimerEST"));
    }
}