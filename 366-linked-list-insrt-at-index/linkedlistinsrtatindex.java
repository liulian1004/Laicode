public class Solution {
  public ListNode insert(ListNode head, int index, int value) {
    // T: O(n)
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode cur = head;
    int i = 0;
    for(i = 0; i < index && cur != null; i++) {
        cur = cur.next;
        pre = pre.next;
    }
    if(i < index){
      return head;
    }
    ListNode temp = new ListNode(value);
    pre.next = temp;
    temp.next = cur;
    return dummy.next;
  }
}
