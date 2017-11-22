package main;

import java.util.EmptyStackException;

public class Stack {
    // reference to the head node.
    private Node head;
    private Node tail;

    public void push(int value) {
        if (this.head == null) {
            this.head = new Node(value);
        }
        if (this.tail == null) {
            this.tail = this.head;
        } else {
            Node newNode = new Node(value);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public int pop() {
        int popValue = this.tail.getData();

        Node temp = this.head;
        Node curr = this.head;
        while (temp.getNext() != null) {
            curr = temp;
            temp = temp.getNext();
        }
        if (temp == curr) {
            this.head = null;
        } else {
            curr.setNext(null);
            this.tail = curr;
        }

        return temp.getData();
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.tail.getData();
    }

    public boolean isEmpty() {
        return this.head == null;
    }


    private class Node {
        Node next;
        // data carried by this node (currently int, could be any other type).
        int data;
        // Node constructor
        public Node(int _data) {
            next = null;
            data = _data;
        }
        // another Node constructor if we want to
        // specify the node to point to.
        public Node(int _data, Node _next) {
            next = _next;
            data = _data;
        }
        // these methods should be self-explanatory
        public int getData() {
            return data;
        }
        public void setData(int _data) {
            data = _data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node _next) {
            next = _next;
        }
    }
}
