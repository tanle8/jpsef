
/**
 * Write a description of Part4 here.
 * 
 * @author (Tan Le) 
 * @version (06-01-2018)
 */
import edu.duke.*;
import java.io.*;

public class Part4 {
    public void parseUrl(String url) {
        URLResource doubleQuoteUrl = new URLResource(url);
        for (String word : doubleQuoteUrl.words()) {
            if(word.toLowerCase().indexOf("youtube.com") != -1) {
                int firstQuoteIdx = word.indexOf("\"");
                int lastQuoteIdx = word.indexOf("\"", firstQuoteIdx+1);
                System.out.println(word.substring(firstQuoteIdx+1, lastQuoteIdx));
            }
        }
    }
    
    public void testParseUrl() {
        String url1 = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        parseUrl(url1);
    }
}
