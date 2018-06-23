
/**
 * The Description for this Class can be found in the README.md
 * 
 * @author (Tan Le) 
 * @version (21-06-2018)
 */
import edu.duke.FileResource;
import org.apache.commons.csv.*;
import edu.duke.DirectoryResource;
import java.io.File;

public class ParsingBirthsData {
    public void totalBirths(FileResource fr)
    {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int numBoyName = 0;
        int numGirlName = 0;
        
        
        for (CSVRecord currentRow : fr.getCSVParser(false))
        {
            int numBorn = Integer.parseInt(currentRow.get(2));
            totalBirths += numBorn;
            if (currentRow.get(1).equals("M"))
            {
                totalBoys += numBorn;
                numBoyName++;
            }
            else
            {
                totalGirls += numBorn;
                numGirlName++;
            }
        }
        
        System.out.println("total births = " + totalBirths);
        System.out.println("total boys = " + totalBoys);
        System.out.println("total girls = " + totalGirls);
        System.out.println("number of boys name = " + numBoyName);
        System.out.println("number of girls name = " + numGirlName);
        System.out.println("total name in the file = " + (numBoyName + numGirlName));
    }
    
    public void testTotalBirths()
    {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

    public long getRank(String name, int year, String gender)
    {
        long rank = -1;
        
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            if (f.getName().contains(Integer.toString(year)))
            {
                FileResource fr = new FileResource(f);
                CSVParser parser = fr.getCSVParser(false);    // "false" - dont has header row
                for (CSVRecord currentRow : parser)
                {
                    String currentRowName = currentRow.get(0);
                    String currentRowGender = currentRow.get(1);
                    
                    if (currentRowGender.equals(gender) && currentRowName.equals(name))
                    {
                        rank = currentRow.getRecordNumber();
                    }
                }
                return rank;
            }
        }
        
        return rank;
    }
    
    public String getName(int year, long rank, String gender)
    {
        String name = "";
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);

        for (CSVRecord currentRow : parser)
        {
            long currentRowRank = currentRow.getRecordNumber();
            String currentRowGender = currentRow.get(1);
            String currentRowName = currentRow.get(0);
            
            if (currentRowRank == rank && currentRowGender.equals(gender))
            {
                name = currentRowName;
            }
        }
        
        if (name == "")
        {
            return "NO NAME";
        }
        
        return name;
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender)
    {
        FileResource fr = new FileResource();
        FileResource frNew = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        CSVParser parserNew = frNew.getCSVParser(false);
        String nameNew = "";
        long popularity = 0;
        
        for(CSVRecord currentRow : parser)
        {
            String currentRowName = currentRow.get(0);
            String currentRowGender = currentRow.get(1);
            
            if(currentRowName.equals(name) && currentRowGender.equals(gender))
            {
                popularity = currentRow.getRecordNumber();
            }
        }
        
        for(CSVRecord currentRow : parserNew)
        {
            String currentRowGender = currentRow.get(1);
            long currentRowPopularity = currentRow.getRecordNumber();
            
            if(currentRowGender.equals(gender) && (currentRowPopularity == popularity))
            {
                nameNew = currentRow.get(0);
            }
        }
        
        System.out.println(name + " born in " + year + " would be " + nameNew + " if she was born in " + newYear);
    }
}
