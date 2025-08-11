package Main_Menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Libraries.JPanelBackgroundImage.BackgroundImage;

public class Menu implements ActionListener {
    private JFrame Window;
    private int width, height;

    private SpringLayout layout = new SpringLayout();
    private BackgroundImage menu = new BackgroundImage("/Images/Game Hub.png");
    private Icon playButtonImage = new ImageIcon(getClass().getResource("/Images/PLAY.png"));

    private JButton playButton = new JButton();

    public Menu(JFrame Window, int width, int height) {
        // Initialises the game hub menu
        this.Window = Window;
        this.width = width;
        this.height = height;

        this.menu.setLayout(layout);

        this.menu.setVisible(false);

        this.menu.setPreferredSize(new Dimension(width, height));

        this.Window.setContentPane(this.menu);
        this.Window.setVisible(true);
        
        this.layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.playButton, 0, SpringLayout.HORIZONTAL_CENTER, this.menu);
        this.layout.putConstraint(SpringLayout.VERTICAL_CENTER, this.playButton, 0, SpringLayout.VERTICAL_CENTER, this.menu);

        this.playButton.setPreferredSize(new Dimension(300, 75));
        this.playButton.setIcon(this.playButtonImage);
        this.playButton.addActionListener(this);


        this.menu.add(playButton);
        this.menu.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        // This method will handle the actions for the buttons in the menu
        // For now, it does nothing

        if(e.getSource() == this.playButton && this.Window.getContentPane() == this.menu){
            this.playButton.setEnabled(false);
            this.playButton.setVisible(false);
            // System.out.println("Play button clicked, transitioning to game selection menu...");
            // Instantiate the game selection menu here
            System.out.println("Initializing game selection menu...");
            GameSelection gameSelection = new GameSelection(this.Window, this.width, this.height);
        }

    }
}