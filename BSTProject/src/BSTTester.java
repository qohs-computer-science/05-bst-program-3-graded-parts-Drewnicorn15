/*
 * Drew Dietrich
 * 2/24
 * 3
 * binary search tree progams
 */

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

public class BSTTester {
  public static void main(String[] args) {

    System.out.println("Hello world!");
    BST best = new BST();
    System.out.println("is empty: " + best.isEmpty());
    best.add("O");
    best.add("R");
    best.add("C");
    best.add("H");
    best.add("A");
    best.add("R");
    best.add("D");
    best.add("Q");
    best.add("U");
    best.add("I");
    best.add("N");
    best.add("C");
    best.add("E");
    System.out.println("is empty: " + best.isEmpty());
    System.out.print("in order traversal: ");
    best.printInOrder();
    System.out.println("find \"A\": " + best.find("A"));
    System.out.println("replace \"Q\" with \"L\": "+ best.replace("Q", "L"));
    System.out.print("post order traversal: ");
    best.printPostOrder();
    System.out.println("delete \"A\": " + best.delete("A"));
    System.out.print("pre order traversal: ");
    best.printPreOrder();
  }

  // @Test
  // void addition() {
  // assertEquals(2, 1 + 1);
  // }
}