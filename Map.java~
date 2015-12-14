/* 
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Writer for this Class: Hannah Murphy
 * 
 * File name: Map.java
 * Date Created: 12/8/15
 * Last Updated: 12/12/15
 * 
 * Creates an instance of a Map Object, which provides the finctionality for the map represented in WalkingEffectGUI.java
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javafoundations.*;


public class Map implements Graph<Location>{//, Iterator<Location>{
  
  private int n;   // number of locations in the graph
  private Path[][] paths;   // adjacency matrix of arcs
  private Location[] locations; 
  public static final int NOT_FOUND = -1;
  private static final int DEFAULT_CAPACITY = 1;
  private final int INFINITY = 1000000;
  
  /******************************************************************* 
    Map()
    
    Constructor
    Makes an empty Map object
    Sets n (number of locations) to 0
   ******************************************************************/ 
  public Map(){
    locations = new Location[DEFAULT_CAPACITY];
    paths = new Path[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    n = 0;
  }
  
  
  /////////////////VERTEX/LOCATION RELATED METHODS////////////////////////
  /******************************************************************
    addVertex()
    
    Adds a given Location to the Map, if there is not enough room in locations[], expand the capacity
    ******************************************************************/
  public void addVertex (Location vertex) {
    if (getIndex(vertex) != NOT_FOUND) return;
    if (n == locations.length) {
      expandCapacity();
    }
    
    locations[n] = vertex;
    for (int i = 0; i <= n; i++) {
      paths[n][i] = null;
      paths[i][n] = null;
    }      
    n++;
  }
  
  /******************************************************************
   getLocations()
   
   returns string array of all Location names
   Used to populate the Map Key text fields in the application GUI
   ******************************************************************/
  public String[] getLocations(){
    String[] locs = new String[n];
    for(int i = 0; i < n; i++){
      locs[i] = locations[i].getName();
    }
    return locs;
  }
  
  /******************************************************************
   getLocations()
   
   returns string array of all Location names
   Used to populate the Map Key text fields in the application GUI
   ******************************************************************/
  public String[] getLocationsCombo(){
    
    String[] locs = new String[n+1];
    locs[0] = "No location selected."; 
    for(int i = 1; i <= n; i++){
      locs[i] = locations[i-1].getName();
    }
    return locs;
  }
  
  /******************************************************************
   getAllVertices()
   
   returns the array of Locations in the Map
   ******************************************************************/
  public Location[] getAllVertices(){
    return locations;
  }
  
  /******************************************************************
   findLocation()
   
   Given the name of the location, return the corresponfding Location Object
   ******************************************************************/
  public Location findLocation(String loc){
    for(int i = 0; i < n; i++){
      if(locations[i].getName().equalsIgnoreCase(loc))
        return locations[i];
    }
    return null;
  }
  /******************************************************************
    containsVertex()
    
    returns true if the map contains the passed vertex.
    ******************************************************************/
  public boolean containsVertex(Location vertex) {
    return getIndex(vertex) != NOT_FOUND;
  }
  
  
  /******************************************************************
    getVertex()
    
    returns the vertex at the given index in vertices. 
    trhows exception is index is not valid
    ******************************************************************/
  protected Location getVertex(int v) {
    if (!indexIsValid(v)) {
      throw new IllegalArgumentException("No such vertex index: " + v);
    }
    return locations[v]; 
  }
  
  /******************************************************************
    removeVertex()
    
    removes the passed vertex from the map by getting the index of the vertex 
    and passing it to removeVertex(int)
    does nothing if vertex is not in map
    LOCATION PARAMETER
    ******************************************************************/
   public void removeVertex (Location vertex) {
    int index = getIndex(vertex);
    if (index != NOT_FOUND) {
      removeVertex(index);
    }
  } 
   
   /******************************************************************
    removeVertex()
    
    removes the location at the given index from the map. updates adjacency matrix (paths)
    to remove the spaces allotted for the removed vertex
    throws excepton if index is not valid
    INDEX(INTEGER) PARAMTER
    ******************************************************************/
  protected void removeVertex (int index) {
    if (!indexIsValid(index)) {
      throw new IllegalArgumentException("No such vertex index");
    }
    n--;
    
    // Remove vertex.
    for (int i = index; i < n; i++) {
      locations[i] = locations[i+1];
    }
    
    // Move rows up.
    for (int i = index; i < n; i++) {
      for (int j = 0; j <= n; j++) {
        paths[i][j] = paths[i+1][j];
      }
    }
    
    // Move columns left
    for (int i = index; i < n; i++) {
      for (int j = 0; j < n; j++) {
        paths[j][i] = paths[j][i+1];
      }
    }
    
    // Erase last row and last column
    for (int a = 0; a < n; a++) {
      paths[n][a] = null;
      paths[a][n] = null;
    }
  }
  
  /******************************************************************
    expandCapacity()
    
    Helper Method - copies locations[] and paths[][] into larger arrays
    Called when there is no more space to add more vertices
    ******************************************************************/
  @SuppressWarnings("unchecked")
  private void expandCapacity() {
    Location[] largerVertices = new Location[locations.length*2];
    Path[][] largerAdjMatrix = 
      new Path[locations.length*2][locations.length*2];
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        largerAdjMatrix[i][j] = paths[i][j];
      }
      largerVertices[i] = locations[i];
    }
    
    locations = largerVertices;
    paths = largerAdjMatrix;
  }
  
  
  //////////////////////ARC/PATH RELATED METHODS///////////////////////
  /******************************************************************
    addArc()
    
    Inserts an arc from srcVertex to destVertex.
    If the vertices exist, else does not change the graph. 
    LOCATION PARAMETERS
    ******************************************************************/
  public void addArc(Location srcVertex, Location destVertex, Path newPath) {
    int src = getIndex(srcVertex);
    int dest = getIndex(destVertex);
    if (src != NOT_FOUND && dest != NOT_FOUND) {
      addArc(src, dest, newPath);
    }
  }
  
  /******************************************************************
    addArc()
    
    Helper. Inserts an edge between two vertices of the graph.
    @throws IllegalArgumentException if either index is invalid.
    INTEGER (INDEX) PARAMETERS
    ******************************************************************/
  protected void addArc(int srcIndex, int destIndex, Path newPath) {
    if (!indexIsValid(srcIndex) || !indexIsValid(destIndex)) {
      throw new IllegalArgumentException("One or more invalid indices: " + srcIndex + ", " + destIndex);
    }
    paths[srcIndex][destIndex] = newPath;
  }
  
  /******************************************************************
    addEdge()
    
    Inserts an edge between two vertices of the graph.
    If one or both vertices do not exist, ignores the addition.
    LOCATION PARAMETERS
    ******************************************************************/
  public void addEdge(Location vertex1, Location vertex2, Path edge) { //also add path parameters
    int index1 = getIndex(vertex1);
    int index2 = getIndex(vertex2);
    if (index1 != NOT_FOUND && index2 != NOT_FOUND) {
      addArc(index1, index2, edge);
      addArc(index2, index1, edge);
    }
  }
  
  /*****************************************************************
    addEdge()
    
    Not used - only fulfills requirement in Graph interface
    ***************************************************************/
  
  public void addEdge(Location vertex1, Location vertex2) { //also add path parameters
    int index1 = getIndex(vertex1);
    int index2 = getIndex(vertex2);
    if (index1 != NOT_FOUND && index2 != NOT_FOUND) {
      Path edge = new Path(NOT_FOUND, false, false);
      addArc(index1, index2, edge);
      addArc(index2, index1, edge);
    }
  }
  
  /******************************************************************
    addArc()
    
    Not used - only fulfills requirement in Graph interface
    ******************************************************************/
  public void addArc(Location srcVertex, Location destVertex){//, Path edge) { //add path variables
    int src = getIndex(srcVertex);
    int dest = getIndex(destVertex);
    if (src != NOT_FOUND && dest != NOT_FOUND) {
      Path edge = new Path(NOT_FOUND, false, false);
      addArc(src, dest, edge);
    }
  }
  
  /******************************************************************
    isArc()
    
    returns true if a path exists between the two passed locations
    LOCATION PARAMETERS
    ******************************************************************/
   public boolean isArc(Location srcVertex, Location destVertex) {
    int src = getIndex(srcVertex);
    int dest = getIndex(destVertex);
    return src != NOT_FOUND && dest != NOT_FOUND && paths[src][dest] != null;
  }
   
   /******************************************************************
    isArc()
    
    returns true if a path exists between the two passed locations
    INDEX (INTEGER) PARAMETERS
    ******************************************************************/
  protected boolean isArc(int srcIndex, int destIndex) {
    if (!indexIsValid(srcIndex) || !indexIsValid(destIndex)) {
      throw new IllegalArgumentException("One or more invalid indices: " + srcIndex + ", " + destIndex);
    }
    return paths[srcIndex][destIndex] != null;
  }
  
   /******************************************************************
    isEdge()
    
    returns true if a path exists between the two passed locations (both ways)
    LOCATION PARAMETERS
    ******************************************************************/
  public boolean isEdge(Location srcVertex, Location destVertex) {
    int src = getIndex(srcVertex);
    int dest = getIndex(destVertex);
    return src != NOT_FOUND && dest != NOT_FOUND && isArc(src, dest) && isArc(dest, src);
  }
  
  /******************************************************************
    hillsExist()
    
    returns true if a path contains hills
    ******************************************************************/
  public boolean hillsExist(int srcVertex, int destVertex) {
   Path p = getPath(srcVertex, destVertex);
   return p.hasHills();
  }
  
  /******************************************************************
    stairsExist()
    
    returns true if a path contains stairs
    ******************************************************************/
  public boolean stairsExist(int src, int dest) {
   Path p = getPath(src, dest);
   return p.hasStairs();
  }
  
   /******************************************************************
    getPath()
    
    returns the path object between the specified locations
    ******************************************************************/
  public Path getPath(int src, int dest) {
    //int src = getIndex(srcVertex);
    //int dest = getIndex(destVertex);
    if(isArc(src, dest)){
      return paths[src][dest];
    }
       return null;
       }
  
  /******************************************************************
    removeEdge() 
    
    Removes an edge (both arcs) from vertex src to vertex dest,
    if the vertices exist, else does not change the graph. 
    LOCATION PARAMETERS
    ******************************************************************/
  public void removeEdge(Location vertex1, Location vertex2) {
    int index1 = getIndex(vertex1);
    int index2 = getIndex(vertex2);
    if (index1 != NOT_FOUND && index2 != NOT_FOUND) {
      removeArc(index1, index2);
      removeArc(index2, index1);
    }
  }
  
  
  /******************************************************************
    removeArc() 
    
    Removes an arc from vertex src to vertex dest,
    if the vertices exist, else does not change the graph. 
    LOCATION PARAMETERS
    ******************************************************************/
  public void removeArc(Location srcVertex, Location destVertex) {
    int src = getIndex(srcVertex);
    int dest = getIndex(destVertex);
    if (src != NOT_FOUND && dest != NOT_FOUND) {
      removeArc(src, dest);
    }
  }
  
  /******************************************************************
    removeArc()
    
    Helper. Removes an arc from index v1 to index v2.
    @throws IllegalArgumentException if either index is invalid.
    INDEX (INTEGER) PARAMETERS
    ******************************************************************/
  protected void removeArc(int srcIndex, int destIndex) {
    if (!indexIsValid(srcIndex) || !indexIsValid(destIndex)) {
      throw new IllegalArgumentException("One or more invalid indices: " + srcIndex + ", " + destIndex);
    }
    paths[srcIndex][destIndex] = null;
  }
  
  //////////////////////////GRAPH FUNCTIONS/////////////////////////
  
  /*****************************************************************
    isEmpty()
    
    returns true if the Map is empty (has no locations)
    ***************************************************************/
  public boolean isEmpty() {
    return n == 0;
  }
  
  /*****************************************************************
    getIndex()
    
    returns the index in locations[] of the given location
    returns NOT_FOUND if location is not in the graph
    ***************************************************************/
  protected int getIndex(Location loc) {
    for (int i = 0; i < n; i++) {
      if (locations[i].equals(loc)) {
        return i;
      }
    }
    return NOT_FOUND;
  }
  
  /******************************************************************
    indexIsValid()
    
    returns true if there should be a location object at the given index
    ******************************************************************/
  protected boolean indexIsValid(int index) {
    return index < n && index >= 0;  
  } 
  
  /******************************************************************
    isUndirected()
    
    Not used - only fulfills requirement in Graph interface
    ******************************************************************/
  public boolean isUndirected(){
    throw new UnsupportedOperationException();
    
  }
  
  /******************************************************************
    n()
    
    Returns the number of locations in the graph (n).
    ******************************************************************/
  public int n() {
    return n;
  }
  
  /******************************************************************
    m()
    
    Returns the number of paths in the map by counting them.
    ******************************************************************/
  public int m() {
    int total = 0;
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (paths[i][j] != null) {
          total++;
        }
      }
    }
    return total; 
  }
  
  ////////////////////////ITERATOR/////////////////////////////
  
  /******************************************************************
    VerticesIterator
    
    Provides an iterator to run through the locations in a map
    ******************************************************************/
  private class VerticesIterator implements Iterator<Location> {
    private int cursor = 0;
    
    /** Check if the iterator has a next vertex */
    public boolean hasNext() {
      return cursor < n;
    }
    
    /** Get the next vertex. */
    public Location next() {
      if (cursor >= n) {
        throw new NoSuchElementException();
      } else {
        return locations[cursor++];
      }
    }
    
    /** Remove is not supported in this iterator. */
    public void remove() {
      throw new UnsupportedOperationException();
    } 
  }
  
  /******************************************************************
    iterator()
    
    creates and returns a new VerticesIterator
    ******************************************************************/
  public Iterator<Location> iterator() {
    return new VerticesIterator();
  }
  
  
  ///////////////////////GETTERS OF LOCATIONS////////////////////////////////
  
  /******************************************************************
    getPredecessors()
    
    Retrieve from a graph the vertices x pointing to vertex v (x->v)
    and returns them onto a linked list. Returns emptylist if there are no predecessors
    ******************************************************************/
  public LinkedList<Location> getPredecessors(Location loc) {
    LinkedList<Location> neighbors = new LinkedList<Location>();
    
    int v = getIndex(loc); 
    
    if (v == NOT_FOUND) return neighbors;
    for (int i = 0; i < n; i++) {
      if (paths[i][v] != null) {
        neighbors.add(getVertex(i)); // if T then add i to linked list
      }
    }    
    return neighbors;    
  }
  
  /******************************************************************
    getSuccessors()
    
    Retrieve from a graph the vertices x following vertex v (v->x)
    and returns them onto a linked list. Returns empty list if there are no successors
    ******************************************************************/
  public LinkedList<Location> getSuccessors(Location loc){
    LinkedList<Location> neighbors = new LinkedList<Location>();
    
    int v = getIndex(loc); 
    
    if (v == NOT_FOUND) return neighbors;
    for (int i = 0; i < n; i++) {
      if (paths[v][i] != null) {
        neighbors.add(getVertex(i)); // if T then add i to linked list
      }
    }    
    return neighbors;    
  }
  
  /////////////////////GETDIRECTIONS AND RELATED METHODS//////////////////////
  
  /******************************************************************
   getDirections()
   
   Returns an integer matrix that provides directions for shortest path between Location a and Location b by implementing Dijktra's algorithm.
   Integers in array represent Locations in locations array that were visited to get the shortest route.
   ******************************************************************/
  public int[] getDirections(Location orig, Location dest){
    //double[] tempDistances = new double[n]; //array to store calculated shortest distance to node from origin
    PriorityQueue<Location> q = new PriorityQueue<Location>(); //a priority queue that prioritizes by distance from origin
    int[] previous = new int[n]; //stores index of node visited before each node ie if previous[3] = 1, then we traveled from node 1 to node 3
    
    for(int i = 0; i < n; i++){
      locations[i].setDistance(INFINITY); //sets shortest distance from orig to node as infinity
    }
    
    orig.setDistance(0); //sets distance from origin to itself as 0
    
    
    for(int i = 0; i < n; i++){
      q.enqueue(locations[i]); //adds all vertices to the queue
      previous[i] = -2; //sets previous to default of -2
    }
    
    previous[getIndex(orig)] = -1; //sets previous of origin to -1
    
    //System.out.println("Queue: " + q); //testing
    
    while(!q.isEmpty()){
      Location temp = q.dequeue();
      
      //System.out.println("Temp: " + temp.getName()); //testing
      
      if(temp != dest){ //if temp isn't destination
        LinkedList<Location> babies = getSuccessors(temp); //get successors of temp
        
        //System.out.println(temp.getName() + "'s Successors: " + babies); //testing
        
        while(babies.peek() != null){ //while there are successors of temp
          Location baby = babies.remove();
          //check if we got here from the parent; ie we're traveling backwards
          if(previous[getIndex(temp)] != getIndex(baby)){
            
            double alt = temp.getDistance() + getDistanceBetween(temp, baby); //find the distance traveled to baby from origin
            
            //System.out.println("Distance from origin to " + baby + ": " + alt); //testing
            
            if(alt < baby.getDistance()){ //if this distance from origin is smaller than previous distance from origin
              baby.setDistance(alt); //set distance to new distance
              previous[getIndex(baby)] = getIndex(temp); //say which node we traveled from
              
              //System.out.println("baby index: " + getIndex(baby)); //testing
              //System.out.println("temp index: " + getIndex(temp)); //testing
            }
            if(!q.isEmpty())
              q.reorder(); //reorder queue after new distance changes
          }
        }
      }
    }
    return previous; //return array of previous indexes
  }
  
  /******************************************************************
   getDistanceBetween()
   
   If location a is a successor of location b(there is a direct path between the two), returns the distance between the two locations
   ******************************************************************/
  private double getDistanceBetween(Location a, Location b){
    //if b is a successor of a
    LinkedList successors = getSuccessors(a);
    if(!successors.contains(b))
      return NOT_FOUND;
    
    return paths[getIndex(a)][getIndex(b)].getDistance();
  }
  
  /******************************************************************
   directionsString()
   
   Returns a string representation of the directions from one location to another.
   Calls getDirections() to get the integer representaion, then retrieves the names of the locaions
   ******************************************************************/

  public String directionsString(Location orig, Location dest){
    boolean hasStairs = false;
    boolean hasHills = false;
    if(orig.equals(dest))
      return "You're already there! Check out the Explore panel to get more information.";
    int[] directions = getDirections(orig, dest);
    LinkedStack<String> names = new LinkedStack<String>();
    int temp = getIndex(dest);
    System.out.println("temp (outside loop): " + temp);
    while(temp!= -1){
      names.push(getVertex(temp).getName());//push the temp index into the list
      System.out.println("Pushed into List: " + getVertex(temp).getName());
      int previous = temp;
      temp = directions[temp];
      System.out.println("temp (inside loop): " + temp);
      if(previous != -1 && temp != -1){
      if(stairsExist(previous, temp))
        hasStairs = true;
      if(hillsExist(previous, temp))
        hasHills = true;
      //System.out.println("Checking path between temp and previous " + previous + getVertex(temp));
      }
    }
    String result = "Exit ";
    while(!names.isEmpty()){
      String tempLocation = names.pop();
      if(!tempLocation.equals(dest.getName()))
        result+= tempLocation + ". \nWalk towards: ";
      else
        result+= tempLocation + ". \nYou have arrived!";
    }
    
    if(hasStairs && hasHills)
      result += " \nThis path contains stairs and hills.";
    else if(hasHills)
      result += " \nThis path contains hills.";
    else if(hasStairs)
      result += " \nThis path contains stairs.";
    else
      result += " \nThis path does not contain stairs or hills.";
    return result;
  }
  
  
  ////////////////////UNSUPPORTED METHODS///////////////////////
  
  /******************************************************************
   saveTGF()
   
   Not used - only fulfills requirement in Graph interface
   ******************************************************************/
  public void saveTGF(String tgf_file_name){
    throw new UnsupportedOperationException();
  }
  
  
  //////////////////////////TOSTRING///////////////////////////////
  /******************************************************************
   toString()
   
  Returns a string representation of the graph
   ******************************************************************/
  public String toString() {
    if (n == 0) {
      return "Graph is empty";
    }
    
    String result = "";
    
    //result += "\nArcs\n";
    //result += "---------\n";
    result += "\ni ";
    
    for (int i = 0; i < n; i++) {
      result += "" + getVertex(i);
      if (i < 10) {
        result += " ";
      }
    }
    result += "\n";
    
    for (int i = 0; i < n; i++) {
      result += "" + getVertex(i) + " ";
      
      for (int j = 0; j < n; j++) {
        if (paths[i][j] != null) {
          result += "1 ";
        } else {
          result += "- "; //just empty space
        }
      }
      result += "\n";
    }
    
    return result;
  }
  
  /******************************************************************
   testing
   
   ******************************************************************/
  public static void main(String[] args){
    Map m = new Map();
    
    Location a = new Location("A");
    Location b = new Location("B");
    Location c = new Location("C");
    Location d = new Location("D");
    Location e = new Location("E");
    
    m.addVertex(a);
    m.addVertex(b);
    m.addVertex(c);
    m.addVertex(d);
    m.addVertex(e); 
    
    m.addEdge(a, b, new Path(3, true, true));
    m.addEdge(a, c, new Path(1, true, true));
    m.addEdge(b, d, new Path(1, true, true));
    m.addEdge(c, e, new Path(5, true, true));
    m.addEdge(d, e, new Path(1, true, true));
    
    int[] test = m.getDirections(a, e);
    for(int i = 0; i < test.length; i++){
      System.out.print(test[i] + "|");
    }
    
    System.out.println("\n" + m.directionsString(a, e));
    System.out.println("\n" + m.directionsString(a, b));
  }
  
}
