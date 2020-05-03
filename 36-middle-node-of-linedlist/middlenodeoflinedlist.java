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
  public ListNode middleNode(ListNode head) {
    // T: O(n)
    //Assumpt： 偶数的情况下需要声明返回的是第一个mid
    //否则要在post-process里面要做个处理
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {//先遇到null的先放前面
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
    //返回第二个mid

    if(fast.next == null) {
        return slow;
    }
    return slow.next;
    
  }
}
