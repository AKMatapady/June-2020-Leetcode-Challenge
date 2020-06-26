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
    
    public void recur(TreeNode root, int n)
    {
        n *= 10;
        n += root.val;
        if(root.left == null && root.right == null)
        {
            sum += n;
            return;
        }
        
        if(root.left != null)
            recur(root.left, n);
        if(root.right != null)
            recur(root.right, n);
    }
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
        {
            sum += root.val;
            return sum;
        }
        if(root.left != null)
            recur(root.left, root.val);
        if(root.right != null)
            recur(root.right, root.val);
        
        return sum;
    }
}