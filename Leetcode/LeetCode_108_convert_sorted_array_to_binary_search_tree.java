/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return sortedUtil(nums,0,nums.length-1);
    }
    
    public TreeNode sortedUtil(int[] nums, int l, int h){
        if(l>h){
            return null;
        }
        int mid = (l+h)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedUtil(nums,l,mid-1);
        root.right = sortedUtil(nums,mid+1,h);
        return root;
    }
}