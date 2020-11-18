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
  public ListNode removeNthFromEnd(ListNode head, int n) {
    // Write your solution here
    if(head == null || n <= 0){
      return head;
    }
    int length = getLength(head);
    int i = 1;
    ListNode cur = head;
    if(n > length){
      return head;
    }
    if(n == length) {
      return head.next;
    }
    while(i < length - n){
        cur = cur.next;
        i++;
    }
    ListNode next = cur.next.next;
    cur.next = next;
    return head;
  }
  private int getLength(ListNode node){
    int length =0;
    while(node != null){
      node = node.next;
      length++;
    }
    return length;
  }
}
