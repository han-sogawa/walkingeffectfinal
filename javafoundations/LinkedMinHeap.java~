//*******************************************************************
//  LinkedMaxHeap.java        Java Foundations
//
//  Implements a max heap using a linked representation.
//*******************************************************************

package javafoundations;

import javafoundations.exceptions.*;

public class LinkedMinHeap<T extends Comparable<T>>
  extends LinkedBinaryTree<T> implements MinHeap<T>
{
  
  private MinHeapNode<T> last;
  
  //-----------------------------------------------------------------
  //  Creates a max heap with the specified element as its root.
  //-----------------------------------------------------------------
  public LinkedMinHeap ()
  {
    super();
    last = null;
  }
  
  //-----------------------------------------------------------------
  //  Creates a max heap with the specified element as its root.
  //-----------------------------------------------------------------
  public LinkedMinHeap (T element)
  {
    root = new MinHeapNode<T>(element);
    last = (MinHeapNode<T>)root;
  }
  
  //-----------------------------------------------------------------
  //  Adds the specified element to this heap by adding it as a leaf
  //  then reestablishing the heap relationships.
  //-----------------------------------------------------------------
  public void add (T element)
  {
    MinHeapNode<T> node = new MinHeapNode<T>(element);
    MinHeapNode<T> newParent = null;
    
    if (root == null)
      root = node;
    else
    {
      newParent = ((MinHeapNode<T>)root).getParentAdd(last);
      
      if (newParent.left == null)
        newParent.setLeft(node);
      else
        newParent.setRight(node);
    }
    
    node.setParent(newParent);
    last = node;
    
    ((MinHeapNode<T>)root).heapifyAdd(last);
  }
  
  //-----------------------------------------------------------------
  //  Remove the element with the largest value in this heap and
  //  returns a reference to it.
  //-----------------------------------------------------------------
  public T removeMin()
  {
    if (root == null)
      throw new EmptyCollectionException ("Remove min operation " +
                                          "failed. Tree is empty.");
    
    T minElement = root.getElement();
    
    if (root.count() == 1)
      root = last = null;
    else
    {
      MinHeapNode<T> newLast = ((MinHeapNode<T>)root).getNewLastNode(last);
      if (last.parent.left == last)
        last.parent.left = null;
      else
        last.parent.right = null;
      
      root.setElement(last.getElement());
      last = newLast;
      ((MinHeapNode<T>)root).heapifyRemove((MinHeapNode<T>)root);
    }
    
    return minElement;
  }
  
  @Override
  public T getMin() {
    // TODO Auto-generated method stub
    return getRootElement();
  }
  
  //-----------------------------------------------------------------
  //  The following method is left as a programming project.
  //-----------------------------------------------------------------
  // public T getMax() { }
  
}
