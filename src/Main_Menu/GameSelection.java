package Main_Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Libraries.JPanelBackgroundImage.BackgroundImage;

public class GameSelection implements ActionListener {
    private JFrame window;
    private int width, height;
    private JButton[][] gameButtons = new JButton[9][1]; // Implement the buttons for the games

    private BackgroundImage gameSelection = new BackgroundImage("/Images/Game Selection.png");
    private SpringLayout layout = new SpringLayout();

    // private JButton 

    public GameSelection(JFrame Window, int width, int height) {
        this.window = Window;
        this.width = width;
        this.height = height;

        // Initialize the game selection menu
        this.gameSelection.setLayout(this.layout);
        this.gameSelection.setPreferredSize(new Dimension(this.width, this.height));

        this.window.setContentPane(this.gameSelection);
        System.out.println("Game selection menu initialized with dimensions: " + this.width + "x" + this.height);
        this.window.revalidate();
        this.window.repaint();

        this.gameSelection.setFocusable(true);
        this.gameSelection.requestFocusInWindow();
        
        if(this.gameSelection.isFocusable()) {
            System.out.println("Game selection menu is focusable.");
        } else {
            System.out.println("Game selection menu is not focusable.");
        }

        InputMap inputMap = this.gameSelection.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.gameSelection.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "exitGameSelection");
        actionMap.put("exitGameSelection", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting game selection menu...");
                new Menu(window, width, height);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "nextPage");
        actionMap.put("nextPage", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Next page action triggered.");
                // Hide/deactivate current game buttons
                // Show/activate new game buttons
                // Track which page it's currently on i++ (i set at 1 for page 1, etc.) increment per page
                    // If at last page, do nothing
                // Implement logic for next page if needed
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "prevPage");
        actionMap.put("prevPage", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Previous page action triggered.");
                // Hide/deactivate current game buttons
                // Show/activate new game buttons
                // Track which page it's currently on i++ (i set at 1 for page 1, etc.) decrement per page
                    // If at first page, do nothing
                // Implement logic for next page if needed
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        // Handle actions for buttons in the game selection menu
        // For now, this method does nothing
    }
}