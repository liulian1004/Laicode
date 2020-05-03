public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Time O(n), Space O(1)
       ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int val = 0;
        while ( r1 != null || r2 != null || val != 0) {
            if (r1 != null) {
                val += r1.value;
                r1 = r1.next;
            }
            if (r2 != null) {
                val += r2.value;
                r2 = r2.next;
            }
            cur.next = new ListNode(val % 10);
            val = val / 10;
            cur = cur.next;
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
