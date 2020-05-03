public class Solution {
  public ListNode removeElements(ListNode head, int val) {
     // Time: O(n).Space: O(1)
        if ( head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;//可以直接用head,因为dummy代替了head；
        while ( head != null) {
            if ( head.value == val) {
                pre.next = head.next;
            } else {
                pre = pre.next;
            }
            head = head.next;

        }
        return dummy.next;
  }
}
