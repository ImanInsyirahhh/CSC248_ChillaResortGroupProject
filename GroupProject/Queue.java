import java.util.Comparator;

public class Queue<T> extends LinkedList<T>
{
    public Queue()
    {
        super();
    }

    public void enqueue (T obj)
    {
         insertAtBack(obj);
    }

    public T dequeue()
    {
        return removeFromFront();
    }
    
    public boolean isEmpty()
    {
        return super.isEmpty();
    }
    
    //toString for header
    public String headerString()
    {
        return String.format("%-28s%-21s%-20s%-28s%-20s%-25s%-20s%-10s", 
                             "  NAME", "EMAIL", "PHONE NUMBER", "NUMBER OF CUSTOMER", "PACKAGE ID", 
                             "PACKAGE PRICE(RM)", "PACKAGE ADD-ON", "PAYMENT METHOD");
    }

}
