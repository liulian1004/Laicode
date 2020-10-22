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
  public TreeNode sortedArrayToBST(int[] num) {
    // Write your solution here
    return helper(num, 0, num.length-1);
  }
  private TreeNode helper(int[] num, int left, int right){
    if(left > right){
      return null;
    }
    int mid = left + (right-left)/2;
    //below code just for testing purpose,
    //which requre the leftTree has one more node than rightTree if not equaly separated
    // if((right-left+1) % 2 == 0) {
    //   mid = mid+1;
    // }
    TreeNode leftTree = helper(num, left, mid-1);
    TreeNode root = new TreeNode(num[mid]);
    TreeNode rightTree = helper(num, mid+1, right);
    root.left = leftTree;
    root.right = rightTree;
    return root;
  }
}
