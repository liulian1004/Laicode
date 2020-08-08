/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public List<List<Integer>> verticalPrint(TreeNode root) {
    //注意加入的顺序
    // deque.pollFirst(); deque.offerLast()
    // T: O(n) S: (size of map + size of stack)
    List<List<Integer>> list = new ArrayList<>();
    if(root == null) {
      return list;
    }
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(new Node(0,root));
    Map<Integer, List<Integer>> map = new HashMap<>();
    int min = 0;
    int max = 0;
    while(!queue.isEmpty()) {
      Node node = queue.poll();
      TreeNode cur = node.value;
      int position = node.position;
      if(!map.containsKey(position)) {
        map.put(position, new ArrayList<>());
      }
      map.get(position).add(cur.key);
      if(cur.left != null){
        queue.offer(new Node(position-1,cur.left));
        min = Math.min(min, position-1);
      }
      if(cur.right != null) {
        queue.offer(new Node(position+1, cur.right));
        max = Math.max(max, position+1);
      }
    }
    for(int i = min; i<=max; i++) {
      list.add(map.get(i));
    }
    return list;

  }
  static class Node{
    TreeNode value;
    int position;
    Node(int position, TreeNode value){
      this.position = position;
      this.value = value;
    }
  }
}
