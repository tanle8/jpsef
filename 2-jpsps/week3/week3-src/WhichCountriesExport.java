import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport
{
    public void listExporters(CSVParser parser, String exportOfInterest)
    {
        // For each row in the CSV file
        for (CSVRecord record : parser )
        {
            // Look at the "Export" column
            String export = record.get("Exports");
            // Check if it contains exportOfInterest
            if (export.contains(exportOfInterest)){
                // If so, write down the "Country" from that row
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    public void whoExportsCoffee()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffe");
    }
}