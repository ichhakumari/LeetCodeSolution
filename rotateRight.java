// Q.61  ROTATE LIST   : Given the head of a linked list, rotate the list to the right by k places
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
static ListNode insertListNode(ListNode head, int val) {
    ListNode newListNode = new ListNode(val);
    if (head == null) {
      head = newListNode;
      return head;
    }
    ListNode temp = head;
    while (temp.next != null) temp = temp.next;

    temp.next = newListNode;
    return head;
  }
  //utility function to rotate list by k times
  static ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;
    for (int i = 0; i < k; i++) {
      ListNode temp = head;
      while (temp.next.next != null) temp = temp.next;
      ListNode end = temp.next;
      temp.next = null;
      end.next = head;
      head = end;
    }
    return head;
  }
  //utility function to print list
  static void printList(ListNode head) {
    while (head.next != null) {
      System.out.print(head.val + "->");
      head = head.next;
    }
    System.out.println(head.val);

  }

  public static void main(String args[]) {
    ListNode head = null;
    //inserting Node
    head = insertListNode(head, 1);
    head = insertListNode(head, 2);
    head = insertListNode(head, 3);
    head = insertListNode(head, 4);
    head = insertListNode(head, 5);

    System.out.println("Original list: ");
    printList(head);

    int k = 2;
    ListNode newHead = rotateRight(head, k); //calling function for rotating right of the nodes by k times

    System.out.println("After " + k + " iterations: ");
    printList(newHead); //list after rotating nodes

  }
}

