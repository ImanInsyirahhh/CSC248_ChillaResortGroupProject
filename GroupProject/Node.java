public class Node
{
    Object data; // Holds the data
    Node next;   // Points to the next node in the list

    // Constructor to initialize a node
    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    // Optionally, override the toString method for better debugging
    @Override
    public String toString() {
        return data.toString();
    }
    
}