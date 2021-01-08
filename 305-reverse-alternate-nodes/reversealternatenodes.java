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
  public ListNode reverseAlternate(ListNode head) {
    //ex： 1 -> 2 ->3 ->4 -> null
    // 拆分： 1->3 ... and 2->4
    // reverse 2->4
    //append
    if(head == null || head.next == null){
      return head;
    }
    ListNode cur = head;
    ListNode h1 = cur.next;
    ListNode next = h1;
    while(next != null && next.next != null){
      cur.next = next.next;
      cur = cur.next;
      next.next = cur.next;
      next = next.next;
    }
    cur.next = reverse(h1);
    return head;
  }
  private ListNode reverse(ListNode head){
    ListNode prev = null;
    while(head != null){
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}
