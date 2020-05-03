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
  public ListNode insertCircularList(ListNode head, int newVal) {
    //T： O(n) S: O(1)
    //corner case : empty
    ListNode node = new ListNode(newVal);
    if(head == null){
      node.next = node;
      return node;
    }
    //one node
    if(head.next == head) {
       head.next = node;
       node.next = head;
       return head;
    }
    //find the tail(biggest nodes)
    ListNode tail = findTail(head);
    // new node >= tail or <= smallest node
    if(newVal >= tail.value || newVal <= tail.next.value ) {
        node.next = tail.next;
        tail.next = node;
        return head;
    }
    // new node insert in the between of two nodes
    ListNode h = tail.next;
    ListNode pre = tail;
    while(newVal > h.value) {
        h = h.next;
        pre = pre.next;
    }
    node.next = h;
    pre.next = node;
    return head;

  }
  private ListNode findTail(ListNode head) {
        int max = head.value;
        ListNode m = head;
        ListNode cur = head.next;
        while(cur != head) {
          // be careful about duplicated nodes
          // make sure the max always points to the later nodes
            if (cur.value >= max) {
                max = cur.value;
                m = cur;
            }
            cur = cur.next;
        }
        return m;
    }
}
