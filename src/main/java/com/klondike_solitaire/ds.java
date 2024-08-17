package com.klondike_solitaire;

class ds {
    class Node {
        Node next;
        Node prev;
        int data;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }

    }

    Node first = null;

    void addLast(int data) {
        if (first == null) {
            System.out.printf("LL Empty");
        } else {
            Node n = new Node(data);
            Node temp = first;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            n.prev = temp;
        }
    }

    void forward() {
        Node temp=first;
        if (first == null) {
            System.out.printf("LL Empty");
        }
        else {

            if(temp.next!=null){
                temp=temp.next;
                forward();
            }
        }
    }

    void backward() {
        Node temp=first;
        if (first == null) {
            System.out.printf("LL Empty");
        }
        else {

            if(temp.prev!=null){
                temp=temp.prev;
                backward();
            }
        }
    }
}
