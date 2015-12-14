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
 private LinkedMinHeap<T> heap;
 
 public PriorityQueue()
 {
  heap = new LinkedMinHeap<T>();
 }
 public void enqueue(T element)
 {
  heap.add(element);
 }
 
 public T dequeue()
 {
  try
  {
   T temp = heap.removeMin();
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
  return heap.getMin();
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
 
  public void reorder(){
    if (heap.getMin() == null)
      throw new EmptyCollectionException ("Reorder operation " +
                                          "failed. Tree is empty.");
    
    T holdRoot = null;
    LinkedMinHeap<T> temp = new LinkedMinHeap<T>();
    while(!heap.isEmpty()){
      temp.add(heap.removeMin());
    }
    heap = temp;
    /*
    
    do{
      if(holdRoot != null){
      holdRoot = heap.getMin();
      temp.add(holdRoot);
      heap.removeMin();
      }
    }while(holdRoot != null);
    heap = temp;*/

  }
 
 public static void main(String[] args){
   PriorityQueue pq = new PriorityQueue();
   pq.enqueue(5);
   pq.enqueue(5);
   pq.enqueue(6);
   pq.enqueue(4);
   pq.enqueue(1);
   pq.enqueue(8);
   pq.enqueue(3);
   pq.dequeue();
   System.out.println(pq);
 }
}
