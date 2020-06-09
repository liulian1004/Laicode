public class Solution {
  public ListNode deleteNode(ListNode head, int index) {
    // T: O(n)
    // expecial concer case if i == index and cur == null
    if(head == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    ListNode pre = dummy;
    dummy.next = head;
    ListNode cur = head;
    int i = 0;
    while(i < index && cur != null) {
      pre = cur;
      cur = cur.next;
      i++;
    }
    if(i == index && cur != null) {
      pre.next = cur.next;
    }

    return dummy.next;
  }
}
