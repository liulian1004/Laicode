public class Solution {
  public TreeNode deleteZero(TreeNode root) {
    // Write your solution here
   while(root != null) {
      boolean[] flag = new boolean[]{false};
      root = hasZeroLeaf(root,flag);
      if(!flag[0]){
        return root;
      }
   }
    return root;
  }
  private TreeNode hasZeroLeaf(TreeNode root, boolean[] flag) {
    //只有subtree有一边的时候，需要用root == null bound一下
    if(root.left == null && root.right == null && root.key == 0) {
        flag[0] = true;
        return null;
    }
    if(root.left != null) {
      root.left = hasZeroLeaf(root.left,flag);
    }
    if(root.right != null) {
       root.right = hasZeroLeaf(root.right,flag);
    }
    return root;
  }
}
