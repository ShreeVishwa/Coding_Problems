class Solution {
    public boolean isSymmetric(TreeNode root) {
        return ismirror(root,root);
    }
    
    public boolean ismirror(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1!=null && root2!=null && (root1.val == root2.val)) return (ismirror(root1.left,root2.right) && ismirror(root1.right,root2.left));
        return false;
    }
}