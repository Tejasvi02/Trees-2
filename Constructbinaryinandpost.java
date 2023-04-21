// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length ==0 || inorder.length ==0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        System.out.println(root.val);
        int rootidx=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]== root.val){
                rootidx= i;
                break; //optimisation to exit, since the value would never repeat, we can exit from the loop
            }
        }

        int[] inorderleft = Arrays.copyOfRange(inorder,0,rootidx);
        int[] inorderright = Arrays.copyOfRange(inorder,rootidx+1,inorder.length);

        int[] postorderleft = Arrays.copyOfRange(postorder,0,rootidx);
        int[] postorderright = Arrays.copyOfRange(postorder,rootidx,postorder.length-1);

        root.left= buildTree(inorderleft,postorderleft);
        root.right= buildTree(inorderright,postorderright);

        return root;
    }
}