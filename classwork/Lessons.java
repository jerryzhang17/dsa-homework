import java.util.LinkedList;

public class Lessons{

    private LinkedList list;
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(1);
    }
}

class Node{

    Node value;
    Node next;

    public Node(Node value, Node next){
        this.value = value;
        this.next = next;
    }
}

class Linkedlist{
    Node head;
    
    public Linkedlist(Node head){
        this.head = null;
    }

    void addFirst(Node value){
        Node newNode = new Node(value, null);
        if(this.head == null){
            this.head = newNode;
        }
    }

    public void addLast(Node value){
        
        Node newNode = new Node(value, null);
        if(this.head == null){
            this.head = newNode;
        }

        Node current = this.head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    void removeHead(){
        if(this.head == null){
            return;
        }
    }

    public Node removeTail(){
        if(this.head == null){
            return null;
        }
        Node current = this.head;
        while(current.next.next != null){
            current = current.next;
        }
        Node removed = current;
        current.next = null;
        return removed;
    }

    void printList() {
        Node current = this.head;
        
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        
        System.out.println("null");
    }
}

class Playlist{
    
    public Playlist(){
        this.list = new LinkedList();
    }
}