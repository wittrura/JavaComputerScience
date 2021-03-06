package main;

public class LinkedList {
	// reference to the head node.
	private Node head;
	private int listCount;

	// LinkedList constructor
	public LinkedList() {
		// this is an empty list
		listCount = 0;
	}

  // appends the specified element to the end of this list.
	public void add(int data) {
	    if (this.head == null) {
	        this.head = new Node(data);
        } else {
	        Node temp = this.head;
            while(temp.getNext() != null){
	            temp = temp.getNext();
            }
	        temp.setNext(new Node(data));
        }
        this.listCount++;
	}

  // inserts the specified element at the specified position in this list.
	public void add(int data, int index) {
        int i = 0;
        Node current = this.head;
        Node previous = null;
        while (i < index) {
            previous = current;
            current = current.getNext();
            i++;
        }

        Node newNode = new Node(data, current);
        previous.setNext(newNode);
        this.listCount++;
	}

  // returns the element at the specified position in this list.
	public int get(int index) {
	    if (index > this.listCount) {
	        return 0;
        }

        Node temp = this.head;
	    int data;
	    int i = 0;
        while (i < index) {
            temp = temp.getNext();
            i++;
        }
        return temp.getData();
	}

  // removes the element at the specified position in this list.
	public boolean remove(int index) {
        if (index > this.listCount) {
            return false;
        }

        int i = 0;
        Node current = this.head;
        Node previous = null;
        while (i < index) {
            previous = current;
            current = current.getNext();
            i++;
        }

        previous.setNext(current.getNext());
        this.listCount--;
        return true;
	}

  // returns the number of elements in this list.
	public int size() {
		return this.listCount;
	}

	public String toString() {
		Node current = head;
		String output = "";
		while(current != null) {
			output += "[" + String.valueOf(current.getData()) + "]";
			current = current.getNext();
		}
		return output;
	}

  // reference to the next node in the chain,
  // or null if there isn't one.
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
