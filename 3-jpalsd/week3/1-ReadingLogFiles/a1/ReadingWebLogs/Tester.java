
/**
 * Write a description of class Tester here.
 * 
 * @author (Tan Le) 
 * @version (a version number or a date)
 */

import java.util.*;

import sun.rmi.runtime.Log;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }

    public void testUniqueIP(){
        // create a LogAnalyzer object
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println("Number of unique IPs: " + la.countUniqueIPs());
    }

    public void testPrintAllHigherThanNum(){
        // create a LogAnalyzer object
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAllHigherThanNum(200);
    }
    
    public void testUniqueIPVisitsOnDay(){
        // create a LogAnalyzer object
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog-short_log");
        la.uniqueIPVisitsOnDay("Sep 14");
        la.uniqueIPVisitsOnDay("Sep 30");
    }

    public void testCountUniqueIPsInRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countUniqueIPsInRange(200, 299));
        System.out.println(la.countUniqueIPsInRange(300, 399));
    }
}
