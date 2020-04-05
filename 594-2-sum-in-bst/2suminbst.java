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
  public boolean existSumBST(TreeNode root, int target) {
    //T: O(n); S: O(n)
    // 用pushLeft 和 pushright来模拟 leftbound and  rightbound
    //用stack.offerFirst/pollFirst来模拟left++， right++
    if(root == null) {
      return false;
    }
    Deque<TreeNode> leftBound = new ArrayDeque<>();
    Deque<TreeNode> rightBound = new ArrayDeque<>();
    pushLeft(root, leftBound);
    pushRight(root, rightBound);
    // ~~ while(left <= right)
    while(!leftBound.isEmpty() && !rightBound.isEmpty()) {
      int left = leftBound.peekFirst().key;
      int right = rightBound.peekFirst().key;
      //corner case : left pointer meet right pointer, exit the loop
      if(left == right) {
        break;
      }
      if(left + right == target)  {
        return true;
      }
      //left++
      if(left + right < target) {
        TreeNode cur = leftBound.pollFirst();
        pushLeft(cur.right, leftBound);
        // right--;
      } else {
        TreeNode cur = rightBound.pollFirst();
        pushRight(cur.left, rightBound);
      }
    }
    return false;
  }
  private void pushLeft(TreeNode root, Deque<TreeNode> stack){
    while(root != null) {
      stack.offerFirst(root);
      root = root.left;
    }
  }
  private void pushRight(TreeNode root, Deque<TreeNode> stack) {
    while(root != null) {
      stack.offerFirst(root);
      root = root.right;
    }
  }

}
