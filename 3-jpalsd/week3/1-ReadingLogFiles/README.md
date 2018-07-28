# Week 3 - 1. Reading Log Files

## Web Server Logs

- Web servers: log accesses
    - Record who (IP), date, what page, response

### Important of Logs

1. Understand usage of website
    - How many people visit site?
    - What pages do they look at?
2. Investigate problems
    - Tell you when your server is experiencing errors, such as broken link

## Plan Going Forward

Read Log File:
  - Count Unique Visitors
  - How many visits per visitor
  - ... Many other problems!

1. This lesson: read the log file
2. Setup to solve many problems

## Apache HTTP project (version 2.4)

1. Log files format

    ```text
    110.76.104.12 - - [30/Sep/2015:07:47:11 -0400] "GET //favicon.ico HTTP/1.1" 200 3246
    ```

## Represent logs file's element in Java class

### Fields

```java
public class LogEntry {
    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;
}
```

In this particular case, it makes sense to have each of these be private and to design your class to be _immutable_ (immutable means you cannot modify an object once you create it).

Each of these fields will be set in its constructor, but __can only be read__.

To make anything __able to read these fields__, we write a public `getter/accessor` method such as these, which will just return the value of that field, but there will be no way to set the value of the field once its constructed.

### `getter/accessor`

```java
public String gerIpAddress() {
    return ipAddress;
}

public Date getAccessTime() {
    return accessTime;
}

public String getRequest() {
    return request;
}

public int getStatusCode() {
    return statusCode;
}

public int getBytesReturned() {
    return bytesReturned;
}
```

## Summary

This is the full `LogEntry` class we need:

```java
import java.util.*;

public class LogEntry{

    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;

    public LogEntry(String ip, Date time, String req, int status, int bytes){
        ipAddress = ip;
        accessTime = time;
        request = req;
        statusCode = status;
        bytesReturned = bytes;
    }

    public String getIpAddress(){
        return ipAddress;
    }

    public Date getAccessTime(){
        return accessTime;
    }

    public String getRequest(){
        return request;
    }

    public int getStatusCode(){
        return statusCode;
    }

    public int getBytesReturned(){
        return bytesReturned;
    }
}
```

### `toString` method

Every class has a `toString` method by default. But it only knows to print out the memory address of an object unless you specify the `twoString` class

```java
public String toString(){
    return ipAddress + " " + accessTime + " " + request
             + " " + statusCode + " " + bytesReturned;
}
```

### `Tester` class

```java
import java.util.*;

public class Tester {
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(),
                "example request", 200, 500);
        System.out.println(le);

        LogEntry le2 = new LogEntry("1.2.100.4", new Date(),
                "example request 2", 300, 400);
        System.out.println(le2);
    }
}
```

## 2. Parsing Log Files

- [x] Made LogEntry class
    - Need to parse line to create instances
    - Split String into fields
        - Many `indexOf` and `substring` call
    - Time: turn String into Date
        - Built in, but complicated interface
- This course gave us code to do this
    - `WebLogParser.parseEntry`

### `LogAnalyzer` class

```java
public class LogAnalyzer{
    private ArrayList<LogEntry> records;
    public LogAnalyzer(){
        // For you to write
    }

    public void readFile(String filename){
        // For you to write
    }
}
```

- __Create a__ `FileResource` __for__ filename
- __Iterate over its lines for each one__,
    - __Use__ `WebLogParser.parseEntry`
    - __Add the resulting__ `LogEntry` to `records`

```java
public void printAll(){
    for (LogEntry le : records){
        System.out.println(le);
    }
}
```

- __Provided `printAll()` to help you test your code__
    - __Implicitly uses `.toString()` in `LogEntry`__

## Reading Log File Summary

- Web server logs: info about your site
- Format: Apache documentation
- Class for `LogEntry`
    - Learned about `toString()`
- Wrote code to read log file
- Now ready to analyze!