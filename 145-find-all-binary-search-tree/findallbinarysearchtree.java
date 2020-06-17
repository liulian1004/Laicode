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
  //Catalan tree
  //T: Catalan numbers:(2n)! / ((n + 1)! * n!)
  //T:  O(2^n*h) (2 branch with h height)
  //S: O(h)--worse case h == n
  public List<TreeNode> generateBSTs(int n) {
    return helper(1,n);
  }
  private List<TreeNode> helper(int start, int end) {
    List<TreeNode> list = new ArrayList<>();
    //已cover base case n < 1
    if(start > end) {
      list.add(null);
      return list;
    }
    // left subtree[start, i-1]; right subtree[i+1, end]
     for(int i = start; i <= end; i++) {
       List<TreeNode> leftTree = helper(start, i-1);
       List<TreeNode> rightTree = helper(i+1, end);
       for(TreeNode left : leftTree) {
         for(TreeNode right: rightTree) {
           TreeNode root = new TreeNode(i);
           root.left = left;
           root.right = right;
           list.add(root);
         }
       }
     }
     return list;
  }
}
