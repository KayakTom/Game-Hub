package Main_Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Libraries.JPanelBackgroundImage.BackgroundImage;

public class GameSelection implements ActionListener {
    private JFrame Window;
    private int width, height, currentPageIndex = 1;
    private SpringLayout layout = new SpringLayout();
    
    private JButton[][] gameButtons = new JButton[3][9]; // Implement the buttons for the games
    private JButton exitGameSelection, nextPage, prevPage;

    private BackgroundImage gameSelection = new BackgroundImage("/Images/Game Selection.png");
    // private Icon pendingGameButton = new ImageIcon(getClass().getResource("/Images/Pending Development.png"));
    // private Icon exitGameSelectionButton = new ImageIcon(getClass().getResource("/Images/Exit Game Selection.png"));
    // private Icon nextPageButton = new ImageIcon(getClass().getResource("/Images/Right Arrow.png"));
    // private Icon prevPageButton = new ImageIcon(getClass().getResource("/Images/Left Arrow Selection.png"));

    public GameSelection(JFrame Window, int width, int height) {
        this.Window = Window;
        this.width = width;
        this.height = height;

        // Initialize the game selection menu
        this.gameSelection.setLayout(this.layout);
        this.gameSelection.setPreferredSize(new Dimension(this.width, this.height));

        this.Window.setContentPane(this.gameSelection);
        System.out.println("Game selection menu initialized with dimensions: " + this.width + "x" + this.height);
        this.Window.revalidate();
        this.Window.repaint();

        // this.exitGameSelection = new JButton(this.exitGameSelectionButton); For when I have the Icon
        this.exitGameSelection = new JButton("<html><center>Exit to main menu</html>");
        this.exitGameSelection.setPreferredSize(new Dimension(200, 30));
        this.exitGameSelection.addActionListener(this);
        this.layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.exitGameSelection, (this.width/4), SpringLayout.WEST, this.gameSelection);
        this.layout.putConstraint(SpringLayout.VERTICAL_CENTER, this.exitGameSelection, 0, SpringLayout.VERTICAL_CENTER, this.gameSelection);
        this.exitGameSelection.setEnabled(true);
        this.exitGameSelection.setVisible(true);
        this.gameSelection.add(this.exitGameSelection);

