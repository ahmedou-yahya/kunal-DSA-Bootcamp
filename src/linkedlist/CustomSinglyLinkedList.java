package linkedlist;

public class CustomSinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;


    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail==null)
            tail=head;

        size++;
    }

    public int deleteFirst(){
        int value = head.value;
        if (tail==null){
            head=null;
        }
        head = head.next;
        size--;
        return value;
    }
    public int deleteByIndex(int index){

        if (index==0){
            return deleteFirst();

        }

        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        int value = current.next.value;
        current.next=current.next.next;

        return value;
    }


    public void display(){
        Node current = head;
        while(current!=null){
            System.out.print(current.value + "-->");
            current = current.next;
        }
        System.out.println("END");
    }

    public void insertLast(int value){
        if (tail==null)
            insertFirst(value);

        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertRec(int val, int index){
        head = insertRec(val,index,head);
    }
    private Node insertRec(int val, int index, Node node){
        if (index==0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index-1, node.next);
        return node;
    }

    public void insertByIndex(int value, int index){

        if (index==0){
            insertFirst(value);
            return;
        }

        if (index==size){
            insertLast(value);
            return;
        }

        Node node = new Node(value);
        Node current = head;

        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        node.next = current.next;
        current.next = node;
        size++;
        System.out.println("Index out of bounds");
    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

    }
}
