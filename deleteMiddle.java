/**   You are given the head of a linked list. DELETE THE MIDDLE NODE, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.                 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        if(head==null && head.next==null)return null;

        fast= fast.next.next;

        while(fast !=null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        } 
        slow.next = slow.next.next;
        return head;
    }
}
// TC - O(n/2)  , SC - O(1)
