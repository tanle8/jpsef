
/**
 * 1. processGenes
 *     This method processes all the strings in `sr` to find out information about them
 * 2. testProcessGenes
 *     
 * 
 * @author (Tan Le) 
 * @version (13-06-2018)
 */

import edu.duke.StorageResource;
import edu.duke.FileResource;

public class Part3 {
    public double cgRatio (String dna)
    {
        dna = dna.toLowerCase();
        int lenDNA = dna.length();    // take the DNA length
        if (dna.length() == 0)
        {
            return 0.0;
        }
        int cgCounter = 0;
        
        for (int i = 0; i < lenDNA; i++)
        {
            if (dna.charAt(i) == 'c' || dna.charAt(i) == 'g')
            {
                cgCounter++;
            }
        }
        
        return cgCounter / lenDNA;
    }
        
    public void processGenes(StorageResource sr)
    {
        int numGeneLongerThan = 0;
        int numGeneCGRatio = 0;
        int lengthLongestGene = 0;
        
        for (String gene : sr.data())
        {
            // Print all the strings in sr that are longer than 9 characters
            if (gene.length() > 60)
            {
                System.out.println("Gene longer than 60 character: " + gene + "\n");
                numGeneLongerThan++;
            }
            // Print the strings in sr whose cgRatio is higher than 0.35
            if (cgRatio(gene) > 0.35)
            {
                System.out.println("This gene has CG ratio larger than 0.35: " + gene + "\n");
                numGeneCGRatio++;
            }
            // The length of the longest gene to current gene
            if (lengthLongestGene < gene.length())
            {
                lengthLongestGene = gene.length();
            }
        }
        // Print the number of string in sr that are longer than 9 characters
        System.out.println("Number of genes longer than 60 character: " + numGeneLongerThan);
        // Print the number of strings in sr whose cgRatio is higher than 0.35
        System.out.println("Number of genes have cg ratio larger than 0.35: " + numGeneCGRatio);
        // Print the length of the longest string in sr
        System.out.println("The length of the longest gene is: " + lengthLongestGene);
    }
    
    public void testProcessGenes()
    {
        // Create a list to store genes
        StorageResource geneList = new StorageResource();
        
        FileResource fr = new FileResource("brca1line.fa");
        String dnaSequence = fr.asString().toLowerCase();
        // System.out.println(dnaSequence);
        Part1 part11 = new Part1();
        geneList = part11.getAllGenes(dnaSequence);
        System.out.println("Gene list size: " + geneList.size());
        processGenes(geneList);
    }
}

