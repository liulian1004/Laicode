/**
 * public class TreeNodeLeft {
 *   public int key;
 *   public TreeNodeLeft left;
 *   public TreeNodeLeft right;
 *   public int numNodesLeft;
 *   public TreeNodeLeft(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public void numNodesLeft(TreeNodeLeft root) {
    // T: O(n) S: O(h)
    numsNode(root);
  }
  private int numsNode(TreeNodeLeft root){
    if(root == null) {
      return 0;
    }
    int leftNode = numsNode(root.left);
    int rightNode = numsNode(root.right);
    root.numNodesLeft = leftNode;
    return leftNode + rightNode + 1;
  }
}
