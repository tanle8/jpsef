
/**
 * Write a description of Exports here.
 * 
 * @author (Tan Le) 
 * @version (16-06-18)
 */

import edu.duke.FileResource;
import org.apache.commons.csv.*;
import java.io.IOException;

public class Exports {
    public void tester()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        // System.out.println( countryInfo(parser, "Nauru"));
        // listExportersTwoProducts(parser, "gold", "diamonds");
        // System.out.println( numberOfExporters(parser, "gold"));
        bigExporters(parser, "$999,999,999,999");
    }
    
    public String countryInfo(CSVParser parser, String country)
    {
        try {
            // 
            for(CSVRecord record : parser.getRecords())
            {
                if(record.get("Country").equals(country))
                {
                    String countryInfo = "";
                    countryInfo = countryInfo + record.get(0) + ": " + record.get(1) + ": " + record.get(2);
                    return countryInfo;
                }
            }
        } catch (IOException e){}
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2)
    {
        // For each row in the CSV file
        for (CSVRecord record : parser)
        {
            // Look at the "Export" column
            String exports = record.get("Exports");
            // Check if it contains exportItem1 and exportItem2
            if (exports.contains(exportItem1) && exports.contains(exportItem2))
            {
                // If so, write down the "Country" from that row
                String country = record.get("Country");
                System.out.println(country);
                // Shorter
                //System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem)
    {
        int countCountry = 0;
        // For each row in the CSV file
        //try {
            for (CSVRecord record : parser)
            {
                // Look at the "Export" column
                String export = record.get("Exports");
                // Check if it contains exportItem
                if (export.indexOf(exportItem) != -1)
                {
                    // If so, increment the counter
                    countCountry++;
                }
            }
        //} catch (IOException e){}
        
        return countCountry;
    }
    
    public void bigExporters(CSVParser parser, String amount)
    {
        // For each row in the CSV file
        for (CSVRecord record : parser)
        {
            // Look at the "Values" column
            String value = record.get("Value (dollars)");
            // Compare its length with the amount's length
            if (value.length() > amount.length())
            {
                System.out.println(record.get("Country") + " " + value);
            }
        }
    }
}
