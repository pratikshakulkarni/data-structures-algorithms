package trees.binaryTree;

import java.util.ArrayList;
import java.util.List;

/***
 @author: Pratiksha Kulkarni
 date: 2/28/2023
 */
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class LeftViewOfBT {
    void reversePreOder(Node root, int level, List<Integer> result){
        if(root ==null)
            return;
        if(level == result.size()){
            result.add(root.data);
        }
        reversePreOder(root.left,level+1,result);
        reversePreOder(root.right,level+1,result);
    }
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        reversePreOder(root,0,result);
        return result;
    }

    public static void main(String[] args) {
        //create a tree here
    }
}
