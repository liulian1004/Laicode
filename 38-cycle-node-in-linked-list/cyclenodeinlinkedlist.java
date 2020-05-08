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
  public ListNode cycleNode(ListNode head) {
    // T: O(n) S: O(1)
    // a. fast meets slow b. a new pointer start from head and chase slow c. meet agian => return the meeting point
    if(head == null || head.next == null){
      return null;
    }
    ListNode fast = head;
    ListNode slow = head;
    while(fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if(fast == slow){
        ListNode node = head;
        while(node != slow) {
            node = node.next;
            slow = slow.next;
        }
          return slow;
      }
    }
    return null;

  }
}
