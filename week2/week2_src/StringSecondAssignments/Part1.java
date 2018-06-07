
/**
 * In this class, we have 3 methods - findStopCodon, findGene, printAllGenes and 
 * 2 methods for testing prior methods.
 * 
 * @author (Tan Le) 
 * @version (18-06-06)
 */

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
        return dna.length();
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
        int temp = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
        // (optional) shorter minIndex
        // int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        if (minIndex == dna.length())
        {
            return "";
        }
        
        return dna.substring(startIndex, minIndex+3);
    }
    
    // public void printAllGenes ()
    // {
    // }
    
    public void testFindStopCodon ()
    {
        String dna = "zzzxxxcccTAAzzzxxxcccTAAzz";
        int dex = findStopCodon(dna, 0, "TAA");
        if (dex != 9) System.out.println("error on 9");
        dex = findStopCodon(dna, 9, "TAA");
        if (dex != 21) System.out.println("error on 21");
        dex = findStopCodon(dna, 1, "TAA");
        if (dex != 26) System.out.println("error on 26");
        dex = findStopCodon(dna, 0, "TAG");
        if (dex != 26) System.out.println("error on 26 TAG");
        System.out.println("tests finished");
    }
    
    public void testFindGene ()
    {
        String dna = "ATGCCCGGGAAATAACCC";
        String gene = findGene(dna);
        if (! gene.equals("ATGCCCGGGAAATAA"))
        {
            System.out.println("Error. Your string does not match with the answer");
        }
        System.out.println("Test finished. It's good.");
    }
    
}
