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
  public int largestSmaller(TreeNode root, int target) {
    // T: O(h) - worst case O(n)-糖葫芦； best case o(logn) - 满二叉树
    //S： O(1)
    //先确保root < target
    //再在满足条件的root里一路向右找，找到root == null之前的节点数
    //即左半边里最右的node
    if(root == null) {
      return Integer.MIN_VALUE;
    }
    //原始值为最小值
    int result = Integer.MIN_VALUE;
    while(root != null) {
      // > target, 往左找
      if(root.key >= target) {
        root = root.left;
      // < target 跟新reult，往右找
      }else{
        result = root.key;
        root = root.right;
      }
    }
    return result;
  }

  //recusrion
  //T: O(n)
  // S: O(h)
  int[] distance = new int[]{Integer.MAX_VALUE};
	helper(root, target, distance);
	if(distance[0] == Integer.MAX_VALUE) {
      return Integer.MIN_VALUE;
    }
    return target - distance[0];

    }
private void helper(TreeNode root, int target, int[] distance) {
	if(root == null) {
	return;
    }
    helper(root.left, target, distance);
    if(root.key < target) {
    distance[0] = Math.min(distance[0], target - root.key);
    }
    helper(root.right, target, distance);
    }
}
