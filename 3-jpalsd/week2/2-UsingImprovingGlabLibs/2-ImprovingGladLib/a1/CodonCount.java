import java.util.HashMap;
import java.util.FileResource;
/**
 * Write a program to find out how many times each 
 * codon occurs in a strand of DNA based on reading frames.
 *
 * 
 * @author (Tan Le) 
 * @version (a version number or a date)
 */

public class CodonCount {

    private HashMap<String, Integer> codonMap;

    public CodonCount(){
        codonMap = new HashMap<String, Integer>();
    }

    /**
     * This method will build a new map of codons mapped to their counts 
     * from the string `dna` with the reading frame with the position 
     * start (a value of 0, 1, or 2)
     * @param start starting index to count
     * @param dna input data to count its codons
     */
    public void buildCodonMap(int start, String dna){
        codonMap.clear();    // we will call this method several time, so make sure our map is empty.

        for(int i = start; i < dna.length()-3; )
        {
            String codon = dna.substring(i, i+3);
            if (!codonMap.containsKey(codon))
            {
                codonMap.put(codon, 1);
            } else {
                codonMap.put(codon, codonMap.get(codon) + 1);
            }
            i+=3;
        }
    }

    /**
     * This method returns a String, the codon
     * in a reading frame that has the largest count.
     * 
     * Note: This method assumes the HashMap of codons 
     * to counts has already been built.
     * 
     * @return  codon has the largest count
     */
    public String getMostCommonCodon(){
        int largestCount = 0;
        String mostCommonCodon = new String();

        for (String codon : codonMap.keySet()){
            int currCodonCount = codonMap.get(codon);
            if (largestCount < currCodonCount){
                largestCount = currCodonCount;
                mostCommonCodon = codon;
            }
        }

        return mostCommonCodon;
    }
    /**
     * This method prints all the codons in the HashMap 
     * along with their counts if their count is between
     * start and end, inclusive
     * 
     * @param start 
     * @param end
     */
    public void printCodonCounts(int start, int end){
        for (String codon : codonMap.keySet()){
            int currCodonCount = codonMap.get(codon);
            if (currCodonCount >= start && currCodonCount <= end){
                System.out.println(codon + "\t" + currCodonCount);
            }
        }
    }

    /**
     * Tester
     */
    public void tester(){
        FileResource resource = new FileResource();
        String dna = fr.asString();
        CodonCount cc = new CodonCount();
        
        // For each of the three possible reading frames
        // 1. Build a HashMap of codons to their number of occurrences
        // 2. Print the total number of unique codons in the reading frame
        // 3. Print the most common codon and its count
        // 4. Print the codons and their number of occurences

        // Started from index 0
        cc.buildCodonMap(0, dna);
		System.out.println("Number of unique codons:\t" + cc.getCodonCount());
		System.out.println(cc.getMostCommonCodon());
        cc.printCodonCounts(1, 5);
        
        // Started from index 1
        cc.buildCodonMap(1, dna);
		System.out.println("Number of unique codons:\t" + cc.getCodonCount());
		System.out.println(cc.getMostCommonCodon());
        cc.printCodonCounts(1, 5);
        
        // Started from index 2
        cc.buildCodonMap(2, dna);
		System.out.println("Number of unique codons:\t" + cc.getCodonCount());
		System.out.println(cc.getMostCommonCodon());
        cc.printCodonCounts(1, 5);
    }
}
