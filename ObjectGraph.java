/*ObjectGraph.java
 * Authors: Mary Dubard, Hannah Murphy, Alyssa Rivera 
 * Primary Author: hannah Murph 
 * Interface for a graph that uses objects to represent arcs between the nodes. Very similar to AdjMatGraph.
 */ 


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
    
    returns the M object between the specified locations
    ******************************************************************/
  public Path getArc(int src, int dest);
    
}