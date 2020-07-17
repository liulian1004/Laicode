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
 public ListNode quickSort(ListNode head) {
   //T： O(n^2) S: O(n)
    // left = dummy / pivot
    //right = null/ pivot
    //每一次pivot都跳过left，right和pivot,他们都应该都在
    //每一次和head比大小
   ListNode dummy = new ListNode(-1);
   dummy.next = head;
   helper(dummy, null);
   return dummy.next;
 }
 private void helper(ListNode left, ListNode right) {
   //只剩left,right 或者 left+ node+ right
   if(left.next == right || left.next.next == right) {
     return;
   }
   ListNode pivot = partition(left, right);
   helper(left, pivot);
   helper(pivot, right);
 }
 private ListNode partition(ListNode left, ListNode right) {
   //each around, take the first valid left as the pivot
   ListNode pivot = left.next;
   ListNode pre = pivot;
   ListNode cur = pivot.next;
   while(cur != right) {
       ListNode next = cur.next;
       if(cur.value <= pivot.value) {
         pre.next = next;
         ListNode tmp = left.next;
         left.next= cur;
         cur.next = tmp;
       }else {
         pre = pre.next;
       }
       cur = next;
   }
   return pivot;
 }


}
