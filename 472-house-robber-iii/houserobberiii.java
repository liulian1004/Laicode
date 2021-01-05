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
  public int rob(TreeNode root) {
    // 不能用level -order 做
    //因为可能同一层，只拿来左边branch，没有拿右边branch
    //用tree dp
    //int[] dp represent dp[0]: root+ root.child.child， dp[1]: root.child
    int[] res = helper(root);
    return Math.max(res[0], res[1]);
  }
  private int[] helper(TreeNode root){
    if(root == null){
      return new int[2];
    }
    int[] left = helper(root.left);
    int[] right = helper(root.right);
    int[] res = new int[2];
    //case1 : root + root.child.child
    res[0] = root.key + left[1]+ right[1];
    //cas3 : root.child ==> 这里就看下一层哪一个大，算哪一个
    res[1] = Math.max(left[1],left[0]) + Math.max(right[1], right[0]);
    return res;
  }
}
