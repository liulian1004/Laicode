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
  public ListNode insertionSort(ListNode head) {
    if(head == null || head.next == null){
      return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    // the prev node before next, it's for connect with the node after next
    ListNode cur = head;
    //the node to be confirm, consider as index 2
    ListNode next = head.next;
    while(next != null){
    //each round ,start to compare from the first node
    ListNode start = dummy.next;
    ListNode prev = dummy;
    // check the sorted nodes with the unsorted one by one
    while(start != next){
        // find the fisrt unsorted element
       if(start.value > next.value){
          break;
        }
        start = start.next;
        prev = prev.next;
    }
    if(start.value > next.value){
        ListNode newNext = next.next;
        prev.next = next;
        next.next = start;
        cur.next = newNext;
        next = newNext;
    }else if(start == next){
        cur = cur.next;
        next = next.next;
     }
    }
  return dummy.next;
  }
}
