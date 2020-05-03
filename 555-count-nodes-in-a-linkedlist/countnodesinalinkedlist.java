555
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
  public int count(ListNode head) {
    // Write your solution here
    if (head == null) {
      return 0;
    }
  int count = 0;
  ListNode cur = head;
  while (cur != null) {
    cur = cur.next;
    count++;
  }
  return count;
  }
}
