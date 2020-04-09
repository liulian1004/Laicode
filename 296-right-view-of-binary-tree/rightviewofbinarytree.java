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
  public List<Integer> rightView(TreeNode root) {
    // T: O(n) S: O(m) → m: the length longest level of tree
    //deque --> popFirst; push (right, left) to the last
    List<Integer> list = new ArrayList<>();
    if(root == null) {
      return list;
    }
    Deque<TreeNode> buffer = new ArrayDeque<>();
    buffer.offerFirst(root);
    while(!buffer.isEmpty()) {
      TreeNode first = buffer.peekFirst();
      list.add(first.key);
      int size = buffer.size();
      while(size > 0) {
        TreeNode cur = buffer.pollFirst();
        if(cur.right != null) {
              buffer.offerLast(cur.right);
        }
        if(cur.left != null) {
          buffer.offerLast(cur.left);
        }
        size--;
      }
    }
    return list;
  }
}
