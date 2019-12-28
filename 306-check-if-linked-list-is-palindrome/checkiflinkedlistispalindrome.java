public class Solution {
  public boolean isPalindrome(ListNode head) {
     // Time: O(n), Space: O(1)
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMid (head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        while (head != null && right != null) {
            if (head.value != right.value) {
                return false;
            }
            head = head.next;
            right = right.next;
        }
        return true;
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

    private ListNode reverse (ListNode head) {
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
