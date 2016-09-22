 /* Names: Behram Irani, Abhyuday Sreenath
  * File Name: MainGui.java
  * Teacher: Mr.Juzkiw
  * School: Philip Pocock Catholic School
  * Description: This is the main class that houses the main GUI/JFrame. 
  * It calls upon the other classes and their corresponding methods to make all the 3 games 
  * easily accessible. 
  * Date Completed/Handed-in: June 20th,2011
  * Class: ICS4U1
 */

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGui extends JFrame {

public JButton playHangman, playJumble, playMagicNumber;

public MainGui(){
playHangman = new JButton("PLAY HANGMAN");
playHangman.setVisible(true);
playJumble = new JButton("PLAY JUMBLE");
playJumble.setVisible(true);
playMagicNumber = new JButton("PLAY MAGIC NUMBER");                   
playMagicNumber.setVisible(true);

JPanel mainPanel = new JPanel();
add(mainPanel);
mainPanel.add(playHangman);
mainPanel.add(playJumble);
mainPanel.add(playMagicNumber);
mainPanel.setBackground(new Color(0,200,200));
theMainHandler mainHandle = new theMainHandler();

playHangman.addActionListener(mainHandle);
playJumble.addActionListener(mainHandle);
playMagicNumber.addActionListener(mainHandle);
}  

public static void main(String[] args){
MainGui mainFrame = new MainGui();
mainFrame.setTitle("Welcome to Behram and Abhyuday's Culminating Game 2011");
mainFrame.pack();
mainFrame.setVisible(true);
mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
mainFrame.setLocationRelativeTo(null);// sets the location of the JFrame to the centre of the screen
mainFrame.setSize(500,150);
}

public class theMainHandler implements ActionListener{
  
Hangman hangObject = new Hangman ();
Jumble jumbleObject = new Jumble ();
MagicNumber magicObject = new MagicNumber(); 

public void actionPerformed(ActionEvent ev){  
String buttonClicked = ev.getActionCommand();

if(buttonClicked.equals("PLAY HANGMAN") ){
hangObject.runHangman();
}
if(buttonClicked.equals("PLAY JUMBLE") ){
jumbleObject.runJumbleGame();   
}
if(buttonClicked.equals("PLAY MAGIC NUMBER")){
magicObject.runMagicNumberGame();  
}


}
}
}

