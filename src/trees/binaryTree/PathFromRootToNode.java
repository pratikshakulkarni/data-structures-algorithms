package trees.binaryTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

/***
 @author: Pratiksha Kulkarni
 date: 2/28/2023
 */

class TempNode {
    int val;
 TempNode left;
 TempNode right;
 TempNode(int x) {
     val = x;
     left=null;
     right=null;
    }
}
public class PathFromRootToNode {
 public ArrayList<Integer> solve(TempNode A, int B) {
  ArrayList<Integer> res = new ArrayList<>();
  findPath(A,B,res);
  return res;
 }

 public static boolean findPath(TempNode node, int B, ArrayList<Integer> res){
  if(node == null)
   return false;

  res.add(node.val);
  if(node.val == B)
   return true;

  if(findPath(node.left,B,res) || findPath(node.right,B,res))
   return true;

  res.remove(res.size()-1);
  return false;
 }
}
