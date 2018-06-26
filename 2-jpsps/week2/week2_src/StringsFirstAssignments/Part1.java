
/**
 * Write a description of Part1 here.
 * 
 * @author (Tan Le)
 * @version (18-05-30)
 */
import edu.duke.*;
import java.io.*;

public class Part1 {
    public String findSimpleGene(String dna) {
        String result = "";
        int start = dna.toLowerCase().indexOf("atg");
        if (start == -1) {
            return "";
        }
        int stop = dna.toLowerCase().indexOf("taa", start+3);
        if (stop == -1) {
            return "";
        } else {
            if ((stop - start) % 3 == 0) {
                return dna.substring(start, stop+3);
            }
            else {
                return "";
            }
        }
    }
    
    public void testSimpleGene() {
        String testCase1 = "taattaagttggtata";  // no "ATG"
        String testCase2 = "agttgattgatggaat";  // no "TAA" 
        String testCase3 = "taggtattagattgag";  // no "ATG" and "TAA"
        String testCase4 = "atgggtaggtggtaa";   // with "ATG" and "TAA", a gene
        String testCase5 = "atgtgtgtgtgtaa";    // with "ATG" and "TAA", not a gene
        
        System.out.println("Test case 1: " + testCase1 + "\n" + "Gene: " + findSimpleGene(testCase1) + "\n");
        System.out.println("Test case 2: " + testCase2 + "\n" + "Gene: " + findSimpleGene(testCase2) + "\n");
        System.out.println("Test case 3: " + testCase3 + "\n" + "Gene: " + findSimpleGene(testCase3) + "\n");
        System.out.println("Test case 4: " + testCase4 + "\n" + "Gene: " + findSimpleGene(testCase4) + "\n");
        System.out.println("Test case 5: " + testCase5 + "\n" + "Gene: " + findSimpleGene(testCase5) + "\n");
        
    }
    
    //public static void main (String[] args) {
    //    Part1 part1Gene = new Part1();
    //    part1Gene.testSimpleGene();
    //}
}
