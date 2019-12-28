public class Solution {
    public ListNode mergeSort(ListNode head) {
  // Time: nlogn Space logn
    if ( head == null || head.next == null) {
            return head; }
            ListNode mid =  findMid(head);
            ListNode rightHead = mid.next;
            mid.next = null;
            ListNode left = mergeSort(head);
            ListNode right = mergeSort(rightHead);
            return merge(left, right);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode i = left;
        ListNode j = right;
        while ( i != null && j != null) {
            if (i.value <= j.value) {
                tail.next = i;
                i = i.next;
            } else {
                tail.next = j;
                j = j.next;
            }
            tail = tail.next;
        }
        if (i == null) {
            tail.next = j;
        }
        if (j == null) {
            tail.next = i;
        }

        return dummy.next;
    }
}
