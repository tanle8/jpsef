
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
        ArrayList<String> uniqueIPsOnDay = new ArrayList<String>();
        for(LogEntry le : records){
            String accessTime = le.getAccessTime().toString();
            if (accessTime.contains(someday)){
                String ipAddr = le.getIpAddress();
                if (!uniqueIPsOnDay.contains(ipAddr)){
                    // add ipAddr to uniqueIPsOnDay
                    uniqueIPsOnDay.add(ipAddr);
                }
            }
        }
        System.out.println(uniqueIPsOnDay.size());  // For testing

        return uniqueIPsOnDay;
    }

    /**
     * This method returns the number of unique IP addresses in `records` that have
     * a status code in the range from `low` to `high`.
     * @param low 
     * @param high
     * @return number of unique IP addresses that have status code in the range from
     * `low` to `high`
     */
    public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqueIPsInRange = new ArrayList<String>();
        for (LogEntry le : records){
            int statusCode = le.getStatusCode();
            if (low <= statusCode && statusCode <= high){
                String ipAddr = le.getIpAddress();
                if (!uniqueIPsInRange.contains(ipAddr)){
                    uniqueIPsInRange.add(ipAddr);
                }
            }
        }
        
        return uniqueIPsInRange.size();
    }

    /** */
    public HashMap<String, Integer> countVisitsPerIP(){
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        // For each LogEntry object in records
        for (LogEntry le : records){
            // ip is le's ipAddress
            String ip = le.getIpAddress();
            if (!counts.containsKey(ip)){
                counts.put(ip, 1);
            } else {
                counts.put(ip, counts.get(ip) + 1);
            }
        }

        return counts;
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> counts){
		int maxValue = 0;
		for (String currKey : counts.keySet()){
			if (counts.get(currKey) > maxValue){
				maxValue = counts.get(currKey);
			}
		}

		return maxValue;
	}

	public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts){
		ArrayList<String> iPsMostVisitsList = new ArrayList<String>();
		int maxVisitsValue = mostNumberVisitsByIP(counts);

		for (String currKey : counts.keySet()){
			if (counts.get(currKey) == maxVisitsValue){
				iPsMostVisitsList.add(currKey);
			}
		}

		return iPsMostVisitsList;
	}
	
	/**
	 * This method returns map with a day (String) and which IPs visit web page in that
	 * day (an ArrayList of String)
	 * @return map HashMap<String, ArrayList<String>>
	 */
	public HashMap<String, ArrayList<String>> iPsForDays(){
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (LogEntry currRec : records){
			// Get day from date string
			String date = currRec.getAccessTime().toString();
			String day = date.substring(4, 10);		// can be refactored later
			// Get current record's IP address
			String ip = currRec.getIpAddress();

			if (!map.containsKey(day)){
				ArrayList<String> visitorsList = new ArrayList<String>();
				visitorsList.add(ip);
				map.put(day, visitorsList);
			}
			else {
				map.get(day).add(ip);
			}
		}

		return map;
	}

	/**
	 * This method returns the day that has the most IP address visits.
	 * @param 
	 * @return
	 */
	public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> dayIPsMap){
		int maxSize = 0;
		String dayWithMostIPVisit = null;

		for (String day : dayIPsMap.keySet()){
			int dayValueSize = dayIPsMap.get(day).size();
			if (dayValueSize > maxSize){
				maxSize = dayValueSize;
				dayWithMostIPVisit = day;
			}
		}

		return dayWithMostIPVisit;
	}
}