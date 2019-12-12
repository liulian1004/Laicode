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
  public ListNode generate(int n) {
    // Write your solution here
    ListNode head = new ListNode(0);
    ListNode cur = head;
    for ( int i  = 1; i < n ; i++) {
      //  ListNode h  = new ListNode(i);
      //  cur.next = h;
      cur.next = new ListNode(i);
      cur = cur.next;
    }
    return head;
  }
}
