
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (Tan Le) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        // complete constructor
        records = new ArrayList<LogEntry>();
    }

    public void readFile(String filename) {
        // complete method
        FileResource fr = new FileResource(filename);
        for (String line : fr.lines()) {
            records.add(WebLogParser.parseEntry(line));
        }
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

    public int countUniqueIPs(){
        // UniqueIPs start as an empty list
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        // For each element le in records
        for (LogEntry le : records){
            // ipAddr is not in uniqueIPs
            String ipAddr = le.getIpAddress();
            // if ipAddr is not in uniqueIPs list
            if (!uniqueIPs.contains(ipAddr)){
                // add ipAddr to uniqueIPs
                uniqueIPs.add(ipAddr);
            }
        }

        // return the size of uniqueIPs
        return uniqueIPs.size();
    }

    public void printAllHigherThanNum(int num){
        // for each web log entries in records
        for (LogEntry le : records){
            // find the status code greater than num
            if (le.getStatusCode() > num){
                // print the LogEntry that has a status code greater than num
                System.out.println(le.toString());
            }
        }
    }
}
