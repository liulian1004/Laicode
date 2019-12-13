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
  public ListNode insertNode(ListNode head, int target) {
    // Write your solution here
    ListNode pre = head;
    ListNode t = new ListNode(target);
    while (pre.next != null && pre.next.value < target) {
      pre = pre.next;
    }
    // either pre == tail || target <= pre.next
    t.next = pre.next;
    pre.next = t;
    return head;
  }
}
