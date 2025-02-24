import java.lang.Comparable;

public class BST implements BSTInterface {
  private TreeNode root;

  public BST() {
    root = null;
  }

  public int size() {
    int size = 0;
    if (root != null) {
      size++;
      size += sizehelper(root.getLeft());
      size += sizehelper(root.getRight());
      return size;
    } else
      return 0;
  }

  private int sizehelper(TreeNode subroot) {
    int size = 0;
    if (subroot != null) {
      size++;
      size += sizehelper(subroot.getLeft());
      size += sizehelper(subroot.getRight());
      return size;
    } else
      return 0;
  }

  public boolean find(Comparable toFind) {
    if (root == null)
      return false;
    if (root.getValue().equals(toFind))
      return true;
    if (!findHelper(toFind, root.getLeft()) && !findHelper(toFind, root.getRight()))
      return false;
    else
      return true;
  }

  public boolean findHelper(Comparable toFind, TreeNode subroot) {
    if (subroot == null)
      return false;
    if (subroot.getValue().equals(toFind))
      return true;
    if (!findHelper(toFind, subroot.getLeft()) && !findHelper(toFind, subroot.getRight()))
      return false;
    else
      return true;
  }

  public boolean replace(Comparable old, Comparable toAdd) {
    if (find(old)) {
      delete(old);
      add(toAdd);
      return true;
    } else {
      return false;
    }
  }

  public boolean isEmpty() {
    if (root == null)
      return true;
    else
      return false;
  }

  public void add(Comparable newVal) {
    if (root == null)
      root = new TreeNode(newVal);
    else if (newVal.compareTo(root.getValue()) > 0)
      if (root.getRight() == null)
        root.setRight(new TreeNode(newVal));
      else
        addHelper(newVal, root.getRight());
    else if (root.getLeft() == null)
      root.setLeft(new TreeNode(newVal));
    else
      addHelper(newVal, root.getLeft());
  }

  private void addHelper(Comparable newVal, TreeNode subroot) {
    if (subroot != null)
      if (newVal.compareTo(subroot.getValue()) > 0)
        if (subroot.getRight() == null)
          subroot.setRight(new TreeNode(newVal));
        else
          addHelper(newVal, subroot.getRight());
      else if (subroot.getLeft() == null)
        subroot.setLeft(new TreeNode(newVal));
      else
        addHelper(newVal, subroot.getLeft());
  }

  public boolean delete(Comparable old) {
    if (root != null) {
      if (root.getValue().equals(old)) {
        if (root.getRight() == null) {
          root = root.getLeft();
          root.setLeft(null);
          root.setRight(null);
          return true;
        } else if (root.getLeft() == null) {
          System.out.print(root.getRight().getValue());
          root = root.getRight();
          root.setLeft(null);
          root.setRight(null);
          return true;
        } else {
          TreeNode temp = root.getLeft();
          while (temp.getRight() != null)
            temp = temp.getRight();
          temp.setRight(root.getRight());
          root = root.getLeft();
          return true;
        } // endif
      } else {
        if (root.getValue().compareTo(old) < 0)
          return deletehelper(root.getRight(), old, root);
        else
          return deletehelper(root.getLeft(), old, root);
      } // endif
    } else {
      return false;
    } // end if
  }// end delete

  private boolean deletehelper(TreeNode subroot, Comparable old, TreeNode parent) {
    if (subroot != null) {
      if (subroot.getValue().equals(old)) {
        if (subroot.getRight() == null) {
          if (parent.getLeft().equals(subroot))
            parent.setLeft(subroot.getLeft());
          else
            parent.setRight(subroot.getLeft());
          subroot.setLeft(null);
          subroot.setRight(null);
          return true;
        } else if (subroot.getLeft() == null) {
          if (parent.getLeft().equals(subroot))
            parent.setLeft(subroot.getRight());
          else
            parent.setRight(subroot.getRight());
          subroot.setLeft(null);
          subroot.setRight(null);
          return true;
        } else {
          TreeNode temp = subroot.getLeft();
          while (temp.getRight() != null)
            temp = temp.getRight();
          temp.setRight(subroot.getRight());
          subroot = subroot.getLeft();
          return true;
        } // end if

      } else {
        if (subroot.getValue().compareTo(old) < 0)
          return deletehelper(subroot.getRight(), old, subroot);
        else
          return deletehelper(subroot.getLeft(), old, subroot);
      } // end if
    } else {
      return false;
    } // end if
  }// end deletehelper

  public void printInOrder() {
    if (root != null) {
      printInOrderHelper(root.getLeft());
      System.out.println(root.getValue());
      printInOrderHelper(root.getRight());
    }
  }

  private void printInOrderHelper(TreeNode subroot) {
    if (subroot != null) {
      printInOrderHelper(subroot.getLeft());
      System.out.println(subroot.getValue());
      printInOrderHelper(subroot.getRight());
    }
  }

  public void printPreOrder() {
    if (root != null) {
      System.out.println(root.getValue());
      printPreOrderHelper(root.getLeft());
      printPreOrderHelper(root.getRight());
    }
  }

  private void printPreOrderHelper(TreeNode subroot) {
    if (subroot != null) {
      System.out.println(subroot.getValue());
      printPreOrderHelper(subroot.getLeft());
      printPreOrderHelper(subroot.getRight());
    }
  }

  public void printPostOrder() {
    if (root != null) {
      printPostOrderHelper(root.getLeft());
      printPostOrderHelper(root.getRight());
      System.out.println(root.getValue());
    }
  }

  private void printPostOrderHelper(TreeNode subroot) {
    if (subroot != null) {
      printPostOrderHelper(subroot.getLeft());
      printPostOrderHelper(subroot.getRight());
      System.out.println(subroot.getValue());
    }
  }
}