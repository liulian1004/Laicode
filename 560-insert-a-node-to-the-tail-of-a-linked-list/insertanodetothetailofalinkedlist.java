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
    //ListNode t = new ListNode(target);
    if (head == null) {
      return new ListNode(target);
    }
    ListNode cur = head;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = new ListNode(target);
    return head;
  }
}
