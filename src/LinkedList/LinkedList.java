package LinkedList;

// 1. Keep this named LinkedList
class LinkedList {
    Node head;

    void insertAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    void insertAtAny(int data),int pos{
        Node node=new Node(int data);
        if(head==null){
            head=node;
            return;
        }
        Node temp=head;
        for(int i=0;i<pos-1;i++){
            temp=temp.next;
        }
        node.next=temp;
        temp.next=node;
        
    }

    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// 2. Rename this public class so it doesn't conflict
class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.insertAtBeginning(5);

        list.display(); // Output will be: 5 -> 10 -> 20 -> 30 -> null
    }
}