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
  public int diameter(TreeNode root) {
     //T: O(n) S: O(heignt)
        if(root == null) {
            return 0;
        }
        int[] len = new int[]{0};
        helper(root, len);
        return len[0];
    }
    private int helper(TreeNode root, int[] len) {
        if(root == null) {
            return 0;
        }
        int leftLen = helper(root.left, len);
        int rightLen = helper(root.right, len);
        //必须有左右子树才能满足条件计算diameter
        if(leftLen > 0 && rightLen > 0) {
           len[0] = Math.max(len[0],leftLen + rightLen +1);
        }

        return Math.max(leftLen,rightLen) + 1;
    }
}
