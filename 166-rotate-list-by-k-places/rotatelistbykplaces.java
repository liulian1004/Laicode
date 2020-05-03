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
  public ListNode rotateKplace(ListNode head, int n) {
    //T: O(n); S:o(1)
    // n %= head.size();
    // new head = size() - n
    if(head == null || head.next == null) {
      return head;
    }
    //in order to calculate the module
    // size shall start from 1
    int size = 1;
    ListNode tail = head;
    while(tail.next != null) {
      tail = tail.next;
      size++;
    }
    n = n%size;
    //corner case for the n
    if(n ==0) {
      return head;
    }
    //find the new head and new tail
    ListNode newTail = head;
    int index = size - n -1;
    while(index > 0) {
        newTail= newTail.next;
        index--;
    }
    ListNode newHead = newTail.next;
    tail.next = head;
    newTail.next = null;
    return newHead;

  }
}
