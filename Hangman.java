 /* Names: Behram Irani, Abhyuday Sreenath
  * File Name: Hangman.java
  * Teacher: Mr.Juzkiw
  * School: Philip Pocock Catholic School
  * Description: This is the class that has all the methods (also code for the GUI) to make the HANGMAN GAME work.
  * The user is presented with empty blanks and a hit and must click the right letters belonging to the secret word.
  * The user wins if they have got through all 15 words.
  * Date Completed/Handed-in: June 20th,2011
  * Class: ICS4U1
 */

import javax.swing.*;  // needed for the Jgui items
import java.awt.*;   // needed for LayoutManager
import java.awt.event.*;  // needed for ActionListener

public class Hangman extends JFrame 
{
  private JLabel  hintDisplay, fillInBlanks, picture,incorrectChoicesDisplay, timesSkippedDisplay;
  private JButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z, start, next;
  private String hint, increasingWrong = "",redisplay;
  private JButton [] create = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};
  private int incorrectGuesses,wordsSkipped = 0,correctAnswers=0;
    private static int randomNumberGenerated=0;
    private static String randomWordGenerated = "";
   
public void runHangman(){
Hangman frame2 = new Hangman();
frame2.setTitle("Hangman");

frame2.pack();
frame2.setVisible(true);
frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame2.setLocationRelativeTo(null);// sets the location of the JFrame to the centre of the screen
frame2.setExtendedState(JFrame.MAXIMIZED_BOTH); // MAXIMIZES THE JFRAME
}
    
 public Hangman(){       
 hintDisplay = new JLabel("");
 hintDisplay.setFont(new Font("Serif", Font.BOLD, 15));
 fillInBlanks = new JLabel("");
 fillInBlanks.setFont(new Font("Serif", Font.BOLD, 35));
 picture = new JLabel();
 incorrectChoicesDisplay = new JLabel("");
 incorrectChoicesDisplay.setFont(new Font("Serif", Font.BOLD, 20));
 timesSkippedDisplay = new JLabel("");
 incorrectChoicesDisplay.setFont(new Font("Serif", Font.BOLD, 20));
    
 JPanel panel1 = new JPanel();   
 panel1.setBackground(Color.BLACK);
 add(panel1);

 JPanel twoButtonPanel = new JPanel();//this panel will include the START and next
 twoButtonPanel.setBackground(Color.ORANGE);
 twoButtonPanel.add(incorrectChoicesDisplay); 
 twoButtonPanel.add(timesSkippedDisplay);
 add(twoButtonPanel); 
 
 JPanel imagePanel = new JPanel();
 imagePanel.add(picture);
 imagePanel.setBackground(Color.WHITE);
 add(imagePanel);
 
 JPanel panel2 = new JPanel(new GridLayout(2, 1));
 panel2.add(panel1);
 panel2.add(twoButtonPanel);
 panel2.add(imagePanel);

 panel2.add(hintDisplay);
 panel2.add(fillInBlanks);
 panel2.setBackground(Color.YELLOW);
 add(panel2);  
 
theHandler handler = new theHandler();    

String [] buttonName = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
for(int i=0;i< create.length;i++){
create[i] = new JButton();
panel1.add(create[i]);
create[i].addActionListener(handler);
create[i].setText(buttonName[i]);
create[i].setEnabled(false);
}

start = new JButton("START");
twoButtonPanel.add(start);
start.addActionListener(handler);
next = new JButton("NEXT");
twoButtonPanel.add(next);
next.addActionListener(handler);
}    
 
 public class theHandler implements ActionListener{
 
 public void actionPerformed(ActionEvent e){  

String buttonClicked = e.getActionCommand();
    
if(buttonClicked.equals("START") ){  
start.setEnabled(false);
setButtonsEnabled(create);
randomNumberGenerated = generateRandomNumber();
randomWordGenerated = generateRandomWord();
hintDisplay.setText(hintForRandomWord());
displayLines();
picture.setIcon(new ImageIcon("welcome.jpg"));   
}
if(buttonClicked.equals("NEXT")){
JOptionPane.showMessageDialog(null, "THE WORD THAT YOU SKIPPED WAS: " + randomWordGenerated); 
wordsSkipped++;  
timesSkippedDisplay.setText("SKIPPED x " + wordsSkipped);
incorrectChoicesDisplay.setText("");// refresh since user gets 7 chances PER word to get the correct answer
  if(wordsSkipped > 3){
  JOptionPane.showMessageDialog(null, "We are sorry, you've lost...the program will shutdown now", "GAME OVER!", JOptionPane.PLAIN_MESSAGE);                              
  System.exit(0);
  }
refresh();
}

  else if(!randomWordGenerated.contains(buttonClicked)  && !buttonClicked.equals("START") && !buttonClicked.equals("NEXT")  ){
incorrectGuesses++;
increasingWrong = increasingWrong + buttonClicked;
incorrectChoicesDisplay.setText("WRONG GUESSES:" + increasingWrong ); 
switch(incorrectGuesses){
  case 1: picture.setIcon(new ImageIcon("hang1.jpg"));break;   
  case 2: picture.setIcon(new ImageIcon("hang2.jpg"));break;   
  case 3: picture.setIcon(new ImageIcon("hang3.jpg"));break;    
  case 4: picture.setIcon(new ImageIcon("hang4.jpg"));break;   
  case 5: picture.setIcon(new ImageIcon("hang5.jpg"));break;   
  case 6: picture.setIcon(new ImageIcon("hang6.jpg"));break;   
  case 7: picture.setIcon(new ImageIcon("hang7.jpg"));{
          JOptionPane.showMessageDialog(null, "We are sorry, you've lost...the program will shutdown now", "GAME OVER!", JOptionPane.PLAIN_MESSAGE);                              
          System.exit(0);}
}
} 
char [] lineArray = fillInBlanks.getText().toCharArray();// converts the blank lines displayed to a workable char array
for(int i=0; i < randomWordGenerated.length(); i++)
{  
        if(randomWordGenerated.charAt(i) == 'a'&& buttonClicked.equals("a")) {
        lineArray [i * 2] = 'a';   }  
        if(randomWordGenerated.charAt(i) == 'b' && buttonClicked.equals("b") ){
        lineArray [i * 2] = 'b';   }  
        if(randomWordGenerated.charAt(i) == 'c' && buttonClicked.equals("c") ){
        lineArray [i * 2] = 'c';   }  
        if(randomWordGenerated.charAt(i) == 'd' && buttonClicked.equals("d") ){
        lineArray [i * 2] = 'd';   }  
        if(randomWordGenerated.charAt(i) == 'e' && buttonClicked.equals("e") ){
        lineArray [i * 2] = 'e';   }  
        if(randomWordGenerated.charAt(i) == 'f' && buttonClicked.equals("f") ){
        lineArray [i * 2] = 'f';   }  
        if(randomWordGenerated.charAt(i) == 'g' && buttonClicked.equals("g") ){
        lineArray [i * 2] = 'g';   }  
        if(randomWordGenerated.charAt(i) == 'h' && buttonClicked.equals("h") ){
        lineArray [i * 2] = 'h';   }  
        if(randomWordGenerated.charAt(i) == 'i' && buttonClicked.equals("i") ){
        lineArray [i * 2] = 'i';   }  
        if(randomWordGenerated.charAt(i) == 'j' && buttonClicked.equals("j") ){
        lineArray [i * 2] = 'j';   }  
        if(randomWordGenerated.charAt(i) == 'k' && buttonClicked.equals("k") ){
        lineArray [i * 2] = 'k';   }  
        if(randomWordGenerated.charAt(i) == 'l' && buttonClicked.equals("l") ){
        lineArray [i * 2] = 'l';   }  
        if(randomWordGenerated.charAt(i) == 'm' && buttonClicked.equals("m") ){
        lineArray [i * 2] = 'm';   }  
        if(randomWordGenerated.charAt(i) == 'n' && buttonClicked.equals("n") ){
        lineArray [i * 2] = 'n';   }  
        if(randomWordGenerated.charAt(i) == 'o' && buttonClicked.equals("o") ){
        lineArray [i * 2] = 'o';   }  
        if(randomWordGenerated.charAt(i) == 'p' && buttonClicked.equals("p") ){
        lineArray [i * 2] = 'p';   }   
        if(randomWordGenerated.charAt(i) == 'q' && buttonClicked.equals("q") ){
        lineArray [i * 2] = 'q';   }  
        if(randomWordGenerated.charAt(i) == 'r' && buttonClicked.equals("r") ){
        lineArray [i * 2] = 'r';   }  
        if(randomWordGenerated.charAt(i) == 's' && buttonClicked.equals("s") ){
        lineArray [i * 2] = 's';   }  
        if(randomWordGenerated.charAt(i) == 't' && buttonClicked.equals("t") ){
        lineArray [i * 2] = 't';   }  
        if(randomWordGenerated.charAt(i) == 'u' && buttonClicked.equals("u") ){
        lineArray [i * 2] = 'u';   }  
        if(randomWordGenerated.charAt(i) == 'v' && buttonClicked.equals("v") ){
        lineArray [i * 2] = 'v';   }  
        if(randomWordGenerated.charAt(i) == 'w' && buttonClicked.equals("w") ){
        lineArray [i * 2] = 'w';   }  
        if(randomWordGenerated.charAt(i) == 'x' && buttonClicked.equals("x") ){
        lineArray [i * 2] = 'x';   }  
        if(randomWordGenerated.charAt(i) == 'y' && buttonClicked.equals("y") ){
        lineArray [i * 2] = 'y';   }  
        if(randomWordGenerated.charAt(i) == 'z' && buttonClicked.equals("z") ){
        lineArray [i * 2] = 'z';   }  
           
String redisplay = new String(lineArray);//converts back to String
fillInBlanks.setText(redisplay);
}
String redisplay = new String(lineArray);
redisplay = redisplay.replaceAll(" ", "");//removes all spaces 
        if(redisplay.compareTo(randomWordGenerated) == 0){//if the output with spaces removed is same as word generated...
        JOptionPane.showMessageDialog(null,"CORRECT! THE WORD WAS: " + randomWordGenerated);
        correctAnswers++;
        if(correctAnswers == 15){
        JOptionPane.showMessageDialog(null, "Great! You know your stuff!You got 15 correct answers...PROGRAM WILL CLOSE NOW");
        System.exit(0);
          }
        refresh();       
        }  
        
}//end action listener 
}//end handler class         

