// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

 //Definition for a binary tree node.
public class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
    TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
        this.left = left;
       this.right = right;
    }
  }

 //using recursion
 class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
     public int sum(TreeNode n, int s) {
         if(n==null) return 0;
         if(n.right==null && n.left ==null){
             return s*10+n.val;
         }
        return sum(n.right,s*10+n.val)+sum(n.left,s*10+n.val);
    }
}