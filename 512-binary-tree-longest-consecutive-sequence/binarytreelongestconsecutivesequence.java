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
  public int longestConsecutive(TreeNode root) {
    //T: O(n) S: O(height)
    if(root == null) {
      return 0;
    }
    int[] max = new int[]{0};
    helper(root, max);
    return max[0];
  }
    // 3 steps - from bottom to top
    //ask for the longestConsecutive from the leftsubtree/rightsubtree start from this root
    //pick the largest one and return to parent
    //parent get the number of  longest consecutive tree
    // don't forget update the global max
  private int helper(TreeNode root, int[] max) {
    if(root == null) {
      return 0;
    }
    int leftsub = helper(root.left, max);
    int rightsub = helper(root.right, max);
    // root自己要先加1， 最差情况从root这里开始连续
    int consecutive = 1;
    if(root.left != null && root.key + 1 == root.left.key) {
      consecutive = Math.max(consecutive, 1 + leftsub);
    }
    if(root.right != null && root.key + 1 == root.right.key) {
      consecutive = Math.max(consecutive, 1 + rightsub);
    }
    max[0] = Math.max(max[0], consecutive);
    return consecutive;

  }
}