int [] num = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//length of array is as long as the list of words
private int generateRandomNumber(){  
int n=0;
boolean exit=false;
   do{
     n=(int)(15 *Math.random()+0);
     exit=false;
     for(int i=0;i<num.length+1;i++){
     if(n==num[i]){
         exit=true;
         break;}       
     
     else if(num[i]==0){
         num[i]=n;
         break;}
     }
   
    }while(exit);   
    return n;
}

private String generateRandomWord(){       
String [] words = {"democracy", "hazel_mccallion","leafs","maple","beaver","john_a_macdonald",
                  "stephen_harper","cn_tower","niagara_falls","robert_borden","terry_fox",
                  "rick_hansen","wayne_gretzky","roberta_bondar","ottawa",};
String randomWordGenerated = (words[randomNumberGenerated]);
return randomWordGenerated;
}  

private String hintForRandomWord(){
if(randomWordGenerated.equals("democracy") ){      
hint = "Hint: Our Government";  
}  
else if(randomWordGenerated.equals("hazel_mccallion")){
hint = "Hint: Current Mississauga Mayor";
}
else if(randomWordGenerated.equals("leafs")){
hint = "Hint: Toronto Hockey Team";
}
else if(randomWordGenerated.equals("maple")){
hint = "Hint: Syrup from a...tree";
}
else if(randomWordGenerated.equals("beaver")){
hint = "Hint: Canadian National Animal";
}
else if(randomWordGenerated.equals("john_a_macdonald")){
hint = "Hint: Our first Prime Minister";
}
else if(randomWordGenerated.equals("stephen_harper")){
hint = "Hint: Our current Prime Minister";
}
else if(randomWordGenerated.equals("cn_tower")){
hint = "Hint: Canada's tallest free-standing structure";
}
else if(randomWordGenerated.equals("niagara_falls")){
hint = "Hint: One of the world's 7 wonders right in our backyard";
}
else if(randomWordGenerated.equals("robert_borden")){
hint = "Hint:The man on the 100-dollar canadian bill";
}
else if(randomWordGenerated.equals("terry_fox")){
hint = "Hint: A young Canadian legend widely known for his fight against cancer";
}
else if(randomWordGenerated.equals("rick_hansen")){
hint = "Hint: Paralympian famous for Man In Motion World Tour";
}
else if(randomWordGenerated.equals("wayne_gretzky")){
hint = "Hint: Our greatest hockey player";
}
else if(randomWordGenerated.equals("roberta_bondar")){
hint = "Hint: First Canadian female astronaut";
}
else if(randomWordGenerated.equals("ottawa")){
hint = "Hint: Capital of Canada";
}
return hint;  
}

private void displayLines(){ // method to display the number of lines which will equal the number of characters in the RANDOM WORD
String displayLines = ""; 

for (int i = 0 ; i < generateRandomWord().length(); i++ ){
displayLines =  "_ " + displayLines ; 
fillInBlanks.setText(displayLines); 
}
} 

private void refresh(){ ///this method calls the generate random number, hintForRandomNumber, and displayLines...used to RESET
randomNumberGenerated = generateRandomNumber();
randomWordGenerated = generateRandomWord(); 
hintDisplay.setText(hintForRandomWord());
displayLines();
increasingWrong = ""; // resets the string and start from null again
incorrectGuesses = 0;
picture.setIcon(new ImageIcon("blank.jpg")) ;  
incorrectChoicesDisplay.setText("");
}  

public void setButtonsEnabled(JButton[] temp){    
for(int i=0; i < temp.length; i++){
temp[i].setEnabled(true);
 }
 }

 }//end handler class
 
 
 

    



     
  
 

