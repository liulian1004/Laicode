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
  public ListNode oddEvenList(ListNode head) {
    // Write your solution here
    if(head == null || head.next == null){
      return head;
    }
    ListNode odd = head;
    ListNode evenHead = head.next;
    ListNode even = evenHead;
    while(even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next= evenHead;
    return head;
  }
  //my soltuion
  ListNode cur = head;
    ListNode next = cur.next;
    ListNode h2 = head.next;
    while(next != null && next.next != null) {
        cur.next = next.next;
        next.next = next.next.next;
        cur = cur.next;
        cur.next = h2;
        next = next.next;
    }
    return head;
}
