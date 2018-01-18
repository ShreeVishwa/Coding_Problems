/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
     public void doit(TreeNode root, StringBuilder res){
            if(root == null) {
                res.append("#").append(",");
            }
            else{
                res.append(Integer.toString(root.val)).append(",");
                doit(root.left,res);
                doit(root.right,res);
            }
        }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        doit(root,sb);
        return sb.toString();
        
    }
    
    public TreeNode doit(Deque<String> nodes){
        String val = nodes.remove();
            if(val.equals("#")) return null;
            else{
                TreeNode root = new TreeNode(Integer.valueOf(val));
                root.left = doit(nodes);
                root.right = doit(nodes);
                return root;
            }
        }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return doit(nodes);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));