//recursive solution trying to find the minimum and then making a list which yeilds in a TLE

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        if(lists.length == 0) return head;
        int minVal = Integer.MAX_VALUE;
        int minInd = 0;
        for(int i=0;i<lists.length;i++){
            if(lists[i] != null) {
                if(lists[i].val < minVal) {
                    minVal = lists[i].val;
                    minInd = i;
                }
            }
        }
        if(minVal == Integer.MAX_VALUE) return null;
        head = lists[minInd];
        lists[minInd] = lists[minInd].next;
        // System.out.println(head.val);
        head.next = mergeKLists(lists);
        return head;
    }
}

//Improvised recursive solution which is done by merging two lists at a time

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists,0,lists.length-1);
    }
    
    public ListNode divide(ListNode[] lists, int s, int e){
        if(s==e) return lists[s];
        if(s<e){
            int mid = (s+e)/2;
            ListNode l1 = divide(lists,s,mid);
            ListNode l2 = divide(lists,mid+1,e);
            return merge(l1,l2);
        }
        else return null;
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else{
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}

