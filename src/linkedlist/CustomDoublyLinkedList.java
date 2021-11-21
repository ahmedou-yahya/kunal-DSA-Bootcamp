package linkedlist;


public class CustomDoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next=head;

        if (head!=null)
            head.previous=node;
        head=node;
        if (tail==null)
            tail=head;

        size++;
    }

    public void insertLast(int value){
        Node node = new Node(value);
        tail.next = node;
        node.previous=tail;
        size++;
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
        Node current = head;
        Node node = new Node(value);
        for (int i = 1; i < index; i++) {
            current=current.next;
        }
        node.next = current.next;
        node.previous=current;
        current.next.previous=node;
        current.next=node;
        size++;
    }
    public void display(){
        Node current = head;
        while(current!=null){
            System.out.print(current.value + " <===> ");
            current=current.next;
        }
        System.out.println("END");
    }



    private class Node {
        int value;
        Node previous;
        Node next;

        Node(int value){
            this.value=value;
        }

    }
}
