
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

    /**
     * This method accesses the web logs in records and returns an ArrayList 
     * of Strings of unique IP addresses that had access on the given day.
     * 
     * @param String someday the date in format "MMM DD" 
     * @return ArrayList<String> the list of unique IP addresses
     *                           that has access on the given day
     */
    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        // Create an empty list to store unique IPs on a day
        ArrayList<String> uniqueIPsOnDay = new ArrayList<String>();
        // For each element le (LogEntry object) in records
        for(LogEntry le : records){
            // Look at it date
            String accessTime = le.getAccessTime().toString();
            // If this is the day
            if (accessTime.contains(someday)){
                String ipAddr = le.getIpAddress();
                if (!uniqueIPsOnDay.contains(ipAddr)){
                    // add ipAddr to uniqueIPsOnDay
                    uniqueIPsOnDay.add(ipAddr);
                }
            }
        }
        System.out.println(uniqueIPsOnDay.size());

        return uniqueIPsOnDay;
    }
}
