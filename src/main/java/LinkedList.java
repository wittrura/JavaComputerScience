package main;

public class LinkedList {
	// reference to the head node.
	private Node head;
	private int listCount;

	// LinkedList constructor
	public LinkedList() {
		// this is an empty list, so the reference to the head node
		// is set to a new node with no data
		listCount = 0;
	}

  // appends the specified element to the end of this list.
	public void add(int data) {
		Node temp = new Node(data);
    if (head != null) {
      Node current = head;
  		// starting at the head node, crawl to the end of the list
  		while(current.getNext() != null) {
  			current = current.getNext();
  		}
  		// the last node's "next" reference set to our new node
  		current.setNext(temp);
    } else {
      head = temp;
    }
    listCount++;// increment the number of elements variable
	}

  // inserts the specified element at the specified position in this list.
	public void add(int data, int index) {
		Node temp = new Node(data);
		Node current = head;
		// crawl to the requested index or the last element in the list,
		// whichever comes first
		for(int i = 1; i < index && current.getNext() != null; i++) {
			current = current.getNext();
		}
		// set the new node's next-node reference to this node's next-node reference
		temp.setNext(current.getNext());
		// now set this node's next-node reference to the new node
		current.setNext(temp);
		listCount++;// increment the number of elements variable
	}

  // returns the element at the specified position in this list.
	public int get(int index) {
		// index must be 1 or higher
		if(index <= 0) {
			return 0;
    }
		Node current = head.getNext();
		for(int i = 1; i < index; i++) {
			if(current.getNext() == null) {
				return 0;
      }
			current = current.getNext();
		}
		return current.getData();
	}

  // removes the element at the specified position in this list.
	public boolean remove(int index) {
		// if the index is out of range, exit
		if(index < 1 || index > size())
			return false;

		Node current = head;
		for(int i = 1; i < index; i++) {
			if(current.getNext() == null) {
				return false;
      }
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--; // decrement the number of elements variable
		return true;
	}

  // returns the number of elements in this list.
	public int size() {
		return listCount;
	}

	public String toString() {
		Node current = head.getNext();
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
