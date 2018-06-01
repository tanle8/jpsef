
/**
 * Write a description of Part2 here.
 * 
 * @author (Tan Le) 
 * @version (18-05-30)
 */
public class Part2 {
    public String findSimpleGene(String dna, int startCodon, int stopCodon) {
        String result = "";
        int start = startCodon;
        if (start == -1) {
            return "";
        }
        int stop = stopCodon;
        if (stop == -1) {
            return "";
        } else {
            if ((stop - start) % 3 == 0) {
                result = dna.substring(start, stop+3);
                /*
                boolean hasUpperCase = !result.equals(result.toLowerCase());
                if (hasUpperCase) {
                    result = result.toUpperCase();
                } else {
                    result = result.toLowerCase();
                }
                */
                return result;
                
            }
            else {
                return "";
            }
        }
    }
    
    public void testSimpleGene() {
        // String testCase1 = "taattaagttggtata";  // no "ATG"
        // String testCase2 = "agttgattgatggaat";  // no "TAA" 
        // String testCase3 = "taggtattagattgag";  // no "ATG" and "TAA"
        // String testCase4 = "atgggtaggtggtaa";   // with "ATG" and "TAA", a gene
        // String testCase5 = "atgtgtgtgtgtaa";    // with "ATG" and "TAA", not a gene
        String testCase6 = "ATGGGTTAAGTC";      // Upper Case
        String testCase7 = "gatgctataat";       // Lower Case
        
        // System.out.println("Test case 1: " + testCase1 + "\n" + "Gene: " + findSimpleGene(testCase1) + "\n");
        // System.out.println("Test case 2: " + testCase2 + "\n" + "Gene: " + findSimpleGene(testCase2) + "\n");
        // System.out.println("Test case 3: " + testCase3 + "\n" + "Gene: " + findSimpleGene(testCase3) + "\n");
        // System.out.println("Test case 4: " + testCase4 + "\n" + "Gene: " + findSimpleGene(testCase4) + "\n");
        // System.out.println("Test case 5: " + testCase5 + "\n" + "Gene: " + findSimpleGene(testCase5) + "\n");
        System.out.println("Test case 6: " + testCase6 + "\n" + "Gene: " + findSimpleGene(testCase6, 0, 6) + "\n");
        System.out.println("Test case 7: " + testCase7 + "\n" + "Gene: " + findSimpleGene(testCase7, 1, 7) + "\n");
    }
}
