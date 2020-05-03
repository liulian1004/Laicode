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
  public int closest(TreeNode root, int target) {
    //T: O(h) - worst case O(n)-糖葫芦； best case o(logn) - 满二叉树
    //S： O（1）
    // global differnt to record the different between target and root
    if(root == null) {
      return Integer.MIN_VALUE;
    }
    int result = root.key;
    while(root != null) {
      // 找到target值
      if(root.key == target) {
        return root.key;
      //没有找到target值
      } else {
        //跟新result的值
          if(Math.abs(root.key - target) < Math.abs(result - target) ) {
            result = root.key;
          }
          // 走左右子树，缩小范围
          if(root.key > target ) {
            root = root.left;
          } else {
            root = root.right;
          }
      }
    }
    return result;

  }
}
