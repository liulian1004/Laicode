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
	dfsTraverse(root.left, leftMost, (root.right == null? rightMost:false), result);
	dfsTraverse(root.right, (root.left == null ? leftMost : false), rightMost, result);
  //right, not leftMost, and not leaves
  //这个条件需要上面的条件绝对相反
	if(rightMost && !leftMost && (root.left != null || root.right != null)){
		result.add(root.key);
	}
}
}
