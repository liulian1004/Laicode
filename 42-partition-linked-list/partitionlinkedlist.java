/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode partition(ListNode head, int target) {
    // Write your solution here

  if (head == null || head.next == null) {
    return head;
  }
  ListNode dummyS = new ListNode(-1);
  ListNode headS = dummyS;
  ListNode dummyB = new ListNode(-1);
  ListNode headB = dummyB;
  while (head != null) {
    if (head.value < target ) {
      headS.next = head;
      headS = headS.next;
    } else {
      headB.next = head;
      headB = headB.next;
    }
    head = head.next;
  }
  //give the null to the end of linkedList
  headB.next = null;
  // linked two linkedlist
  headS.next = dummyB.next;
  return dummyS.next;
}
}
