import Main_Menu.Menu;

import javax.swing.*;
import java.awt.*;

public class Driver {
    
    public static void main(String[] args) {
        // Create an instance of the Menu class to display the game hub
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Menu mainMenu;
        JFrame Window = new JFrame("Game Hub");
        int windowWidth = (int)(screenSize.getWidth() / 1.5);
        int windowHeight = (int)(screenSize.getHeight() / 1.5);

        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets the default close operation
        Window.setSize(windowWidth, windowHeight); // Sets the size of the window
        Window.setResizable(false); // Temporary until we get everything adaptable to the screen size
        Window.setLocationRelativeTo(null); // Centers the window on the screen

        mainMenu = new Menu(Window, windowWidth, windowHeight);

        // ISSUE: Would need to run forever and forever loops not good practice (chaining is solution)
      
    }
}
