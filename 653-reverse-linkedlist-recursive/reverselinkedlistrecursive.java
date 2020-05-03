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
  public ListNode reverse(ListNode head) {
    // n : # of node
    //T: O(n); S: O(n)
    // head == null is conrner case,
    // head.next == null is base case
    if (head == null || head.next == null) {
      return head;
    }
    //ex: 1 ->2 ->3->4->null
    // head = 3, newHead = 4
    //head.next = 4 ==> head.next.next ==> 4 -->3
    //head.next == > 3 -> null

    //reverse reverse完成后赋值只subhead
    ListNode subHead = reverse(head.next);
    // reversed linked list 和 head 链接
    head.next.next = head;
    head.next = null;
    return subHead;

  }
}
