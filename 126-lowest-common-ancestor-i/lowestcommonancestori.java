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
    //classcial LCA assume a 和 b都在tree
    //case 1 : a 和b都不在以p为root的tree中， 返回null, 这道题已经假设这个情况不存在
    //case 2: a, 和b有一个在，返回那个在的点
    //case 3: a 和b都在，返回a 和b的LCA
    // 总结： return the LCA of nodes in {a,b} that is/are the under p
    // corner case
    if(root == null || root == one || root == two) {
      return root;
    }
    // ll，lr的LCR结果
    TreeNode ll = lowestCommonAncestor(root.left, one, two);
    TreeNode lr = lowestCommonAncestor(root.right, one, two);
    //one 和 two 分别在两个子树上，返回他们的root
      if( ll != null && lr != null ) {
      return root;
    }
    // one，two在一边子树上
    // ll == null or lr == null
    return ll == null ? lr : ll;

  }
  //follow up： check  a 和 b 是不是都在树里
  //不在一个树里，返回null
  private TreeNode LCA（TreeNode root, TreeNode one, TreeNode two）{
    TreeNode reuslt = helper(root, one, two) {
      if(result != one || result != two) {
        return result;
        //查two是不是在one的下面
        //是的话LCA是one
      }else if(result == one){
        return tmp = helper(one, one, two);
        if(tmp == one){
          return result;
        }
      //查one是不是在two的下面
      //是的话LCA是two
      } else {
          return tmp = helper(two,two,one);
          if(tmp == two) {
            return result;
          }
      }
    }
    return new TreeNode();
    }

}
