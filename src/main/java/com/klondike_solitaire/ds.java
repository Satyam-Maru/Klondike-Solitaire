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
    Node t;

    void addLast(int data) {
        Node n = new Node(data);
        if (first == null) {
            first = n;
            t = first;
        } else {
            Node temp = first;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            n.prev = temp;
        }
    }

    void forward() {
        if (first == null) {
            System.out.printf("LL Empty");
        } else {

            if (t.next != null) {
                t = t.next;

            }
        }
        System.out.println(t.data);
    }

    void backward() {
        if (first == null) {
            System.out.printf("LL Empty");
        } else {
            if (t.prev != null) {
                t = t.prev;

            }
        }
        System.out.println(t.data);
    }

    void x() {
        while (t != null) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        ds d = new ds();
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);
        d.addLast(4);

        System.out.println(d.t.data);
        d.forward();
        d.backward();

    }
}
