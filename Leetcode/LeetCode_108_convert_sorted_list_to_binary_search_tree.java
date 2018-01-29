/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    
    public int findlength(ListNode st, ListNode end){
        int len = 0;
        while(st!=end){
            len++;
            st = st.next;
        }
        return len;
    }
    
    public ListNode findmid(ListNode st, ListNode end){
        int len = findlength(st,end);
        int count = 0;
        while(count!= len/2){
            count++;
            st = st.next;
        }
        return st;
    }
    
    public TreeNode helper(ListNode head, ListNode end){
        if(head == end) return null;
        ListNode mid = findmid(head,end);
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(head,mid);
        root.right = helper(mid.next,end);
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head,null);
    }
}

// A much better approach using the slow and fast pointers

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    
    public TreeNode helper(ListNode head, ListNode end){
        if(head == end) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=end && fast.next!=end){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head,slow);
        root.right = helper(slow.next,end);
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head,null);
    }
}