public class Solution {
  public List<Integer> levelOrderBottom(TreeNode root) {
    // T: o(n)
    // s : o(n)
    // Assume: not null
    List<List<Integer>> list = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> layer = new ArrayList<>();;
        while(size > 0) {
        TreeNode cur = queue.poll();
        layer.add(cur.key);
        if(cur.left != null) {
            queue.offer(cur.left);

        }
        if(cur.right != null) {
          queue.offer(cur.right);
        }
        size--;
        list.add(layer);
      }
    }
    return list.get(list.size() - 1);
  }
}
