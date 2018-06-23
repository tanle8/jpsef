
/**
 * The Description for this Class can be found in the README.md
 * 
 * @author (Tan Le) 
 * @version (21-06-2018)
 */
import edu.duke.FileResource;
import org.apache.commons.csv.*;

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

         
}
