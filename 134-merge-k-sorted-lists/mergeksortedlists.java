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
  public ListNode merge(List<ListNode> listOfLists) {
    // T: number of nodes * logn
    //S: size of listOfLists
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new myComparator());
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    for(ListNode node: listOfLists) {
      if(node != null) {
        minHeap.offer(node);
      }
    }
    while(!minHeap.isEmpty()) {
      ListNode node = minHeap.poll(); // T: logn
      cur.next = node;
      if(node.next != null) {
        minHeap.offer(node.next); // T:logn
      }
      cur = cur.next;
    }

    return dummy.next;
  }
   public static class myComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode a, ListNode b) {
      if(a.value == b.value) {
        return 0;
      }
      return a.value < b.value ? -1 : 1;
    }
  }
}
