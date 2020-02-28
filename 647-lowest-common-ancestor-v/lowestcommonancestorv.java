/**
 * public class KnaryTreeNode {
 *     int key;
 *     List<KnaryTreeNode> children;
 *     public KnaryTreeNode(int key) {
 *         this.key = key;
 *         this.children = new ArrayList<>();
 *     }
 * }
 */
 public class Solution {
   public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
     // T: n! S: O(h)
     if(root == null || root == a || root == b) {
       return root;
     }
     //found用来mark有没有返回任意一个值
     KnaryTreeNode found = null;
    //进入这一层的recursion
     for(KnaryTreeNode child: root.children) {
       //进入recursion
       KnaryTreeNode node = lowestCommonAncestor(child, a, b);
       //没有返回值，继续走
         if(node == null) {
           continue;
         }
         //有返回值
         //1。一个返回值，found= 返回值
         if(found == null) {
           found = node;
         //2.有两个返回值，返回他们的root
         }else {
           return root;
         }
     }
     //返回这一层的结果: null或者a或者b
     return found;
   }
}
