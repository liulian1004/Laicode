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
  public boolean hasCycle(ListNode head) {
    // write your solution here
    if (head == null || head.next == null) {
      return false;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null && fast.value != slow.value) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast.value == slow.value) {
      return true;
    }
    // while (fast != null && fast.next != null) {
    //   slow = slow.next;
    //   fast = fast.next.next;
    //   if (fast == slow) {
    //     return true;
    //   }
    // }
    return false;
  }
}
