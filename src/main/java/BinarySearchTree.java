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

  public void delete(int value) {
     this.delete(root, value);
  }

  private void delete(BSTNode node, int value) {
      if (node.left != null && node.left.value == value) {
          BSTNode nodeToDelete = node.left;

          // for leaves, delete with no promotion
          if (nodeToDelete.left == null && nodeToDelete.right == null) {
              node.left = null;
              return;
          }

          // for one child, promote that child
          if (this.hasOneChild(nodeToDelete)) {
              node.left = this.getLoneChild(nodeToDelete);
              return;
          }

          // for two child no descendants
          // find a minimum value in the right subtree
          BSTNode minimumValRightSubtree = this.getMinimumVal(nodeToDelete.right);
          BSTNode minimumValRightParent = this.getMinimumValParent(nodeToDelete.right);

          // replace value of the node to be removed with found minimum. Now, right subtree contains a duplicate!
          node.left = minimumValRightSubtree;

          minimumValRightSubtree.right = nodeToDelete.right;
          minimumValRightSubtree.left = nodeToDelete.left;

          minimumValRightParent.left = minimumValRightSubtree.right;

          return;

      } else if (node.right != null && node.right.value == value) {
          BSTNode nodeToDelete = node.right;

          // for leaves, delete with no promotion
          if (nodeToDelete.left == null && nodeToDelete.right == null) {
              node.right = null;
              return;
          }

          // for one child, promote that child
          if (this.hasOneChild(nodeToDelete)) {
              node.right = this.getLoneChild(nodeToDelete);
              return;
          }

          // for two child no descendants
          // find a minimum value in the right subtree
          BSTNode minimumValRightSubtree = this.getMinimumVal(nodeToDelete.right);
          BSTNode minimumValRightParent = this.getMinimumValParent(nodeToDelete.right);

          // replace value of the node to be removed with found minimum. Now, right subtree contains a duplicate!
          node.right = minimumValRightSubtree;

          minimumValRightParent.left = minimumValRightSubtree.right;

          minimumValRightSubtree.right = nodeToDelete.right;
          minimumValRightSubtree.left = nodeToDelete.left;

          return;

      } else if (value > node.value) {
          // search right
          if (node.right == null) {
              return;
          } else {
              this.delete(node.right, value);
          }
      } else {
          // search left
          if (node.left == null) {
              return;
          } else {
              this.delete(node.left, value);
          }
      }

      return;
  }

  public BSTNode getRoot() {
    return root;
  }

    private boolean hasOneChild(BSTNode node) {
        if (node.left != null && node.right == null) {
            return true;
        }
        if (node.left == null && node.right != null) {
            return true;
        }
        return false;
    }

    private BSTNode getLoneChild(BSTNode node) {
        if (node.left != null) {
            return node.left;
        } else {
            return node.right;
        }
    }

    private BSTNode getMinimumVal(BSTNode node) {
//        if no left children, return minimum val
        if (node.left == null) {
            return node;
        }
        return getMinimumVal(node.left);
    }

    private BSTNode getMinimumValParent(BSTNode node) {
        if (node.left.left == null) {
            return node;
        }
        return getMinimumVal(node.left);
    }
}
