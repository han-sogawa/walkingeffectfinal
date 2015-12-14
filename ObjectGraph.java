/*************************************************************************************
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Author of this Class: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * 
 * File Name: ObjectGraph.java
 * Created: 12/8/15
 * Last Updated: 12/14/15
 * Known Bugs: None
 * 
 * Interface for a graph that uses objects to represent arcs between the nodes. 
 * Very similar to AdjMatGraph.
 *************************************************************************************/ 

import java.util.*;

public interface ObjectGraph<T, M>{
  
  /******************************************************************
    addVertex()
    
    Adds a given object of type T to the Graph as a vertex
    ******************************************************************/
  public void addVertex (T vertex); 
  
  
  /******************************************************************
    containsVertex()
    
    returns true if the map contains the passed vertex.
    ******************************************************************/
  public boolean containsVertex(T vertex);
  
  /******************************************************************
    removeVertex()
    
    removes the passed vertex from the graph by getting the index of the vertex 
    does nothing if vertex is not in map
    ******************************************************************/
  public void removeVertex (T vertex);
  
  /******************************************************************
    addArc()
    
    Inserts an arc from srcVertex to destVertex.
    If the vertices exist, else does not change the graph. 
    ******************************************************************/
  public void addArc(T srcVertex, T destVertex, M arc);
  
  /******************************************************************
    addEdge()
    
    Inserts an edge between two vertices of the graph.
    If one or both vertices do not exist, ignores the addition.
    Adds the same M to both arcs placements in the adjacency matrix
    ******************************************************************/
  public void addEdge(T vertex1, T vertex2, M edge);
 
    /******************************************************************
    isArc()
    
    returns true if an arc exists between the two passed vertices
    ******************************************************************/
   public boolean isArc(T srcVertex, T destVertex);

  /******************************************************************
    isEdge()
    
    returns true if an edge exists between the two passed vertices (both ways)
    ******************************************************************/
  public boolean isEdge(T srcVertex, T destVertex);
  
  /******************************************************************
    getArc()
    
    returns the M object between the specified vertices
    ******************************************************************/
  public M getArc(T src, T dest);
  
  /******************************************************************
    removeEdge() 
    
    Removes an edge (both arcs) from vertex src to vertex dest,
    if the vertices do not exist does not change the graph. 
    ******************************************************************/
  public void removeEdge(T vertex1, T vertex2);
  
  /******************************************************************
    removeArc() 
    
    Removes an arc from vertex src to vertex dest,
    if the vertices do not exist does not change the graph. 
    ******************************************************************/
  public void removeArc(T srcVertex, T destVertex);
  
  /*****************************************************************
    isEmpty()
    
    returns true if the graph is empty (has no locations)
    ***************************************************************/
  public boolean isEmpty();
  
  /******************************************************************
    n()
    
    Returns the number of vertices in the graph.
    ******************************************************************/
  public int n();
  
  /******************************************************************
    m()
    
    Returns the number of arcs in the graph.
    ******************************************************************/
  public int m();
  
  /******************************************************************
    getPredecessors()
    
    Retrieve from a graph the vertices x pointing to vertex v (x->v)
    and returns them onto a linked list. Returns emptylist if there are no predecessors
    ******************************************************************/
  public LinkedList<T> getPredecessors(T loc);
  
  /******************************************************************
    getSuccessors()
    
    Retrieve from a graph the vertices x following vertex v (v->x)
    and returns them onto a linked list. Returns empty list if there are no successors
    ******************************************************************/
  public LinkedList<T> getSuccessors(T loc);
    
  /******************************************************************
   toString()
   
  Returns a string representation of the graph
   ******************************************************************/
  public String toString();
}