/*************************************************************************************
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Author of this class: Alyssa Rivera
 * 
 * Created: December 8th, 2015
 * Last Modified: December 10th, 2015
 * Known Bugs: none
 * 
 * Represents a location on Wellesley's campus, including the following information:
 * name, description, image of the place
 * Necessary for the Map class
 *************************************************************************************/ 

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Location implements Comparable<Location> {

  private String name, about;
  private Image picture;
  private double distance; //used for getDirections map method
  
  /******************************************************************
    Location(String n, String a, String fileName)
    
    @param n         name of the Location
    @param a         about information of the Location
    @param fileName  location of the picture of the Location
     
    Creates a Location object with a name, about, and picture.
    Imports the picture from the given fileName.
    Sets distance to 0.0.
   ******************************************************************/ 
  public Location(String n, String a, String fileName){
    name = n;
    about = a;
    distance = 0.0;
    try{
      picture = ImageIO.read(new File (fileName));
    }
    catch(IOException e){
      System.out.println(e);
    }
  }
  
   /******************************************************************
    Location(String n)
    
    @param n   name of the Location
    
    Creates a Location object with a name, an empty about, and a 
    Wellesley logo as the image. Sets distance to 0.0.
    ******************************************************************/
  public Location (String n){
    name = n;
    about = " ";
    distance = 0.0;
    try{
    picture = ImageIO.read( new File ("wellesleylogo.png"));
    }
    catch(IOException e){
    System.out.println ("picture import failed");
    }
  }  
  
  /******************************************************************
    toString()
    
    @return   the String representation 
    
    Returns a String representation of the Location.
    Includes the name.
   ******************************************************************/ 
  public String toString(){
    return name; 
  }
  
  /******************************************************************
    compareTo(Location that)
    
    @param  that  Location to compare to
    @return       0 if distances equal, -1 if this smaller than other, 1 if this bigger than other
    
    Compares two Location objects. 
   ******************************************************************/ 
  public int compareTo(Location that){
      if(this.getDistance() == that.getDistance())
        return 0;
      else if (this.getDistance()<that.getDistance())
        return -1;
      return 1;
  }
  
  
  /***************Getter Methods***************/
  public String getName(){
  return name;
  }
  
  public String getAbout(){
  return about;
  }
  
  public Image getPic(){
  return picture;
  }
  
  public double getDistance(){
  return distance;
  }
  
  /***************Setter Methods***************/
  public void setName(String n){
  name = n;
  }
  
  public void setAbout(String a){
  about = a;
  }
  
  public void setDistance(double d){
  distance = d;
  }
  
  public void setPicture(String fileName){
          try{
      picture = ImageIO.read(new File (fileName));
    }
    catch(IOException e){
      System.out.println("Picture could not be imported in setPicture().");
    }
  }  
}