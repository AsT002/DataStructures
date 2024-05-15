public class Stack<T> {

   // inner class - node, will store data and next node
   private class Node {
      // fields of Node
      private T data;
      private Node next;
      private Node prev;

      // constructor, will initialize the fields of a Node obj
      public Node(T data) {
         this.data = data;
         next = null;
         prev = null;
      }
   }

   private Node bottom;
   private Node top;
   private int size;
   // similar to the linked list implementation

   public Stack() {
      bottom = null;
      top = null;
      size = 0;
   }

   // adds an element to the top of the stack
   // returns true if the element was successfully added
   // otherwise, returns false.
   public boolean push(T element) {
      boolean res = false;
      if (element != null) {
         Node newElem = new Node(element);
         if (bottom == null) {
            // case where stack is empty
            bottom = newElem;
            top = newElem;
         } else {
            // general case
            top.next = newElem;
            newElem.prev = top;
            top = newElem;
         }
         size ++;
         res = true;
      }

      return res;
   }
   
   // removes the element at the top of the stack
   // returns null if the stack is empty
   // otherwise, returns the "popped" element
   public T pop() {
      T res = null;
      if (top != null) {
         res = top.data;
         if (size == 1) {
            // means there is only 1 element in the stacl
            bottom = top = null;
         } else {
            // general case
            top = top.prev;
            top.next = null;
         }
         
         size --;
      }
      
      return res;
   }
   
   // returns the size of the stack
   public int size() {
      return size;
   }
   
   // returns a boolean on whether the stack is empty or not
   public boolean isEmpty() {
      return size == 0;
   }
   
   // clears the stack of all elements
   public void clear() {
      top = null;
      bottom = null; 
      size = 0;
   }
   
   // returns the element at the top of the stack without removing it
   // can return null if the stack is empty
   public T peek() {
      T res = null;
      if (top != null) {
         res = top.data; 
      }
      
      return res;
   }
}
