package trees.binaryTree;

import trees.Node;

import java.util.ArrayList;
import java.util.List;

/***
 @author: Pratiksha Kulkarni
 date: 2/28/2023
 */


public class LeftViewOfBT {
    private static void printLeftView(Node root, ArrayList<Node> list, int level) {
        if (root == null) return;

        if (level == list.size())
            list.add(root);
        printLeftView(root.left, list, level + 1);
        printLeftView(root.right, list, level + 1);

    }

    private static void printRightView(Node root, ArrayList<Node> list, int level) {
        if (root == null) return;

        if (level == list.size())
            list.add(root);
        printRightView(root.right, list, level + 1);
        printRightView(root.left, list, level + 1);

    }

    public static void main(String[] args) {
        Node root = CreateBt.createTree();
        ArrayList<Node> list = new ArrayList<>();

        System.out.println("\n Left view is : ");
        printLeftView(root, list, 0);
        list.forEach(l -> System.out.println(l.data));

        list.clear();

        System.out.println("\n Right view is : ");
        printRightView(root, list, 0);
        list.forEach(l -> System.out.println(l.data));
    }
}
