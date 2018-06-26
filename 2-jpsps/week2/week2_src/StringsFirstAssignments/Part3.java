
/**
 * Write a description of Part3 here.
 * 
 * @author (Tan Le) 
 * @version (18-05-30)
 */
import edu.duke.*;
import java.io.*;

public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb) {
        int index1 = stringb.indexOf(stringa);
        if(index1 != -1) {
            int index2 = stringb.indexOf(stringa, index1+1);
            if( index2 != -1) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public void testing() {
        //// twoOccurrences function test cases
        String testCase10 = "by";
        String testCase11 = "A story by Abby Long";
        String testCase20 = "a";
        String testCase21 = "banana";
        String testCase30 = "atg";
        String testCase31 = "ctgtatgta";
        // lastPart function test cases
        String testCase40 = "an";
        String testCase41 = "banana";
        String testCase50 = "zoo";
        String testCase51 = "forest";
        String testCase52 = "zootopia";
        String testCase53 = "yoyozooyo";
        
        System.out.println(twoOccurrences(testCase10, testCase11));
        System.out.println(twoOccurrences(testCase20, testCase21));
        System.out.println(twoOccurrences(testCase30, testCase31));
        System.out.println(lastPart(testCase40, testCase41));
        System.out.println(lastPart(testCase50, testCase51));
        System.out.println(lastPart(testCase50, testCase52));
        System.out.println(lastPart(testCase50, testCase53));
    }

    public String lastPart(String stringa, String stringb) {
        if (stringb.indexOf(stringa) != -1) {
            int index = stringb.indexOf(stringa);
            return "The part of the string after " + stringa + " in " + stringb + " is " + stringb.substring(index+stringa.length(), stringb.length());
        } else {
            return "The part of the string after " + stringa + " in " + stringb + " is " + stringb;
        }
    }
}
