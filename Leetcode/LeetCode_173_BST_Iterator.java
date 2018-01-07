public class BSTIterator {
    
    Stack<TreeNode> st = null;
    TreeNode curr = null;

    public BSTIterator(TreeNode root) {
        curr = root;
        st = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!st.isEmpty() ||  curr!=null);
    }

    /** @return the next smallest number */
    public int next() {
        while(curr!=null){
            st.push(curr);
            curr = curr.left;
        }
        TreeNode t = st.pop();
        curr = t.right;
        return t.val;
    }
}
