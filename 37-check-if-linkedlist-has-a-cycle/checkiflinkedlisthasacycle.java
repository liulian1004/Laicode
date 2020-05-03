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
   public boolean hasCycle(ListNode head) {
     // write your solution here
     if(head == null || head.next == null) {
       return false;
     }
     ListNode slow = head;
     ListNode fast = head;
     while(fast.next != null && fast.next.next != null) {
     //progress,要先循环
     slow = slow.next;
     fast = fast.next.next;
     //iteration processing
       if(fast == slow) {//无所谓有没有重复值，判断的是地址
       return true;
     }

     }
     return false;

   }
 }
