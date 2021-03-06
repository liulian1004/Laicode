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
  public ListNode insert(ListNode head, int value) {
    // insert before the head
    ListNode target = new ListNode(value);
    if (head == null || head.value >= value) {
      target.next = head;
      return target;
    }
    // insert after head
    ListNode cur = head;
    while (cur.next != null && cur.next.value < value) {
      cur = cur.next;
    }
    // either cur == tail || value <= cur.next
    target.next = cur.next;
    cur.next = target;
    return head;

  }
}
// solution 2
public ListNode insert(ListNode head, int value) {
    // insert before the head
    ListNode target = new ListNode(value);
    ListNode dummy = new ListNode(-1);
    ListNode pre = dummy;
    pre.next = head;
    while (pre.next != null) {
      if(pre.next.value >= value) {
        target.next = pre.next;
        pre.next = target;
        return dummy.next;
      }
      pre = pre.next;
    }
    // pre.next == null;
    pre.next = target;
    return dummy.next;
  }
