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
  public int longest(TreeNode root) {
    //TL O(n) S: O(height)
    if(root == null) {
      return 0;
    }
    int[] max = new int[1];
    helper(root, Integer.MIN_VALUE, max, 0);
    return max[0];
  }
  //想要跟随者层数变化的，用primate type
  //想要全局变量，用int[]
  private void helper(TreeNode root, int parent, int[] max, int path) {
    if(root == null){
      return;
    }
    if(root.key > parent) {
      path++;
    } else{
      path = 1;
    }
    max[0] = Math.max(max[0], path);
    helper(root.left, root.key, max, path);
    helper(root.right, root.key, max, path);
  }
}
