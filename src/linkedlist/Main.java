package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        CustomSinglyLinkedList linkedList = new CustomSinglyLinkedList();
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        linkedList.display();
        linkedList.insertRec(5,2);
        linkedList.display();
//        linkedList.insertLast(4);
//        linkedList.display();
//        linkedList.insertByIndex(3,2);
//        linkedList.display();
//        System.out.println(linkedList.deleteFirst());
//        linkedList.display();
//        System.out.println(linkedList.deleteByIndex(1));
//        linkedList.display();

//        CustomDoublyLinkedList list = new CustomDoublyLinkedList();
//        list.display();
//        list.insertFirst(1);
//        list.display();
//        list.insertFirst(2);
//        list.insertFirst(3);
//        list.display();
//        list.insertByIndex(-1,2);
//        list.display();

//        CustomCircularLinkedList list = new CustomCircularLinkedList();
//        list.display();
//        list.insertFirst(3);
//        list.display();
//        list.insertLast(4);
//        list.display();
//        list.insertByIndex(1,1);
//        list.display();
    }
}
