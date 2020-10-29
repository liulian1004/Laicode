public class Solution {
  public TreeNode deleteZero(TreeNode root) {
    // Write your solution here
    //三部曲：
    //ask for the return treenode from left branches and right branches
    // update the root and root.left, root. right in the current level
    // return the cur root to the upper root
    if(root == null){
         return null;
       }
       TreeNode left = deleteZero(root.left);
       TreeNode right = deleteZero(root.right);
       if(root.key == 0 && left == null && right == null){
         return null;
       }
       root.left = left;
       root.right = right;
       return root;
     }
}
//follow up: delete the node if the node only has one child
//ex:
//        8                          8
//     /     \                   /        \
//    5      6        ==>       5          3
//             \
//              3
public TreeNode deleteNode(TreeNode root){
        if(root == null){
            return null;
        }
        // left != null && right != null
        TreeNode left = deleteNode(root.left);
        TreeNode right = deleteNode(root.right);
        //不符合条件，不删node
        if(root.left == null && root.right == null
        || root.left != null && root.right != null){
            root.left = left;
            root.right = right;
            return root;
        }
        //只有一个child 的node，直接上传该node 的child
        return left == null? right: left;
    }
