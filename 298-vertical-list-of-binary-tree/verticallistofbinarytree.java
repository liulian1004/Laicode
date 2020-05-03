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
    Deque<Ele> deque = new ArrayDeque<>();
    deque.offerLast(new Ele(0,root));
    Map<Integer, List<Integer>> map = new HashMap<>();
    map.put(0, new ArrayList<>());
    map.get(0).add(root.key);
    int min = 0;
    int max = 0;
    while(!deque.isEmpty()) {
      int size = deque.size();
      while(size > 0) {
        int index = deque.peekFirst().col;
        TreeNode cur = deque.pollFirst().node;
        if(cur.left != null) {
          int col = index - 1;
          min = Math.min(min, col);
          if(!map.containsKey(col)) {
            map.put(col, new ArrayList<Integer>());
          }
          map.get(col).add(cur.left.key);
          deque.offerLast(new Ele(col, cur.left));
        }
        if(cur.right != null) {
          int col = index + 1;
          max = Math.max(max, col);
          if(!map.containsKey(col)) {
            map.put(col, new ArrayList<Integer>());
          }
          map.get(col).add(cur.right.key);
          deque.offerLast(new Ele(col, cur.right));
        }
        size--;
      }
    }
     for(int i = min; i <= max; i++) {
        list.add(map.get(i));
      }
      return list;
  }
  static class Ele{
    int col;
    TreeNode node;
    Ele(int col, TreeNode node) {
      this.col = col;
      this.node = node;
    }
  }
}
