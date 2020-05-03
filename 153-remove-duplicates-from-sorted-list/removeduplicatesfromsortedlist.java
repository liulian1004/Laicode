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
  public ListNode removeDup(ListNode head) {
    // T：O(n) S: O(1)
    if(head == null || head.next == null) {
      return head;
    }
    ListNode pre = head;
    ListNode cur = head.next;
    while(cur !=null) {
      while(cur != null && cur.value == pre.value) {
        cur = cur.next;
      }
      pre.next = cur;
      pre = pre.next;
      //notice npe before move the cur pointer
      if(cur != null) {
        cur = cur.next;
      }
    }
    return head;
  }
}
