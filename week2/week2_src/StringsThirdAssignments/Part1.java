
/**
 * Store the genes you find instead of printing them out..
 * 
 * @author (Tan Le)
 * @version (13-06-18)
 */
import edu.duke.StorageResource;

public class Part1 {
    public int findStopCodon (String dna, int startIndex, String stopCodon)
    {
        // Find stopCodon starting from (startIndex + 3), currIndex
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while (currIndex != -1)
        {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0)
            {
                return currIndex;
            }
            else
            {
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return -1;
    }
    
    public String findGene (String dna)
    {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) 
        {
            return "";
        }
        
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        // int temp = Math.min(taaIndex, tagIndex);
        // int minIndex = Math.min(temp, tgaIndex);
        // (optional) shorter minIndex
        // int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        int minIndex = 0;
        if (taaIndex == -1 ||
            (tgaIndex != -1 && tgaIndex < taaIndex))
        {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }
        
        if (minIndex == -1 ||
            (tgaIndex != -1 && tagIndex < minIndex))
        {
            minIndex = tagIndex;
        }

        if (minIndex == -1)
        {
            return "";
        }
        
        return dna.substring(startIndex, minIndex+3);
    }
    
    public StorageResource getAllGenes (String dna)
    {
        // Creat an empty StorageResource, call it geneList
        StorageResource geneList = new StorageResource();
        // Set start index to 0
        int startIndex = 0;
        // Repeat the following steps
        while (true)
        {
            // Find the next gene after startIndex
            String currGene = findGene(dna, startIndex);
            // If no gene was found, leave this loop
            if (currGene.isEmpty())
            {
                break;
            }
            // Add the gene into geneList
            geneList.add(currGene);
            // Set startIndex to just past the end of the gene
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        
        return geneList;
    }

	
    
    public void testGetAllGenesOn (String dna)
    {
        System.out.println("Testing getAllGenes on");
        StorageResource genes = getAllGenes(dna);
        for (String g : genes.data()){
            System.out.println(g);               
        }
    }
    
    public void testGetAllGenes ()
    {
        testGetAllGenesOn("ATGATCTAATTTATGCTGCTGCAACGGTGAAGA");
        testGetAllGenesOn("");
    }
}
