package Main_Menu;

import java.awt.*;
import javax.swing.*;

import Libraries.GameArena.GameArena;

public class Menu {
    // Gets the user screen dimensions (height and width)
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int windowWidth = (int)screenSize.getWidth();
    private int windowHeight = (int)screenSize.getHeight();

    private JFrame Window;
    private JPanel menu;
    private SpringLayout layout;

    private GameArena mainMenu = new GameArena(windowWidth, windowHeight, false);


    public Menu(){
        // Initialises the game hub menu
        this.Window = new JFrame("Game Hub");
        this.menu = new JPanel();
        this.menu.setLayout(layout);

        this.Window.setSize(this.windowWidth, this.windowHeight);
        this.Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.Window.setResizable(false); // Temporary until we get everything adaptable to the screen size
    }

    public void loadMenu(){
        this.mainMenu.setBackgroundImage("Images/gameHubBackground.png");

        this.Window.add(this.menu);
    }
}