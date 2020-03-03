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
  public int maxPathSum(TreeNode root) {
    // 1. leftChild: the max sigle path start from leftChild
    // rightchild: the max sigle path start from rightChild
    // 2. current layer
    // update the global max with max(left,0) + max(right, 0）+ root.value
    // 3.return to parent
    // max(left, right,0) + root.value

    //T: O(n); S: o(h)
    int[] max = new int[] {Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }
  private int helper(TreeNode root, int[] max) {
    if(root == null) {
      return 0;
    }
    int leftChild = helper(root.left, max);
    int rightChild = helper(root.right, max);
    //更新leftchild and rightchild
    //如果是负数，重置为0
    leftChild = leftChild < 0? 0 : leftChild;
    rightChild = rightChild < 0 ? 0: rightChild;
    // current layer
    max[0] = Math.max(max[0], leftChild+rightChild+root.key);
    // return to parent
    return Math.max(leftChild, rightChild) + root.key;

  }
}
