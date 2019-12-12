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
    // Write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pre = null;//第一步就能给末尾加上null，不需要结尾时再加上null了
    ListNode cur = head;
    ListNode next;//在循环里面初始化next，保证没有NPE（cur指向null时）
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    //head.next = null;
    return pre;
  }
}
