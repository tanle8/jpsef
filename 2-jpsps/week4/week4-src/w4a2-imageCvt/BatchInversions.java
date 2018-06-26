
/**
 * This program creates new images that are photgraphic negatives (or inverted images)
 * of selected images and save these new images with filenames that are related to 
 * the original images, such as adding "inverted-" in front of the old filename.
 * 
 * @author (Tan Le) 
 * @version (25-06-2018)
 */
import edu.duke.ImageResource;
import edu.duke.DirectoryResource;
import edu.duke.Pixel;
import java.io.*;

public class BatchInversions {
    //I started with the image I wanted (inImage)
    public ImageResource makeInversion(ImageResource inImage)
    {
        //I made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //for each pixel in outImage
        for (Pixel pixel : outImage.pixels())
        {
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            //With inPixel's red + inPixel's blue + inPixel's green
            //those values will be subtracted by 255 to compute 
            //set output image red pixel's to the inverted value of input image red pixel
            pixel.setRed(255 - inPixel.getRed());
            //set pixel's green to inverted value
            pixel.setGreen(255 - inPixel.getBlue());
            //set pixel's blue to inverted value
            pixel.setBlue(255 - inPixel.getGreen());
        }
        //outImage is your answer
        return outImage;
    }

    public void testMakeInversion()
    {
        ImageResource ir = new ImageResource();
        ImageResource inverted = makeInversion(ir);
        inverted.draw();
    }

    public void selectAndConvert()
    {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles())
        {
            ImageResource inImage = new ImageResource(f);
            ImageResource invertedImage = makeInversion(inImage);
            // Save inverted image
            String inImageName = inImage.getFileName();
            String invertedImageName = "inverted-" + inImageName;
            invertedImage.setFileName(invertedImageName);
            invertedImage.save();
            // Draw inverted image
            invertedImage.draw();
        }
    }
}
