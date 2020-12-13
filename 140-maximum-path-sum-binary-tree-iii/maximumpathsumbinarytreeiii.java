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
//my Solution
//从下往上走，return max path sum for the cur path
// case1 : 如果left/right其中有一个 >0 root + 大于0/较大 的sub path
// case2: left< 0 right < 0 return root
public int maxPathSum(TreeNode root) {
    // Write your solution here
    int[] res = new int[]{Integer.MIN_VALUE};
    helper(root, res);
    return res[0];
  }
  private int helper(TreeNode root, int[] res){
    if(root == null){
      return 0;
    }
    int left = helper(root.left, res);
    int right = helper(root.right, res);
    int cur = root.key;
    if(left >= 0 || right >= 0){
       int add = left >= right? left: right;
       cur += add;
    }
    res[0] = Math.max(cur, res[0]);
    return cur;
  }
