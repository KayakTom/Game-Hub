package Main_Menu;

import java.awt.*;
import javax.swing.*;

import Libraries.JPanelBackgroundImage.BackgroundImage;

public class Menu {
    // Gets the user screen dimensions (height and width)
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int windowWidth = (int)(screenSize.getWidth() / 1.5);
    private int windowHeight = (int)(screenSize.getHeight() / 1.5);

    private JFrame Window;
    private SpringLayout layout = new SpringLayout();
    private BackgroundImage menu = new BackgroundImage("/Images/Game Hub.png");

    public Menu(){
        // Initialises the game hub menu
        this.Window = new JFrame("Game Hub");
        this.menu.setLayout(layout);

        this.Window.setSize(this.windowWidth, this.windowHeight);
        this.menu.setPreferredSize(new Dimension(this.windowWidth, this.windowHeight));
        this.Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.Window.setResizable(false); // Temporary until we get everything adaptable to the screen size
        this.Window.setLocationRelativeTo(null); // Centers the window on the screen

        this.Window.setContentPane(this.menu);
        this.Window.setVisible(true);
    }
}