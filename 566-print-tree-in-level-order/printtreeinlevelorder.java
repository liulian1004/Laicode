//recsurive way
public List<List<Integer>> bfs(TreeNode root) {}
        //T: O(n) S: O(h)
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        helper(root, list, 0);
        reverse(list);
        return list;
    }
    private void helper(TreeNode root, List<List<Integer>> list, int k) {
        if(root == null){
            return;
        }
        if(list.size() == k){
            list.add(new ArrayList<>());
        }
         list.get(k).add(root.val);
        helper(root.left, list, k+1);
        helper(root.right, list, k+1);
    }
}
// level order
public List<Integer> bfs(TreeNode root) {
    // T: O(n) S:O(n)
    List<Integer> list = new ArrayList<>();
    if(root == null) {
      return list;
    }
    Deque<TreeNode> queue = new ArrayDeque<>();
    list.add(root.key);
    queue.offer(root);
    while(queue.size() != 0) {
        TreeNode cur = queue.poll();
        if(cur.left != null) {
            list.add(cur.left.key);
            queue.offer(cur.left);
        }
        if(cur.right != null) {
          list.add(cur.right.key);
          queue.offer(cur.right);
        }
    }
    return list;
  }
