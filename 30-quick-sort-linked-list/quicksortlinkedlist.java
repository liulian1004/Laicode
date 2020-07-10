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
    if(head == null || head.next == null) return head;
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
    ListNode pivot = removeNext(left);
    ListNode cur = left;
    ListNode newHead = pivot;
    //所有vaild node扫描完成
    while(cur.next != right) {
        if(cur.next.value <= pivot.value) {
          cur = cur.next;
        }else {
          ListNode node = removeNext(cur);
          newHead.next = node;
          newHead = newHead.next;
        }
    }
    //把两个listnode接起来
    cur.next = pivot;
    //这里 pivot 已经指向了newHead的头，所以不需要连接
    newHead.next = right;
    return pivot;
  }
  //remove the node.next from listnode, and return the node.next
  private ListNode removeNext(ListNode node) {
      ListNode res = node.next;
      if(node.next == null) {
        return res;
      }
      node.next = res.next;
      return res;
  }

}
