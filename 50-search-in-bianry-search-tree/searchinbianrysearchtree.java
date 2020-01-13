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
  public TreeNode search(TreeNode root, int key) {
    // recursion
    // if(root == null || root.key == key) {
    //   return root;
    // }
    // if(root.key > key) {
    //   //找到的结果往上传(null|| root)
    //   return search(root.left, key);
    // } else{
    //   return search(root.right, key);
    // }
    //Interative
    while(root != null && root.key != key) {
      if(key < root.key) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return root;
  }
}
