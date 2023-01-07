package trees.binaryTree;
import java.util.*;

class PreNode {
 int data;
 PreNode left, right;
 PreNode(int data) {
  this.data = data;
  left = null;
  right = null;
 }
 PreNode() {

 }
}

public class PreOrderTraversal {
 static void preOrderTrav(PreNode curr, ArrayList < Integer > preOrder) {
  if (curr == null)
   return;

  preOrder.add(curr.data);
  preOrderTrav(curr.left, preOrder);
  preOrderTrav(curr.right, preOrder);
 }

 public static void main(String args[]) {

  PreNode root = new PreNode(1);
  root.left = new PreNode(2);
  root.right = new PreNode(3);
  root.left.left = new PreNode(4);
  root.left.right = new PreNode(5);
  root.left.right.left = new PreNode(8);
  root.right.left = new PreNode(6);
  root.right.right = new PreNode(7);
  root.right.right.left = new PreNode(9);
  root.right.right.right = new PreNode(10);

  ArrayList < Integer > preOrder = new ArrayList < > ();
  preOrderTrav(root, preOrder);

  System.out.print("The preOrder Traversal is : ");
  for (int i = 0; i < preOrder.size(); i++) {
   System.out.print(preOrder.get(i) + " ");
  }
 }
}