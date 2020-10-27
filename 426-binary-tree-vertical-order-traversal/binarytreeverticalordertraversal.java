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
  public List<Integer> verticalOrder(TreeNode root) {
    // Write your solution here
    List<Node> list = new ArrayList<>();
    helper(root,0,0,list);
    Collections.sort(list, new MyCompare());
    List<Integer> res = new ArrayList<>();
    for(Node i: list){
      res.add(i.n.key);
    }
    return res;
  }
  private void helper(TreeNode root, int position, int level, List<Node> list){
    if(root == null){
      return;
    }
    list.add(new Node(root, position,level));
    helper(root.left, position-1,level+1, list);
    helper(root.right, position+1,level+1, list);
  }
  private static class Node{
      TreeNode n;
      int i;
      int l;
      Node(TreeNode n, int i, int l){
        this.n = n;
        this.i = i;
        this.l = l;
      }
  }
  private static class MyCompare implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2){
      if(n1.i == n2.i && n1.l == n2.l){
        return 0;
      }
      if(n1.i < n2.i || n1.i == n2.i && n1.l < n2.l){
        return -1;
      }
      return 1;
    }
  }
}
