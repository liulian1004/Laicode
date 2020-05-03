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
    // update the max sum with max(left,right, 0）+ root.value
    // update global max of submax
    // 3.return to parent
    // max(left, right,0) + root.value

    //T: O(n)
    //S: O(h)
    int[] max = new int[]{Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }

  private int helper(TreeNode root, int[] max) {
    if(root == null) {
      return 0;
    }
    int leftS = helper(root.left, max);
    int rightS = helper(root.right, max);
    //这个方法保证有效删选出最大的leftchild 和 rightchild
    int sumPath = Math.max(Math.max(leftS, rightS), 0) + root.key;
    max[0] = Math.max(max[0], sumPath);
    return sumPath;
  }
}
