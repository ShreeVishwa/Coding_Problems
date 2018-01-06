class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        if(len < k) return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;
        while(curr!=null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next!=null) head.next = reverseKGroup(next,k);
        return prev;
    }
}