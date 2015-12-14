/****************************************************************************************
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Writer for this Class: Alyssa Rivera
 * 
 * File name: Path.java
 * Date Created: 12/8/15
 * Last Updated: 12/12/15
 * Updater: Mary DuBard
 * Known Bugs: None
 * 
 * Class that represents the Paths between two Locations
 ****************************************************************************************/

import java.util.*;

public class Path implements Comparable<Path> {
  private double distance; //distance of path in miles
  private boolean hasStairs; private boolean hasHills; //acesibility booleans
  private LinkedList<String> directions; //used in getDirections()
  
  
  /****************************************************************************************
   *   Constructs a Path object given distance, info on stairs, and info on hills
   * 
   * @param dist    the distance of the path in feet
   * @param stairs  true if the path contains stairs
   * @param hill    true if the path is hilly
   ****************************************************************************************/
  public Path (double dist, boolean stairs, boolean hill){
    distance = dist;
    hasStairs = stairs;
    hasHills = hill;
    directions = new LinkedList<String>(); //initializes
  }
  
  /****************************************************************************************
   *   Constructs a Path object given distance, info on stairs, info on hills, and directions
   * 
   * @param dist    the distance of the path in feet
   * @param stairs  true if the path contains stairs
   * @param hill    true if the path is hilly
   * @param dir     String LinkedList of directions
   ****************************************************************************************/
  public Path (double dist, boolean stairs, boolean hill, LinkedList<String> dir){
    distance = dist;
    hasStairs = stairs;
    hasHills = hill;
    directions = dir;
  }
  
  /****************************************************************************************
    compareTo() 
     
    Compares this path to that path. Returns a floored int of difference in time between the two paths.
    Negative when this is a shorter walk than that. Zero when the times are equal. Positive when this is longer.
    Takes Object type as parameter to satisfy Comparable's abstract method, returns Integer.MIN_VALUE if param not Path
    
    @param that the Path to compare to this path
    @return     the difference in walking times of the paths
   ****************************************************************************************/
  public int compareTo(Path that){
    return (int) (this.getDistance() - that.getDistance());
  }
  
  /****************************************************************************************
    toString()
    
    Returns a String representation of this Path, including all the information
   ****************************************************************************************/
  public String toString() {
    return "Minutes: " + this.calculateTime() + "\tDistance: " + this.getDistance() + 
      "\nAccessiblity: " +(this.hasStairs()?"Has Stairs" : "No Stairs") + "\t" +
      (this.hasHills()? "Has Hills" : "No Hills");
  }
  
  
  
  /****************************************************************************************
    calculateTime()
    
    Returns the time it takes to walk this path, calculated by distance
    average walking speed: 3.1 miles per hour  = 273 feet per minute
    
    @return    the time it takes to walk this path
   ****************************************************************************************/
  public double calculateTime(){
    return distance/273;
  }
  
  
  
  ////////////Getter Methods/////////
  
  /****************************************************************************************
  getDistance()
  
  returns the distance
  ****************************************************************************************/
  public double getDistance(){
    return distance;
  }
  
  /****************************************************************************************
  hasStairs()
  
  returns true if the path has stairs, returns false if not
  ****************************************************************************************/
  public boolean hasStairs(){
    return hasStairs;
  }

 /****************************************************************************************
  hasHills()
  
  returns true if the path has hills, returns false if not
  ****************************************************************************************/
  public boolean hasHills(){
    return hasHills;
  }
  
  /****************************************************************************************
  getDirections()
  
  returns the linked list of directions
  ****************************************************************************************/
  public LinkedList<String> getDirections(){
    return directions;
  }
  
  
  
  ///////////Setter Methods///////////
  
 /****************************************************************************************
  setDistance()
  
  sets the distance variable of the path
  ****************************************************************************************/
  public void setDistance(int d){
    distance = d;
  } 
  
  /****************************************************************************************
  sethasStairs()
  
  sets the hasStairs variable of the path
  ****************************************************************************************/
  public void setHasStairs(boolean s){
    hasStairs = s;
  }
  
  /****************************************************************************************
  setHasHills()
  
  sets the hasHills variable of the path
  ****************************************************************************************/
  public void setHasHillss(boolean h){
    hasHills = h;
  }
  
  /****************************************************************************************
  setDirections()
  
  sets the directions variable of the path
  ****************************************************************************************/
  public void setDirections(LinkedList<String> dir){
    directions = dir;
  }
}