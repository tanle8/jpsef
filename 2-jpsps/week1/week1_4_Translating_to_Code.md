#

##

```java
import edu.duke.*;

public class PerimeterRunner {
    public double gerPerimeter (Shape s) {
        // Start with totalPerim = 0
        // Start with prevPt = the last point
        // For each point currPt in the shape,
            // Find distance from prevPt pt to currPt, and name it currDist
            // Update totalPerim to be totalPerim + 
            // Update prevPt to be currPt.
        // totalPerim is my answer
    }

    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }

}
```