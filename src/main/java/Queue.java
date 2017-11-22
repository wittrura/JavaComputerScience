package main;

import java.util.EmptyStackException;

public class Queue {
    // reference to the head node.
    private Node head;
    private Node tail;

  public boolean isEmpty() {
      if (this.head == null) {
          return true;
      } else {
          return false;
      }
  }

  public void enqueue(int value) {
      if (this.head == null) {
          this.head = new Node(value);
      } else {
          Node temp = this.head;
          while(temp.getNext() != null){
              temp = temp.getNext();
          }
          temp.setNext(new Node(value));
      }
  }

  public int getFront() {
      if (this.isEmpty()) {
          throw new EmptyStackException();
      }
      return this.head.getData();
  }

  public int dequeue() {
      if (this.isEmpty()) {
          throw new EmptyStackException();
      }
      Node dequeue = this.head;
      this.head = this.head.getNext();
      dequeue.setNext(null);
      return dequeue.getData();
  }

  public void clear() {
      this.head = null;
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
