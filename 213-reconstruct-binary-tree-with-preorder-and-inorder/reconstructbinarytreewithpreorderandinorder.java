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
  public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
    // find the root from preOrder
    //find the leftChild and rightChild from inOrder
    //T：O(n); S：O(h) + O(n)

    //Map需要记录root在inOrder的index,用于找到新的left和right
    Map<Integer, Integer> inO = builder(inOrder);
    return helper(inO, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);
  }
  private TreeNode helper(Map<Integer, Integer> inO, int[] preOrder, int inLeft, int inRight, int preLeft, int preRight) {
    //走到叶子节点的下面
    if(inLeft > inRight) {
      return null;
    }
    //先找到root
    TreeNode root = new TreeNode(preOrder[preLeft]);
    //找到root所对应在inOrder里面的index
    int indexRoot = inO.get(root.key);
    //对inOrder, preOrder计算新的left，right边界
    // (indexRoot - inLeft) left child 的size
    // inRight - indexRoot right child的size
    root.left = helper(inO, preOrder, inLeft, indexRoot - 1, preLeft + 1, preLeft + (indexRoot - inLeft));
    root.right = helper(inO, preOrder, indexRoot + 1, inRight, preRight - (inRight - indexRoot) + 1, preRight);
    return root;
  }
  private Map<Integer, Integer> builder(int[] inOrder) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inOrder.length; i++) {
      map.put(inOrder[i],i);
    }
    return map;
  }
}
