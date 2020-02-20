public class Solution {
  public int[] closestKValues(TreeNode root, double target, int k) {
    // inorder travesel because of BST + sliding windowns
    // T: O(n) S: O(k)
    Deque<Integer> deque = new ArrayDeque<>();
    inOrderTraversal(root, target, k, deque);
    //in case k > root.size
    int size = deque.size();
    int[] result = new int[size];
    for(int i = 0; i < size; i++) {
      result[i] = deque.pollFirst();
    }
    return result;
  }
  private void inOrderTraversal(TreeNode root, double target, int k, Deque<Integer> deque) {
    if(root == null) {
      return;
    }
    inOrderTraversal(root.left, target, k, deque);
    if(deque.size() < k){
      deque.offerLast(root.key);
    } else if (Math.abs(deque.peekFirst() - target) > Math.abs(root.key - target)) {
      deque.pollFirst();
      deque.offerLast(root.key);
      //不满足条件 直接返回 后面的nood也不需要traversal了
    } else {
      return;
    }
    inOrderTraversal(root.right, target, k, deque);
  }


}
