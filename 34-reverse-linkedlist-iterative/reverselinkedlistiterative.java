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
   public ListNode reverse(ListNode head) {
     // T: O(n), S: O(1)
     //corner case don't need to write,it cover in the below i
     if(head == null || head.next == null) {
     return head;}
     ListNode pre = null;
     while(head != null) {
       ListNode next = head.next;
       head.next = pre;
       pre = head;
       head = next;
     }
     return pre;
   }
 }