        // this.nextPage = new JButton(this.nextPageButton);
        this.nextPage = new JButton("<html><center>Next Page</html>");
        this.nextPage.setPreferredSize(new Dimension(200, 30));
        this.nextPage.addActionListener(this);
        this.layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.nextPage, -(this.width/4), SpringLayout.EAST, this.gameSelection);
        this.layout.putConstraint(SpringLayout.VERTICAL_CENTER, this.nextPage, 0, SpringLayout.VERTICAL_CENTER, this.gameSelection);
        this.nextPage.setEnabled(true);
        this.nextPage.setVisible(true);
        this.gameSelection.add(this.nextPage);

        // this.prevPage = new JButton(this.prevPageButton);
        this.prevPage = new JButton("<html><center>Previous Page</html>");
        this.prevPage.setPreferredSize(new Dimension(200, 30));
        this.prevPage.addActionListener(this);
        this.layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.prevPage, (this.width/4), SpringLayout.WEST, this.gameSelection);
        this.layout.putConstraint(SpringLayout.VERTICAL_CENTER, this.prevPage, 0, SpringLayout.VERTICAL_CENTER, this.gameSelection);
        this.prevPage.setEnabled(false);
        this.prevPage.setVisible(false);
        this.gameSelection.add(this.prevPage);
        
        for(int pageIndex = 1; pageIndex < this.gameButtons.length; pageIndex++){ // For all currently pending development game buttons
            for(int gameIndex = 1; gameIndex < this.gameButtons[pageIndex].length; gameIndex++){
            // gameButtons[i][j].setIcon(this.pendingGameButton); Use when image acquired
                this.gameButtons[pageIndex][gameIndex] = new JButton("<html><center> Pending <br> Development </html>");
                this.gameButtons[pageIndex][gameIndex].setPreferredSize(new Dimension(125, 125));
                this.gameButtons[pageIndex][gameIndex].addActionListener(this);
                if(gameIndex < 5){
                    // System.out.println(gameIndex);
                    this.layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.gameButtons[pageIndex][gameIndex], ((int)(this.width*0.25) + ((this.width/4)*gameIndex) - 384), SpringLayout.WEST, this.gameSelection);
                    this.layout.putConstraint(SpringLayout.VERTICAL_CENTER, this.gameButtons[pageIndex][gameIndex], (this.height/4), SpringLayout.NORTH, this.gameSelection);
                }
                else if(gameIndex > 3){
                    // System.out.println(gameIndex);
                    this.layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.gameButtons[pageIndex][gameIndex], (((int)(this.width*0.25)) + ((this.width/4)*(gameIndex-4)) - 384), SpringLayout.WEST, this.gameSelection);
                    this.layout.putConstraint(SpringLayout.VERTICAL_CENTER, this.gameButtons[pageIndex][gameIndex], ((int)((this.height/4)*2.75)), SpringLayout.NORTH, gameSelection);
                }
                if(pageIndex == 1){
                    this.gameButtons[pageIndex][gameIndex].setEnabled(true);
                    this.gameButtons[pageIndex][gameIndex].setVisible(true);
                }
                else{
                    this.gameButtons[pageIndex][gameIndex].setEnabled(false);
                    this.gameButtons[pageIndex][gameIndex].setVisible(false);
                }
                this.gameSelection.add(this.gameButtons[pageIndex][gameIndex]);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        // Handle actions for buttons in the game selection menu
        if(e.getSource() == this.exitGameSelection){
            System.out.println("Returning to main menu...");
            new Menu(this.Window, this.width, this.height);
            
            for(int gameIndex = 1; gameIndex < this.gameButtons.length; gameIndex++){
                this.gameButtons[this.currentPageIndex][gameIndex].setEnabled(false);
                this.gameButtons[this.currentPageIndex][gameIndex].setVisible(false);
            }

            this.prevPage.setEnabled(false);
            this.prevPage.setVisible(false);
            this.nextPage.setEnabled(false);
            this.nextPage.setVisible(false);
            this.exitGameSelection.setEnabled(false);
            this.exitGameSelection.setVisible(false);
        }
        if(e.getSource() == this.nextPage){
            if(this.currentPageIndex < this.gameButtons.length-1){
                System.out.println("Advancing to next page of games...");
                if(this.currentPageIndex+1 >= this.gameButtons.length){
                    this.nextPage.setEnabled(false);
                    this.nextPage.setVisible(false);
                }
                this.currentPageIndex++;
                if(this.currentPageIndex > 1){
                    this.exitGameSelection.setEnabled(false);
                    this.exitGameSelection.setVisible(false);
                    this.prevPage.setEnabled(true);
                    this.prevPage.setVisible(true);
                }
                if(this.currentPageIndex+1 >= this.gameButtons.length){
                    this.nextPage.setEnabled(false);
                    this.nextPage.setVisible(false);
                }
            }
            else{
                System.out.println("Trying to advance too far! Not got that many games yet!");
            }
        }
        if(e.getSource() == this.prevPage){
            if(this.currentPageIndex > 1){
                System.out.println("Advancing to previous page of games...");
                if(this.currentPageIndex-1 <= 1){
                    this.prevPage.setEnabled(false);
                    this.prevPage.setVisible(false);
                }
                this.currentPageIndex--;
                if(this.currentPageIndex == 1){
                    this.exitGameSelection.setEnabled(true);
                    this.exitGameSelection.setVisible(true);
                }
            }
        }
        if(this.Window.getContentPane() == this.gameSelection){
            for(int gameIndex = 1; gameIndex < this.gameButtons[this.currentPageIndex].length; gameIndex++){   
                if(e.getSource() == this.gameButtons[this.currentPageIndex][gameIndex]){
                    System.out.println("Game " + (gameIndex) + " is selected on page "+ (this.currentPageIndex) + "!");
                }
            }
        }
    }
}