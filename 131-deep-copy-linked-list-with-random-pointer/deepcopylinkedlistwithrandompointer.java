/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    // T: O(n) S: O(n)
    // map<head, head'>
    if(head == null) {
      return null;
    }
    //这里必须是要<node,node‘> 因为每次copy的是那个node’
    //如果是<node, value>, 那每次copy的是new node(value),生成了新的node
    //和上一个逻辑相比，不是同一个node
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode newHead = new RandomListNode(head.value);
    //初始化map 和new ListNode
    map.put(head, newHead);
    RandomListNode cur = newHead;
    while(head != null) {
        if(head.next != null) {
          if(!map.containsKey(head.next)) {
            map.put(head.next, new RandomListNode(head.next.value));
          }
            cur.next = map.get(head.next);
        }
        if(head.random != null) {
          if(!map.containsKey(head.random)) {
            map.put(head.random, new RandomListNode(head.random.value));
          }
          cur.random = map.get(head.random);
        }
        cur = cur.next;
        head = head.next;
      }
      return newHead;
    }
}
