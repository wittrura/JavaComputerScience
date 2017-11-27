package main;

public class BinarySearchTree {
    private BSTNode root;

    BinarySearchTree() {}

    BinarySearchTree(int rootValue) {
        root = new BSTNode(rootValue);
    }

    public void insert(int value) {
        if (this.root == null) {
            root = new BSTNode(value);
        } else {
            insert(root, value);
        }
    }

  private void insert(BSTNode node, int value) {
    if (value > node.value) {
        // try to insert at right
        if (node.right == null) {
            node.right = new BSTNode(value);
            return;
        } else {
            // or if filled, try to insert to that right child
            this.insert(node.right, value);
        }
    } else {
        // try to insert at left
        if (node.left == null) {
            node.left = new BSTNode(value);
            return;
        } else {
            // if filled, try to insert to the left child
            this.insert(node.left, value);
        }
    }
  }

  public boolean search(int value) {
    return search(root, value);
  }

  private boolean search(BSTNode node, int value) {
    if (node.value == value) {
        return true;
    } else if (value > node.value) {
        // search right
        if (node.right == null) {
            return false;
        } else {
            return this.search(node.right, value);
        }
    } else {
        // search left
        if (node.left == null) {
            return false;
        } else {
            return this.search(node.left, value);
        }
    }
  }

  public void delete(int value)
  {
     root = delete(root, value);
  }

  private BSTNode delete(BSTNode node, int value)
  {
    //TODO
     return node;
  }

  public BSTNode getRoot() {
    return root;
  }
}
