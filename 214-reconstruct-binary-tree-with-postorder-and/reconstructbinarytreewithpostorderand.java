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
  public TreeNode reconstruct(int[] inOrder, int[] postOrder) {
    // T: O(n) S: O(n)
    if(inOrder == null || postOrder == null || inOrder.length == 0 || postOrder.length == 0) {
      return null;
    }
    Map<Integer, Integer> map = buildMap(inOrder);
    return helper(0,inOrder.length -1, 0, postOrder.length - 1, postOrder, map);
  }
  private TreeNode helper(int inLeft, int inRight, int postLeft, int postRight, int[] postOrder, Map<Integer, Integer> map) {
    if(inLeft > inRight) {
      return null;
    }
    TreeNode root = new TreeNode(postOrder[postRight]);
    int index = map.get(postOrder[postRight]);
    int leftSubTree = index - inLeft;
    int rightSubTree = inRight - index;
    TreeNode left = helper(inLeft, index - 1, postLeft, postLeft + leftSubTree - 1, postOrder, map);
    TreeNode right = helper(index + 1, inRight, postLeft+leftSubTree,postRight-1,postOrder, map);
    root.left = left;
    root.right = right;
    return root;
  }
  private Map<Integer, Integer> buildMap(int[] inOrder) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inOrder.length; i++) {
      map.put(inOrder[i], i);
    }
    return map;
  }
}
