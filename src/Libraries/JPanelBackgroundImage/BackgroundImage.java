package Libraries.JPanelBackgroundImage;

import javax.swing.*;
import java.awt.*;

public class BackgroundImage extends JPanel{

    private Image image;

    public BackgroundImage(String backgroundImage){
        try{
            image = javax.imageio.ImageIO.read(getClass().getResource(backgroundImage));
        }
        catch (Exception e){

        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(image != null){
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}