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
  public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
    // Write your solution here
    Set<KnaryTreeNode> set = new HashSet<>(nodes);
    return lowestCommonAncestor(root, set);
  }
  private KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, Set<KnaryTreeNode> set) {
    if(root == null || set.contains(root)) {
      return root;
    }
    KnaryTreeNode result = null;
    for(KnaryTreeNode child: root.children) {
      KnaryTreeNode node = lowestCommonAncestor(child, set);
      if(node == null) {
        continue;
      }
      if(result == null) {
        result = node;
      } else {
        return root;
      }
    }
    return result;
  }
}
