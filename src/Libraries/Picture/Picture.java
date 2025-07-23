package Libraries.Picture;
import javax.swing.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.io.*;

/**
 * This class represents a graphical picture. Once an instance of this is created, it can
 * be used to create Swing components showing that picture, including JButton and JLabel.
 */
public class Picture extends ImageIcon
{
    private String filename;
    private int rotation;
    private BufferedImage image;

    /**
     * Constructor. Creates a new instance of the Picture class based on an image in the given
     * filename and requested rotation.
     * 
     * @param filename The filename of an image to load.
     * @param rotation The rotation to supply to the image on loading, measure in degrees.
     */
    public Picture(String filename, int rotation)
    {
        this.filename = filename;
        this.rotation = rotation;

        try {
            this.image = ImageIO.read(new File(filename));
        } catch (Exception e)
        {
            System.out.println("Could not find image file: " + filename);
            return;
        }

        double rads = Math.toRadians(rotation);
        double sin = Math.abs(Math.sin(rads));
        double cos = Math.abs(Math.cos(rads));

        int w = (int) Math.floor(this.image.getWidth() * cos + this.image.getHeight() * sin);
        int h = (int) Math.floor(this.image.getHeight() * cos + this.image.getWidth() * sin);

        BufferedImage rotatedImage = new BufferedImage(w, h, this.image.getType());
        AffineTransform at = new AffineTransform();
        at.translate(w / 2, h / 2);
        at.rotate(rads,0, 0);
        at.translate(-this.image.getWidth() / 2, -this.image.getHeight() / 2);
        AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(this.image,rotatedImage);

        this.image = rotatedImage;
        this.setImage(this.image);
    }

    /**
     * Determines the filename associated with this Picture.
     */
    public String getFilename()
    {
        return filename;
    }

    /**
     * * Determines the rotation applied to this Picture, in degrees.
     */
    public int getRotation()
    {
        return rotation;
    }

    /**
     * Rotates the image by the specified degrees
     * 
     * If it doesn't work then just update the image by generating a new Picture and replacing the variable
     */
    public void setRotation(int degrees){
        try {
            this.image = ImageIO.read(new File(filename));
        } catch (Exception e)
        {
            System.out.println("Could not find image file: " + filename);
            return;
        }

        double rads = Math.toRadians(degrees);
        double sin = Math.abs(Math.sin(rads));
        double cos = Math.abs(Math.cos(rads));

        int w = (int) Math.floor(this.image.getWidth() * cos + this.image.getHeight() * sin);
        int h = (int) Math.floor(this.image.getHeight() * cos + this.image.getWidth() * sin);

        BufferedImage rotatedImage = new BufferedImage(w, h, this.image.getType());
        AffineTransform at = new AffineTransform();
        at.translate(w / 2, h / 2);
        at.rotate(rads,0, 0);
        at.translate(-this.image.getWidth() / 2, -this.image.getHeight() / 2);
        AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(this.image,rotatedImage);

        this.image = rotatedImage;
        this.setImage(this.image);
    }
}