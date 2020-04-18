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
    // T: O(n) S: O(1)
    if(head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    //creat three pointer
    ListNode pre = dummy;
    ListNode cur = head;
    ListNode n = cur.next;
    while(n != null) {
      //find the duplicates nodes
      // cur move back pre, n move to the first non-duplicates node
      if(n.value == cur.value) {
        while(n != null && n.value == cur.value) {
        n = n.next;
        }
        cur = pre;
      }
      //connect cur with n
      // be careful about npe for the n pointer
      cur.next = n;
      pre = cur;
      cur = cur.next;
      if(n!= null) {
        n = n.next;
      }
    }
    return dummy.next;
  }
}
