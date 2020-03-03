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
  public TreeNode reconstruct(int[] post) {
    // T: O(n) S: O(h)
    //代表当前层的最后一位index，即root的值
    int[] index = new int[]{post.length - 1};
    return helper( post, index, Integer.MIN_VALUE);
  }
  private TreeNode helper(int[] post, int[] index, int min) {
    //corner case
    //index已经扫描完了或者当前层的post[index[0]](root)值小于min值即不符合条件，往上return
    if(index[0] < 0 || post[index[0]] <= min) {
      return null;
    }
    TreeNode root = new TreeNode(post[index[0]]);
    //index值每一次传入root后要更新
    index[0]--;
    //每一次index和min值都会更新
    //先扫描subright tree 因为是postorder traversal, root旁边的数又很大可能是root.right
    root.right = helper(post, index, root.key);
    root.left = helper(post,index, min);
    return root;
  }
}
