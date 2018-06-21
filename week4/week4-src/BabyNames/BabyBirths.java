
/**
 * Write a description of BabyBirths here.
 * 
 * @author (Tan Le) 
 * @version (21-06-2018)
 */
import edu.duke.FileResource;
import org.apache.commons.csv.*;

public class BabyBirths {
    public void printNames()
    {
        FileResource fr = new FileResource();
        for (CSVRecord currentRow : fr.getCSVParser(false))
        {
            int numBorn = Integer.parseInt(currentRow.get(2));
            if (numBorn <= 100)
            {
                System.out.println("Name " + currentRow.get(0) +
                                   " Gender" + currentRow.get(1) +
                                   " Num Born" + currentRow.get(2));
            }
        }
    }
    
    public void totalBirths(FileResource fr)
    {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        
        for (CSVRecord currentRow : fr.getCSVParser(false))
        {
            int numBorn = Integer.parseInt(currentRow.get(2));
            totalBirths += numBorn;
            if (currentRow.get(1).equals("M"))
            {
                totalBoys += numBorn;
            }
            else
            {
                totalGirls += numBorn;
            }
        }
        
        System.out.println("total births = " + totalBirths);
        System.out.println("total boys = " + totalBoys);
        System.out.println("total girls = " + totalGirls);
    }
    
    public void testTotalBirths()
    {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
}
