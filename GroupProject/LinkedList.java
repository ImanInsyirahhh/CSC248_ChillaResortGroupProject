public class LinkedList<T>
{
   private Node<T> head, tail, current; 
   
   private static class Node<T> 
   {
       T data;
       Node<T> next;

       Node(T data) 
       {
           this.data = data;
           this.next = null;
       }
   }
   
   //Default LinkedList Class 
   public LinkedList()
   {
       head = tail = current = null;
   }
   
   //To check whether is the LinkedList empty
    public boolean isEmpty()
   {
       return head == null;
   }
   
   //toString for header
    public String headerString()
    {
        return String.format("%-28s%-21s%-20s%-28s%-20s%-25s%-20s%-10s", "  NAME", "EMAIL", "PHONE NUMBER", "NUMBER OF CUSTOMER", "PACKAGE ID", "PACKAGE PRICE(RM)", "PACKAGE ADD-ON", "PAYMENT METHOD");
    }

   //To add new object data at the back of the LinkedList
   public void insertAtBack(T data)
   {
       if(isEmpty())
           head = tail = new Node(data);
       else
           tail = tail.next = new Node(data);
   }
   
   //Return the first element in the linked list
   public T getFirst()
   {
       current = head;
       return current.data;
   }
   
   //To remove the first element in the LinkedList
    public T removeFromFront()
   {
       if (isEmpty()) {
            return null; 
       }
       T data = head.data;
       if (head == tail) {
            head = tail = null;
       } else {
            head = head.next;
       }
       return data;
   }
   
   //Get the size of linkedlist
   public int size()
   {
       int count=0;
       current = head;
       while (current != null)
       {
           count++;
           current = current.next;
       }
       return count;
   }
   
   // Add a node at a specific index
   public void add(int index, T data) 
   {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        Node<T> newNode = new Node<>(data);
        
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node<T> current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        newNode.next = current.next;
        current.next = newNode;
   }
    
   // Get the data at a specific index
   public T get(int index) 
   {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            current = current.next;
            count++;
        }

        throw new IndexOutOfBoundsException("Index out of bounds");
   }
}
