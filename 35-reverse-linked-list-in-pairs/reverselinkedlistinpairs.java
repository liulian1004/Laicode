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
  public ListNode reverseInPairs(ListNode head) {
    // T: O(n) S: O(n/2) = O(n)
    if(head == null || head.next == null) {
      return head;
    }
    //先把newHead找好
    //如果第一，第二行交换写，会是newHead指向返回值，会引起circular
      ListNode newHead = head.next;
      head.next = reverseInPairs(head.next.next);
      newHead.next = head;
      return newHead;
  }
}
