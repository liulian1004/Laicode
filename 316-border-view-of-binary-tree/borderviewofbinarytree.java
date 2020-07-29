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
  //T: O(n); S: O(height)
  //in order顺序的时候加left and leaf
  // post order的时候加right
  public List<Integer> borderView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
	if(root == null){
		return result;
	}
	result.add(root.key);
	dfsTraverse(root.left, true, false, result); //走了左半边树
	dfsTraverse(root.right, false, true, result); // 走了右半边树
	return result;
}
private void dfsTraverse(TreeNode root, boolean leftMost, boolean rightMost, List<Integer> result){
	if(root == null){
		return;
	}
  //left + leaves
  //上一个node的左，右子树状态
	if(leftMost || root.left == null && root.right == null){
		result.add(root.key);
	}
  //if root有right node， 对root.left来说，root.left不是最左边的节点，为false
	dfsTraverse(root.left, leftMost, (root.right == null? rightMost:false), result);
	dfsTraverse(root.right, (root.left == null ? leftMost : false), rightMost, result);
  //right, not leftMost, and not leaves
  //这个条件需要上面的条件绝对相反
  //最左边且非叶子节点
	if(rightMost && （!leftMost && (root.left != null || root.right != null))）{
		result.add(root.key);
	}
}
}
