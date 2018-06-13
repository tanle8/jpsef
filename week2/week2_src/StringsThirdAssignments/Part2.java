
/**
 * 1. cgRatio method returns the ratio of C's and G's in dna as a fraction of
 * the entire strand of DNA
 * 
 * 2. countCTG (String dna) returns the `number of times` the codon CTG appears 
 * in dna
 *  
 * @author (Tan Le) 
 * @version (13-06-2018)
 */

public class Part2 {
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
    
    public void testCgRatio ()
    {
        String dna = "ATGCCATAG,";
        if (cgRatio(dna) == (4/9))
        {
            System.out.println("It's good!");
        } else
        {
            System.out.println("Sorry. Check your function please!");
        }
    }
    
    public int countCTG (String dna)
    {
        dna = dna.toLowerCase();
        int start = 0;
        int counterCTG = 0;
        
        while (true)
        {
            int pos = dna.indexOf("ctg", start);
            if (pos == -1)
            {
                System.out.println("No CTG found!");
                break;
            }
            
            counterCTG += 1;
            start = pos + 3;
        }
        System.out.println("The number of CTG codon is: " + counterCTG);
        
        return counterCTG;
    }

    public void testCountCTG ()
    {
        String dna = "zzzCTGzzzzzzCTGzzCTG";
        if (countCTG(dna) == 3)
        {
            System.out.println("It's good!");
        } else
        {
            System.out.println("Sorry. Check your function please!");
        }
    }
}
