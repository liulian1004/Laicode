public class Solution {
  // hashmap<letter, null> + linkedlist
  static class Node{
    Node prev;
    Node next;
    Character ch;
    Node(Character ch) {
      this.ch = ch;
    }
  }
    private Node head;
    private Node tail;
    private Map<Character, Node> sigleNode;
    private Set<Character> repeated;

  public Solution() {
    // setup the dummy+循环链表
    tail = new Node(null);
    tail.next = tail.prev = tail;
    head = tail;
    sigleNode = new HashMap<>();
    repeated = new HashSet<>();
  }

  public void read(char ch) {
    //has repeated before, do nothing
    if(repeated.contains(ch)){
      return;
    }
    Node node = sigleNode.get(ch);
    if(node != null){
      remove(node);
    } else{
      node = new Node(ch);
      append(node);
    }
  }

  public Character firstNonRepeating() {
    // 初始化的时候，有一个空的node在linkedlist中
    //只有一个元素的时候，返回null
    if(head == tail) {
      return null;
    }
    //返回假元素的后面一个元素
    return head.next.ch;
  }

  private void remove(Node node) {
    node.prev.next = node.next;
    //循环链表的好处是下面node.next不会为null,node.next.prev就不会npe
    node.next.prev = node.prev;
    //原本是一个node
    //现在新加入一个node，更新tail的位置
    if(node == tail){
      tail = node.prev;
    }
    node.prev = node.next = null;
    sigleNode.remove(node.ch);
    repeated.add(node.ch);
  }
  private void append(Node node) {
    // node需要放在tail后面
    tail.next = node;
    node.prev = tail;
    node.next = head;
    tail = tail.next;
    sigleNode.put(node.ch, node);
  }
}
