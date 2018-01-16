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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> ans = new ArrayList<Integer>();
            while(!s1.isEmpty()){
                TreeNode temp = s1.pop();
                if(temp.left != null) s2.push(temp.left);
                if(temp.right != null) s2.push(temp.right);
                ans.add(temp.val);
            }
            if(ans.size() > 0) res.add(ans);
            ans = new ArrayList<Integer>();
            while(!s2.isEmpty()){
                TreeNode temp = s2.pop();
                if(temp.right != null) s1.push(temp.right);
                if(temp.left != null) s1.push(temp.left);
                ans.add(temp.val);
            }
            if(ans.size() > 0) res.add(ans);
        }
        return res;
    }
}