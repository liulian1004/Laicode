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
  public boolean exist(TreeNode root, int target) {
    // total prefix sum = target - prefix_sum --> 在set里面
    // set : keep histroiral prefix sum
    //T: O(n); S : O(1)
    if(root == null) {
      return false;
    }
    Set<Integer> prefixSums = new HashSet<>();
    //prefixsum初始化，in case第一个数就是target
    prefixSums.add(0);
    int sum = 0;
    return helper(root, target,sum, prefixSums);
  }
  private boolean helper(TreeNode root, int target, int sum, Set<Integer> prefixSums) {
    //from up to down
    //base case
    //先把root放进去sum里
    //primitive type 不需要吃吐，因为每一层的sum都不会跟新
    //如果返回到上一层，sum还是那个上一层的sum
  if(root == null) {
    return false;
  }
   sum += root.key;
    //判断target是否在里面
   if(prefixSums.contains(sum - target)) { // T: O(1);
     return true;
   }
   //recursion
   //吃
   boolean needRemove = prefixSums.add(sum);
   //先判断是不是为空，然后走下一层
   boolean leftTree = helper(root.left, target, sum, prefixSums);
   boolean rightTree = helper(root.right, target, sum, prefixSums);
   //吐
   if(needRemove) {
     prefixSums.remove(sum);
   }
    return leftTree == true? leftTree : rightTree;;
  }
}
