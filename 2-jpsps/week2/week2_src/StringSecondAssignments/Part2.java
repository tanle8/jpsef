
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb)
    {
        String sringb = stringb.toLowerCase();
        int counter = stringb.length() - stringb.replace(stringa, "").length();
        System.out.println(stringa + " count: " + counter/(stringa.length()));
        return counter;
    }
    
    public void testHowMany()
    {
        if (howMany("GAA", "ATGAACGAATTGAATC") == 3) System.out.println("It's true");
        if (howMany("AA", "ATAAAA") == 2) System.out.println("It's true");
    }
}
