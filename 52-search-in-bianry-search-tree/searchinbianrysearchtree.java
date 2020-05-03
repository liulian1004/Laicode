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
    if(root == null || root.key == key) {
      return root;
    }
    if(root.key > key) {
      //找到的结果往上传(null|| root)
      //以下是返回整个tree,没有做减支
      // if( key < root.key) {
      // root.left = search(root.left, key);
      // }
      return search(root.left, key);
    } else{
      return search(root.right, key);
    }
    //最后都要返回一个root，这里的root已经被代替成为key为parent的root
    return root;
    //Interative
    //  要注意这里的condition，只有&&才对
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
