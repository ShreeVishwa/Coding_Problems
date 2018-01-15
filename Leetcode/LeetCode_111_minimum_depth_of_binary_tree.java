class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int lh = minDepth(root.left);
        int rh = minDepth(root.right);
        if(lh!=0 && rh!=0) return lh>rh?rh+1:lh+1;
        if(lh!=0) return lh+1;
        return rh+1;
    }
}