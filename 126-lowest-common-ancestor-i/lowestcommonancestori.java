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
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two)
  {
    // T: O(n);S O(h)
    //case 1 : a 和b都不在以p为root的tree中， 返回null, 这道题已经假设这个情况不存在
    //case 2: a, 和b有一个在，返回那个在的点
    //case 3: a 和b都在，返回a 和b的LCA
    // corner case
    if (root == null) {
      return root;
    }
    // one或two已经为root节点
    if (root == one || root == two) {
      return  root;
    }
    // ll，lr的LCR结果
    TreeNode ll = lowestCommonAncestor(root.left, one, two);
    TreeNode lr = lowestCommonAncestor(root.right, one, two);
    //one 和 two 分别在两个子树上
      if( ll != null && lr != null ) {
      return root;
    }
    // one，two在一边子树上
    // ll == null or lr == null
    return ll == null ? lr : ll;

  }
}
