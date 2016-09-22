 /* Names: Behram Irani, Abhyuday Sreenath
  * File Name: StopWatch.java
  * Teacher: Mr.Juzkiw
  * School: Philip Pocock Catholic School
  * Description: This is a timer class to make a timer for the JUMBLE game.
  * Date Completed/Handed-in: June 20th,2011
  * Class: ICS4U1
 */

public class StopWatch {

private long startTime;
private long stopTime;
    
public void start() {
startTime = System.currentTimeMillis();
 }
public void stop() {
stopTime = System.currentTimeMillis();
}
public long getTime() {
return stopTime - startTime;
}
public void restart(){
startTime = System.currentTimeMillis();   
}
}

