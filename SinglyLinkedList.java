public class SinglyLinkedList<T extends Comparable<T>> {

   // inner class - node, will store data and next node
   private class Node {
      // fields of Node
      private T data;
      private Node next;

      // constructor, will initialize the fields of a Node obj
      public Node(T data) {
         this.data = data;
         next = null;
      }
   }

   // fields of SinglyLinkedList
   private int size; // will contain the # of elements in the SinglyLinkedList
   private Node head; // will contain the first element
   private Node tail; // will contain the last element

   // constructor of a SinglyLinkedList, will initialize the fields of an obj
   public SinglyLinkedList() {
      size = 0;
      head = null;
      tail = null;
   }

   // adds an element to the end of the linked list
   // returns true if the operation was successful, false otherwise
   public boolean add(T element) {
      boolean res = false;

      if (element != null) {
         Node newElement = new Node(element);

         if (head == null) {
            // list is empty
            head = newElement;
            tail = head;
         } else {
            // general case
            tail.next = newElement;
            tail = newElement;
         }

         size++;
         res = true;
      }

      return res;
   }

   // adds an element to the linked list at the index specified
   // returns true if the operation was successful, false otherwise
   public boolean add(int indx, T element) {
      boolean res = false;
      if (indx >= 0 && indx <= size && element != null) {
         Node newElement = new Node(element);

         if (indx == 0) {
            // they want to make the element the new head
            newElement.next = head;
            head = newElement;
            
            if (tail == null) {
               tail = head;
            }
         } else if (indx == size) {
            // they want to add the element at the end of the list
            tail.next = newElement;
            tail = newElement;
         } else {
            // general case
            Node curr = head;
            Node prev = null;
            while (indx > 0 && curr != null) {
               prev = curr;
               curr = curr.next;
               indx--;
            }
            prev.next = newElement;
            newElement.next = curr;
         }

         size++;
         res = true;
      }

      return res;
   }

   // retrieves the data of the node at index specified
   // returns null if the index is invalid
   public T get(int indx) {
      T res = null;
      if (indx >= 0 && indx < size) {
         Node curr = head;

         while (indx > 0) {
            curr = curr.next;
            indx--;
         }

         res = curr.data;
      }

      return res;
   }

   // replaces the data (element) of a node at the index specified.
   // returns false if the index isn't valid, or element is null
   public boolean set(int indx, T element) {
      boolean res = false;
      if (indx >= 0 && indx < size && element != null) {
         Node curr = head;
         while (indx > 0) {
            curr = curr.next;
            indx--;
         }

         curr.data = element;
         res = true;
      }

      return res;
   }
   
   // removes the element at the specific index
   // returns false if invalid index
   public boolean remove(int indx) {
      boolean res = false;
      if (indx >= 0 && indx < size) {
         Node prev = null;
         Node curr = head;
         
         while (indx > 0) {
            prev = curr;
            curr = curr.next;
            indx --;
         }
         
         if (curr == head) {
            head = head.next;
         } else {
            if (tail == curr) {
               tail = prev;
            }
            prev.next = curr.next;
         }
         
         size --;
         res = true;
      }
      
      return res;
   }
   
   // returns a boolean on whether the linkedList is empty or not
   public boolean isEmpty() {
      return size == 0;
   }
   
   // clears the whole linked list
   public void clear() {
      head = null;
      size = 0;
   }
   
   // returns  whether the linkedList contains an element
   public boolean contains(T element) {
      boolean res = false;
      if (element != null) {
         Node curr = head;
         
         while (curr != null) {
            if (curr.data.compareTo(element) == 0) {
               res = true;
               break;
            }
            curr = curr.next;
         }
      }
      
      return res;
   }
   
   // returns the index of an element in the linked list
   public int indexOf(T element) {
      int res = -1;
      if (element != null) {
         Node curr = head;
         int indx = 0;
         
         while (curr != null) {
            if (curr.data.compareTo(element) == 0) {
               return indx;
            }
            indx += 1;
            curr = curr.next;
         }
      }
      
      return res;
   }
   
   // returns the string representation of the linked list
   public String toString() {
      String res = "";
      Node curr = head;
      
      while (curr != null) {
         if (!res.isEmpty()) {
            res += " ";
         }
         res += curr.data;
         curr = curr.next;
      }
      
      return res;
   }

   // returns the size of the current LinkedList obj
   public int size() {
      return size;
   }
}
