public class Solution {
  public List<Integer> kClosestBST(TreeNode root, int target, int k) {
    // T:O(n*h) S: o(h)
    Queue<Integer> queue = new ArrayDeque<>();
    helper(root, target, k, queue);
    List<Integer> list = new ArrayList<>();
    while(!queue.isEmpty()) {
      list.add(queue.poll());
    }
    return list;
  }
  private void helper(TreeNode root, int target, int k ,Queue<Integer> queue) {
    if(root== null) {
      return;
    }
    helper(root.left, target, k, queue);
    if(queue.size() < k) {
         queue.offer(root.key);
    }else if(Math.abs(root.key - target) < Math.abs(queue.peek() - target)) {
      queue.poll();
      queue.offer(root.key);
    }
    helper(root.right, target, k , queue);
  }
}
