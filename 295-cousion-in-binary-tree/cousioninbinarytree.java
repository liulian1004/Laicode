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
  public boolean isCousin(TreeNode root, int a, int b) {
    // T: O(n + list.length) S: O(list.length)
    // A: no duplicated elements
    // bst + map(node, root)

    if(root == null) {
      return false;
    }
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while(!queue.isEmpty()) {
      Map<Integer, Integer> map = new HashMap<>();
      int size = queue.size();
      for(int i = size; i > 0; i--) {
        TreeNode cur = queue.poll();
        if(cur.left != null) {
          queue.offer(cur.left);
          map.put(cur.left.key, cur.key);
        }
        if(cur.right != null) {
          queue.offer(cur.right);
          map.put(cur.right.key, cur.key);
        }
      }
      if(map.containsKey(a) && map.containsKey(b)) {
         int v1 = map.get(a);
         int v2 = map.get(b);
         if(v1 == v2) {
             return false;
             } else {
              return true;
          }
      } else if (map.containsKey(a) || map.containsKey(b)) {
           return false;
           }
    }
    return false;
  }
}
