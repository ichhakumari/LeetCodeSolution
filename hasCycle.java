// Q.141 Linked list Cycle

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head==null) return false;  // linked list is empty

        // not empty
        ListNode slow=head;
        ListNode fast=head;

        while(fast != null && fast.next != null){
            slow= slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;
        
    }
}

