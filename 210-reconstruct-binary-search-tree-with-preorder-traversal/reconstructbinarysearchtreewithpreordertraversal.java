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
  public TreeNode reconstruct(int[] pre) {
    //interative方法,复杂度和recusive方法一样
    // stack : keep the parent nodes
    // case 1 cur.key < root; root = root.left; stack.offer()
    // case 2 cur.key > root ==> find the largest root smaller than cur, root = root.right; stack,offer()
    //T: O(n) S: O(height)
    //go to the bottom and return the root back
    //int[i] won't change even it's return back
    if(pre == null || pre.length == 0) {
      return null;
    }
    int[] index = new int[]{0};
    return helper(pre, Integer.MIN_VALUE, Integer.MAX_VALUE, index);
  }
  private TreeNode helper(int[] pre, int min, int max, int[] index) {
    if(index[0] >= pre.length || pre[index[0]] >= max || pre[index[0]] <= min) {
      return null;
    }
    TreeNode root = new TreeNode(pre[index[0]]);
    index[0]++;
    root.left = helper(pre, min, root.key,index);
    root.right = helper(pre, root.key, max, index);
    return root;
  }
}
