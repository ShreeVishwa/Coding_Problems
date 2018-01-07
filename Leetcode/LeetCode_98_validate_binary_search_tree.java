class Solution {
    
    public boolean isValidBSTUtil(TreeNode root, long maxint, long minint){
        if(root == null) return true;
        else if(root.val >= maxint || root.val <= minint) return false;
        else return isValidBSTUtil(root.left,root.val,minint) && isValidBSTUtil(root.right,maxint,root.val);
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        return isValidBSTUtil(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
}