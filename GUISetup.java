/**
*@param args
*@author Mirghani
*@course CPSC 220
*@section 1
*@description This program is a game that 
*will ask the user to find all the gophers
*within the board and then submit their results  
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GUISetup extends JPanel{

   private JButton[][] t = new JButton[8][8];
   private JButton submit;
   private JPanel buttonPanel;
   private JTextArea output;
   private board myBoard;
   private int [][] gopher = new int[8][2];
   GUISetup(){
      myBoard = new board();
      setLayout(new FlowLayout());
      setPreferredSize(new Dimension(560, 800));
   
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(8, 8));
      for(int r = 0; r < 8; r++)
      {
         for(int c = 0; c < 8; c++)
         {
            t[r][c] = new JButton();
            t[r][c].setIcon(new ImageIcon("back.png"));
            t[r][c].setPreferredSize(new Dimension(70, 70));
            t[r][c].addActionListener(new TileListener());
            buttonPanel.add(t[r][c]);
            t[r][c].putClientProperty("column", c);
            t[r][c].putClientProperty("row", r);
            t[r][c].setHorizontalAlignment(SwingConstants.CENTER);
            t[r][c].setVerticalAlignment(SwingConstants.CENTER);
            myBoard.setTile(r,c);
         }
      }
      myBoard.setGophers();
      myBoard.setNumbers();
      add(buttonPanel);
      submit = new JButton("Click to See if you win");
      submit.addActionListener(new TileListener());
      add(submit);
      output = new JTextArea(10,40);
      JScrollPane scroll = new JScrollPane(output);
      add(output);
     
   }
     
       //***************************************************
   // Represents a listener for button push (action) events
   //***************************************************
   private class TileListener implements ActionListener
   {
      //----------------------------------------------
      // Updates the appropriate vote counter when a 
      // button is pushed for one of the candidates.
      //----------------------------------------------
      public void actionPerformed(ActionEvent e){
      
         JButton temp = (JButton) e.getSource();
         if(temp == submit)
         {
            if(myBoard.isWon())
               output.append("You won you can now play golf\n"); 
            else
               output.append("You did not find all the gophers you have to many holes on the course to play golf");
            myBoard.setClickReveal();
            for(int r = 0; r < 8; r++) {
               for(int c = 0; c < 8; c++) {            
                  ImageIcon image = myBoard.getTileImage(r,c); 
                  t[r][c].setIcon(image);  
               }
                        
            }
         
         }
         else{
            int col=(int)temp.getClientProperty("column");
            int row=(int)temp.getClientProperty("row");
            if (!myBoard.getVisited(row,col)){
               ImageIcon image = myBoard.getTileImage(row,col);
               if (myBoard.getClicks(row,col)==1){
                  temp.setIcon(new ImageIcon("Question_mark.png"));
               }
               else if(myBoard.getClicks(row,col)==0){
                  temp.setIcon(new ImageIcon("back.png"));
               }
               else if(myBoard.getClicks(row,col)==2){
                  int n = JOptionPane.showConfirmDialog(buttonPanel,
                        "Are you sure you want to reveal\n the final image.\n",
                        "A Question to Reveal the final image",
                         JOptionPane.YES_NO_OPTION);
                  if (n==0){
                     if( myBoard.reveal(row,col)){
                        for(int r = 0; r < 8; r++) {
                           for(int c = 0; c < 8; c++) { 
                              if(myBoard.getVisited(r,c)){         
                                 image = myBoard.getTileImage(r,c); 
                                 t[r][c].setIcon(image);  
                              }
                           }
                        } 
                     }
                     else{                  
                        myBoard.setClickReveal();
                        for(int r = 0; r < 8; r++) {
                           for(int c = 0; c < 8; c++) {            
                              image = myBoard.getTileImage(r,c); 
                              t[r][c].setIcon(image);  
                           }
                        
                        }
                        output.append("You Found A GOPHER and Fell in the HOLE\n"); 
                     }
                  
                  } 
                  else if (n==1) {
                     image = myBoard.getTileImage(row,col);
                     temp.setIcon(new ImageIcon("back.png"));
                  }
               }
            
            }
         }
      }
   }

}