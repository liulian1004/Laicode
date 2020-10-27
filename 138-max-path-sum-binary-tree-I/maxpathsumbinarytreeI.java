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
    // 1. max single path from child to a leaf
    //2.update max if has both child
    //3 . return the max single path of left child and right child
    //这题在update globalmax是必须确认是一个人字形结构
    //当左右两个子树缺一个的情况下就不能update

    //T: O(n); S: O(h)
    int[] max = new int[]{Integer. MIN_VALUE};
    if(root == null || root.left == null && root.right == null) {
      return max[0];
    }
    helper(root, max);
    return max[0];
  }
  private int helper(TreeNode root, int[] max) {
    if(root== null) {
      return 0;
    }
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    //这里要确保和max比的结果是一个人字形
    //here can update the global max
    if(root.left != null && root.right != null) {
      //update the global max
      // max[0] VS left+ right + root.key
      max[0] = Math.max(max[0], left+ right + root.key);
    }
    //这里必须要对左右子树分开对待
    //因为如果都用Math.max(leftSum, rightSum)
    //可能出现的是leftchild == -7, rightChild == 0(即没有rightchild)
    //结果会只取0,是错误的
    if(root.left == null) {
    	return rightSum + root.key;
    }else if(root.right == null) {
    	return leftSum + root.key;
    }
		return root.key + Math.max(leftSum, rightSum);

  }
}
