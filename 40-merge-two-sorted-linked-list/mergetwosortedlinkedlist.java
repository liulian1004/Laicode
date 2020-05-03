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
  public ListNode merge(ListNode one, ListNode two) {
    //这个情况后续会覆盖到
    // if (one == null) {
    //   return two;
    // }
    // if (two == null) {
    //   return one;
    // }
    ListNode dummy = new ListNode(-1);
    ListNode h = dummy;
    //不需要返回one和two,所以可以直接移动他们
    //ListNode cur1 = one;
    //ListNode cur2 = two;
    while (one != null && two != null) {
      if (one.value <= two.value) {
        h.next = one;
        one = one.next;
      } else {
        h.next = two;
        two = two.next;
      }
      h = h.next;
    }
    // cur1 == tail || cur2 == tails
    if (one == null) {
      h.next = two;
    } else {
      h.next = one;
    }

  return dummy.next;

  }
}
