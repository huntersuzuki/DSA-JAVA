package com.collectionFramework.Linked_List;

class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class ManualLinkedList {
    public static void main(String[] args) {
        Node head = new Node(20);
        Node second = new Node(222);
        Node third = new Node(898);

        // Linking the nodes to each other
        head.next = second;
        second.next = third;
        // Now head is the start of your list: 20 -> 222 -> 898 -> null
    }
}
