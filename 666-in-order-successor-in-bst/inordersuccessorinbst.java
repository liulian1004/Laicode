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
  public int inOrderSuccessor(TreeNode root, int p) {
    // T: O(height)
    //S: O(height)
    //key： 找到比target大一号的值；找到target值还是要继续travsal,直到底，才能找到比target大一号的值
    //如果找到target就返回，只会找到target的root值，不是要的结果
    if(root == null) {
      return -1;
    }
    int[] successor = new int[]{-1};
    helper(root, p, successor);
    return successor[0];
  }
  private void helper(TreeNode root, int p, int[] successor) {
    if(root == null) {
      return;
    }
    if(root.key > p){
      successor[0] = root.key;
      helper(root.left, p, successor);
    } else{
      helper(root.right, p ,successor);
    }
  }
}
//Interative
public int inOrderSuccessor(TreeNode root, int p) {
    // T: O(height)
    //S: O(1)
    //key： 找到比target大一号的值；找到target值还是要继续travsal,直到底，才能找到比target大一号的值
    //如果找到target就返回，只会找到target的root值，不是要的结果
    int res = -1;
    while(root != null) {

      if(root.key > p) {
        res = root.key;
        root = root.left;
      }else{
        root = root.right;
      }
    }
    return  res;
  }
//follow up
如果 target 不在tree里，返回-1

public int inOrderSuccessor(TreeNode root, int p) {
    // T: O(height)
    //S: O(1)
    //key： 找到比target大一号的值；找到target值还是要继续travsal,直到底，才能找到比target大一号的值
    //如果找到target就返回，只会找到target的root值，不是要的结果
    int res = -1;
    boolean exist = false;
    while(root != null) {
      if(root.key == p) {
        exist = true;
      }
      if(root.key > p) {
        res = root.key;
        root = root.left;
      }else{
        root = root.right;
      }
    }
    return  exist == true ? res : -1;
  }
