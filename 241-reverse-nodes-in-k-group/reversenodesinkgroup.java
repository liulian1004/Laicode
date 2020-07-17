public class Solution {
   public ListNode reverseKGroup(ListNode head, int k) {
        // Write your solution here
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(head != null) {
            ListNode end = count(head, k);
            if(end == null) {
              //corner case:
              // k > linkedlist.size
                if(dummy.next == null) {
                  dummy.next = head;
                }
                return dummy.next;
            }
            ListNode next = end.next;
            pre.next = end;
            pre = reverse(head, next);
            pre.next = next;
            head = next;
        }
        return dummy.next;
    }
    private ListNode count(ListNode head, int k) {
        ListNode pre = null;
        while(k >0 && head != null) {
            pre = head;
            head = head.next;
            k--;
        }
        return k == 0? pre : null;
    }
    private ListNode reverse(ListNode head, ListNode end) {
        ListNode pre = null;
        ListNode newTail = head;
        while(head != end) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return newTail;
    }
}
