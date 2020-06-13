public class Solution {
  public List<Integer> levelOrderBottom(TreeNode root) {
    // T: O(n) S: O(h)
    //recursion
    List<Integer> list = new ArrayList<>();
    if(root == null) {
      return list;
    }
    int height = getHeight(root);
    helper(root, height, list, 1);
    return list;
  }
  private int getHeight(TreeNode root) {
    if(root == null) {
      return 0;
    }
    return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
  }
  private void helper(TreeNode root, int h, List<Integer> list, int level) {
      if(root == null) {
        return;
      }
      if(root.left == null && root.right == null && level == h) {
        list.add(root.key);
        return;
      }
      helper(root.left, h, list, level +1);
      helper(root.right, h, list, level +1);
  }
  //interation
  public List<Integer> levelOrderBottom(TreeNode root) {
    // T: O(n) S: O(m)
    List<Integer> pre = new ArrayList<>();
    if(root == null) {
      return pre;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> curList = new ArrayList<>();
      for(int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        curList.add(cur.key);
        if(cur.left != null) {
          queue.offer(cur.left);
        }
        if(cur.right != null) {
          queue.offer(cur.right);
        }
      }
      pre = curList;
    }
    return pre;
  }
}
