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
    //第二， 第三行不能交换写， 会使head.next和head.next.next断开
      ListNode newHead = head.next;
      head.next = reverseInPairs(head.next.next);
      newHead.next = head;
      return newHead;
  }
}
//interative
    // T： O（n) : S: O(1)
public ListNode reverseInPairs(ListNode head) {
    // Write your solution here
    if(head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    ListNode pre = dummy;
    while(head != null && head.next != null) {
      ListNode next = head.next.next;
      pre.next = head.next;
      head.next.next = head;
      head.next = next;
      head = next;
      pre = pre.next.next;
    }
    return dummy.next;
  }
//不用dummyhead
public ListNode reverseInPairs(ListNode head) {
    // T： O（n) : S: O(1)
    if(head == null || head.next == null) {
      return head;
    }
    ListNode newHead = head.next;
    while(head != null && head.next != null) {
      ListNode cur = head.next;
      ListNode next = cur.next;
      cur.next = head;
      if(next == null) {
        head.next = null;
        break;
      }else if(next.next == null) {
        head.next = next;
      }else {
        head.next = next.next;
      }
      head = next;
    }
    return newHead;
  }
