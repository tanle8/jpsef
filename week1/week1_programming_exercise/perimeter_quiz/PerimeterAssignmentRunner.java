import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public int getNumPoints (Shape s) {
        // Iterate over all the points in the Shape s and count them.
        int numPoints = 0;
        for (Point p : s.getPoints()) {
            numPoints += 1;
        }

        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // 
        double length = getPerimeter(s);
        double numSides = (double) getNumPoints(s);
        double avgLength = length / numSides;

        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point lastPoint = s.getLastPoint();
        double largestSide = 0.0;

        for (Point p : s.getPoints()) {
            double currDist = lastPoint.distance(p);
            if (currDist > largestSide) {
                largestSide = currDist;
            }
            lastPoint = p;
        }

        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point lastPoint = s.getLastPoint();
        double lastPointX = lastPoint.getX();
        double largestX = (double) lastPointX;

        for (Point p : s.getPoints()) {
            int currX = p.getX();
            if (currX > largestX) {
                largestX = (double) currX;
            }       
        }

        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        FileResource largestFile = null;

        for (File f : dr.selectedFiles()) {
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if (perim > largestPerim) {
                largestPerim = perim;
            }
        }

        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;

        for(File f : dr.selectedFiles()) {
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if (perim > largestPerim) {
                largestPerim = perim;
                largestFile = f;
            }         
        }

        return largestFile.getName();
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
        double largest = getLargestPerimeterMultoplefiles();
        System.out.println("Largest perimeter is: " + largest);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String file = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file is : " + file);
    }

    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);

        // test getNumPoints method
        int numPoints = getNumPoints(s);
        System.out.println("The number of Points in this shape is: " + numPoints);

        // test getAverageLength method
        double avgLength = getAverageLength(s);
        System.out.println("The average length of this shape is: " + avgLength);

        // test getLargestSide method
        double largestSide = getLargestSide(s);
        System.out.println("The largest sides is: " + largestSide);

        // test getLargestX method
        double largestX = getLargestX(s);
        System.out.println("The largest X in all Xs is: " + largestX);

        // testPerimeterMultipleFiles();
        testPerimeterMultipleFiles();

        // testFilewithLargestPerimeter();
        testFileWithargestPerimeter();
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
