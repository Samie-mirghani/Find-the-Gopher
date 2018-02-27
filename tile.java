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
import  javax.swing.ImageIcon;

public class tile{

   ImageIcon buttonImage;
   int numberOfClicks;
   int tileNumber;
   boolean visited;
   tile(){
      numberOfClicks=0;
      tileNumber = 0;
      visited=false;
   }
   tile(int tileNum){
      numberOfClicks=0;
      tileNumber = tileNum;
      visited=false;
      buttonImage = new ImageIcon("caddyshack-gopher.jpg");
   }
   void setImageIcon(int num){
      if(num==1){
         tileNumber = num;
         buttonImage = new ImageIcon("num1.jpg");      
      }
      else if (num ==2){
         tileNumber = num;
         buttonImage = new ImageIcon("num2.jpg");      
      }
      else if(num==3){
         tileNumber = num;
         buttonImage = new ImageIcon("num3.jpg");      
      }
      else if (num ==4){
         tileNumber = num;
         buttonImage = new ImageIcon("num4.jpg");      
      }
      else if(num==5){
         tileNumber = num;
         buttonImage = new ImageIcon("num5.jpg");      
      }
      else if (num ==6){
         tileNumber = num;
         buttonImage = new ImageIcon("num6.jpg");      
      }
      else if(num==7){
         tileNumber = num;
         buttonImage = new ImageIcon("num7.jpg");      
      }
      else if (num ==8){
         tileNumber = num;
         buttonImage = new ImageIcon("num8.jpg");      
      }
      visited=false;
   }   
   ImageIcon getImageIcon(){
      numberOfClicks++;
      if(numberOfClicks==3)
         numberOfClicks=0;
   
      return buttonImage;
   }
   int getTileNumber(){
      return tileNumber;
   }
   int getClicks(){
      return numberOfClicks;
   }
   
   public void setClickReveal()
   {
      numberOfClicks=2;
   }
   boolean getVisited(){
      return visited;
   }
   
   public void setVisited()
   {
      visited=true;
   }


}