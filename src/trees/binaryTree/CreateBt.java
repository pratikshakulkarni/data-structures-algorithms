package trees.binaryTree;

import java.util.Scanner;

/***
 @author: Pratiksha Kulkarni
 date: 3/1/2023
 */
public class CreateBt {
    static Scanner scan = null;

    public static void main(String[] args) {
        System.out.println("BT creation ");
        Node root = createTree();
    }

    public static Node createTree() {
        Node root = null;
        scan = new Scanner(System.in);
        System.out.println("Enter Data ");
        int data = scan.nextInt();

        if (data == -1)
            return null;

        root = new Node(data);

        System.out.println("Enter Data for left : " + data);
        root.left = createTree();

        System.out.println("Enter Data for right : " + data);
        root.right = createTree();

        return root;
    }


}
