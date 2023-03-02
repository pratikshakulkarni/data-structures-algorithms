package trees.binaryTree;

import trees.Node;

/***
 @author: Pratiksha Kulkarni
 date: 3/2/2023
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        Node root = CreateBt.createTree();
        System.out.println("Tree is : " + checkIfTreeIsBalanced(root));
    }

    private static boolean checkIfTreeIsBalanced(Node root) {
        return checkHeightOfBt(root) != -1;
    }

    private static int checkHeightOfBt(Node root) {
        if (root == null) return 0;

        int lh = checkHeightOfBt(root.left);
        int rh = checkHeightOfBt(root.right);

        if ((lh == -1 || rh == -1) || (Math.abs(lh - rh) > 1)) return -1;
        else return Math.max(lh, rh) + 1;
    }
}
