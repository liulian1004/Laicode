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
  public TreeNode insert(TreeNode root, int key) {
    // interative
    if(root == null) {
      return new TreeNode(key);
    }
    TreeNode cur = root;
    while(cur.key != key) {
      if(key < cur.key) {
        if(cur.left == null) {
          cur.left = new TreeNode(key);
          break;
        }
        cur = cur.left;
      } else{
        if(cur.right == null) {
          cur.right = new TreeNode(key);
          break;
        }
        cur = cur.right;
      }
    }
    return root;
  }
  //  recursion
  // if(root == null) {
  //   return new TreeNode(key);
  // }
  // if(key < root.key) {
  //   //把new node挂到root的left
  //   root.left = insert(root.left, key);
  // }else if(key > root.key) {
  //   root.right = insert(root.right, key);
  // }
  // // case 1: root.key == key, 不用插入key 直接返回
  // // case 2: key已经插入，返回挂上key 的root
  // return root;
  // }
}
