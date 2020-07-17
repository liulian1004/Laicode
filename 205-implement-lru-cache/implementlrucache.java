public class Solution<K, V> {
  // limit is the max capacity of the cache
  // linkHashMap + hashmap<k, node<k,v>>
  // latest recently used
  //node is the input data structure, map is the index to findout the node in the doulbe node structure
  static class Node<K,V> {
    Node<K,V> next;
    Node<K,V> prev;
    K key;
    V value;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
    void update(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
  private final int limit;
  private Node<K,V> head;
  private Node<K,V> tail;
  private Map<K, Node<K,V>> map;

  public Solution(int limit) {
    this.limit = limit;
    this.map = new HashMap<K, Node<K,V>>();
  }
  //跟新node + 更新node在linkedlist中的position
  public void set(K key, V value) {
    //初始化node
    Node<K,V> node = null;
    //如果存在，update node
    if(map.containsKey(key)) {
        node = map.get(key);
        node.value = value;
        //删除在linkedlist中的position
        remove(node);
    //node不存在且size没有超界，直接创建node
    //用map.size() O(1)时间查到size
    } else if(map.size() < limit){
        node = new Node<K,V>(key,value);
    //node不存在且size已满，删掉一个tail node,更新tail node的值，把这个node变成tail
    } else {
      node = tail;
      remove(node);
      node.update(key, value);
    }
    //把node放到头回去
    append(node);
  }
  //读取node值 + 更新node在linkedlist中的position
  public V get(K key) {
    Node<K,V> node = map.get(key);
    if(node == null) {
      return null;
    }
    //在 linkedlist 删除原来的node
    remove(node);
    //添加到linked list的head
    append(node);
    return node.value;

  }
  //对现有的node进行移除
  private void remove(Node<K,V> node) {
  //private Node<K,V> remove(Node<K,V> node) {
    //在map中移除key
    map.remove(node.key);
    //node在list的中间
    if(node.prev != null) {
      node.prev.next = node.next;
    }
    if(node.next != null) {
      node.next.prev = node.prev;
    }
    // node在头尾
    if(node == tail) {
      //node.prev = tail;
      tail = node.prev;
    }
    if(node == head) {
      head = node.next;
    }
    //把node单独设置成一个node
    node.next = null;
    node.prev = null;
    //return node;
  }
  private Node<K,V> append(Node<K,V> node) {
  //private Node<K,V> append(Node<K,V> node) {
      //在map中加入node
      map.put(node.key, node);
      //不存在linkedlist
      if(head == null){
        head = tail = node;
      //存在，跟新node在linkedlist中的位置
      } else{
        node.next = head;
        head.prev = node;
        head = node;
      }
      return node;
  }

}
// my soution Map<Key, Node<V>> + double linkedList<Node>
public static class Solution<K, V> {
      // limit is the max capacity of the cache
      // linkHashMap + hashmap<k, node<k,v>>
      // node<k,v> --> node of doubly linkedlist
      static class Node<V> {
          Node<V> next;
          Node<V> prev;
          V value;

          Node(V value) {
              this.value = value;
          }
      }
      private final int limit;
      private Node<V> head;
      private Node<V> tail;
      private Map<K, Node<V>> map;

      public Solution(int limit) {
          this.limit = limit;
          this.map = new HashMap<>(); //?
      }
      //跟新node + 更新node在linkedlist中的position
      //每一次在head存新的node,tail node就是最旧的node
      public void set(K key, V value) {
          Node<V> node = new Node<>(value);
          //如果存在，update node,把这个node移动到最新的位置
          if(map.containsKey(key)) {
              remove(map.get(key));
          } else if(map.size() == limit) {
              K k = null;
                  for(Map.Entry<K,Node<V>> entry : map.entrySet()) {
                          if(entry.getValue() == tail) {
                              k = entry.getKey();
                      }
                  }
              map.remove(k);
              remove(tail);
          }
          //把node加回去
          map.put(key, node);
          append(node,key);

      }
      //读取node值 + 更新node在linkedlist中的position
      public V get(K key) {
          Node<V> node = map.get(key);
          if(node == null) {
              return null;
          }
          remove(node);
          append(node, key);
          return node.value;

      }
      //对现有的node进行移除
      private void remove(Node<V> node) {
          if(node == head) {
              head  = node.next;
          }else if(node == tail) {
              tail = tail.prev;
          } else{
              Node pre = node.prev;
              Node next = node.next;
              pre.next = next;
              next.prev = pre;
          }

      }
      private void append(Node<V> node, K key) {
          //在map中加入node
          map.put(key, node);
          //不存在linkedlist
          if(head == null){
              head = tail = node;
              //存在，跟新node在linkedlist中的位置
          } else{
              node.next = head;
              head.prev = node;
              head = node;
          }
      }

  }
