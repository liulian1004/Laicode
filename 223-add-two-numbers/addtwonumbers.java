public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Time O(n), Space O(1)
    ListNode dummy = new ListNode(-1);
  ListNode cur = dummy;
  ListNode cur1 = l1;
  ListNode cur2 = l2;
  int carry = 0;
  while (cur1!= null || cur2!=null) {
    int sum = carry;
    if (cur1 != null) {
      sum += cur1.value;
      cur1 = cur1.next;
    }
    if (cur2 != null) {
      sum += cur2.value;
      cur2 = cur2.next;
    }
    cur.next = new ListNode(sum%10);
    carry = sum/10;
    cur = cur.next;
  }
  if (carry != 0) {
    cur.next = new ListNode(carry);
  }
  return dummy.next;
}
}
