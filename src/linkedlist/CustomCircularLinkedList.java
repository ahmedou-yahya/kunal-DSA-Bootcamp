package linkedlist;

public class CustomCircularLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int value){
        Node node = new Node(value);
        if (head==null){
            head = node;
            tail = node;
        }
        node.next=head;
        head = node;
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
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        Node node = new Node(value);
        node.next = current.next;
        current.next=node;
        size++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if (head==null){
            head=node;
            tail=node;
        }
        tail.next=node;
        tail=node;
        size++;
    }

    public void display(){
        Node current = head;
        while (current!=null){
            System.out.print(current.value + " ---> ");
            if (current.value== tail.value)
                break;
            current = current.next;
        }
        System.out.println("END");
    }

    private class Node{
        int value;
        Node next;

        Node(int value){
            this.value=value;
        }
    }
}
