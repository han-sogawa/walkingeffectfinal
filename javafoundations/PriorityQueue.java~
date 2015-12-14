// ***************************************************************
//   PriorityQueue.java         Java Foundations
//
//   A data structure that works like a queue, but instead of 
//   FIFO, always dequeues the item with the highest priority.
//   Uses a maxheap to store and sort items.
// ***************************************************************
package javafoundations;
import javafoundations.exceptions.*;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T>
{
 private LinkedMaxHeap<T> heap;
 
 public PriorityQueue()
 {
  heap = new LinkedMaxHeap<T>();
 }
 public void enqueue(T element)
 {
  heap.add(element);
 }
 
 public T dequeue()
 {
  try
  {
   T temp = heap.removeMax();
   return temp;
  }
  catch(EmptyCollectionException ece)
  {
   System.out.println(ece);
  }
  return null;
 }
 
 public T first()
 {
  return heap.getMax();
 }
 
 public boolean isEmpty()
 {
  return heap.isEmpty();
 }
 
 public int size()
 {
  return heap.size();
 }
 
 public String toString()
 {
  return heap.toString();
 }
}
