/**
 * class SkipListNode {
 *   public int value;
 *   public SkipListNode next;
 *   public SkipListNode forward;
 *   public SkipListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  Map<SkipListNode,SkipListNode> map = new HashMap<>();
  public SkipListNode copy(SkipListNode head) {
    // recursion
    if(head == null){
      return head;
    }
    if(map.containsKey(head)){
      return map.get(head);
    }
    SkipListNode newNode = new SkipListNode(head.value);
    map.put(head, newNode);
    newNode.next = copy(head.next); //这里需要做deep copy， copy node的value
    SkipListNode forwardNode = head.forward;
    if(map.containsKey(forwardNode)){
      newNode.forward = map.get(forwardNode);
    }else if(forwardNode != null) {
      newNode.forward = new SkipListNode(head.forward.value);
      map.put(head.forward, newNode.forward);
    }
    return newNode;
  }
}
//interation
public SkipListNode copy(SkipListNode head) {
   // 这里注意无聊之前是否已经deep copy过，都需要建立链接
   //只是之前已经在map中了，不需要在deepcopy一份了
   if(head == null){
     return head;
   }
   Map<SkipListNode,SkipListNode> map = new HashMap<>();
   SkipListNode cur = head;
   SkipListNode newHead = new SkipListNode(cur.value);
   SkipListNode copy = newHead;
   map.put(cur, copy);
   while(cur != null){
     if(cur.next != null){
       if(!map.containsKey(cur.next)) {
           map.put(cur.next, new SkipListNode(cur.next.value));
       }
        copy.next = map.get(cur.next);
     }
     if(cur.forward != null){
       if(!map.containsKey(cur.forward)){
         map.put(cur.forward, new SkipListNode(cur.forward.value));
       }
       copy.forward = map.get(cur.forward);
     }
     cur = cur.next;
     copy = copy.next;
   }
   return newHead;
 }
