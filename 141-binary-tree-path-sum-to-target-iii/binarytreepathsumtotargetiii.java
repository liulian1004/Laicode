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
    // set : keep histroiral prefix sum,这里用set是去重用
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
    return leftTree || rightTree;
  }
}
//follow up
// how about node to node?
// post -order
//create the class with set and boolean
// case 1: root == null == > return Result
//recusion rule
//case1 : if root + prefixsum of left tree/right tree == target == > return res.true;
//case2: if root + prefixsum of lefttree + prefixsum of right tree == tareget == > return res.true
//case3: not qualified, prefixsum of left tree+ prefixsum of right tree + root.val

private boolean solution(TreeNode node, final int target) {
        return Ptp(node, target).res;
   }
   private Result Ptp(TreeNode node, final int target) {
        Result result = new Result();
        if (node == null) {
            return result;
        }
        Result left = Ptp(node.left, target);
        if (left.res) {
            return left;
        }
        Result right = Ptp(node.right, target);
        if (right.res) {
            return right;
        }
        int curTarget = target - node.key;
        // Check one side
        if (left.set.contains(curTarget) || right.set.contains(curTarget)) {
            result.res = true;
            return result;
        }
        Set<Integer> set1 = left.set.size() > right.set.size() ? right.set : left.set; //短的set
        Set<Integer> set2 = left.set.size() > right.set.size() ? left.set : right.set;//长的set
        for (Integer i : set1) {
            int cur = curTarget - i;
            if (set2.contains(cur)) {
                result.res = true;
                return result;
            }
        }
        // no candidate up to here.
       result.set.add(node.key);
        for (Integer i : left.set) {
            result.set.add(node.key + i);
        }
       for (Integer i : right.set) {
           result.set.add(node.key + i);
       }
       return result;
   }

   private static class Result {
        final Set<Integer> set = new HashSet<>();
        boolean res = false;
   }
//follow up : print all valid path
private List<List<Integer>> target(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        List<int[]> prefixSum = new ArrayList<>();
        prefixSum.add(new int[]{0,-1});
        tra(root,res, cur, 0, 0,prefixSum, target);
        return res;
   }
   private void  tra(TreeNode root, List<List<Integer>> list, List<Integer> cur, int level, int sum,List<int[]> prefixSum, int target) {
        if(root == null) {
            return;
        }
        sum += root.key;
        for(int[] pair: prefixSum) {
            if(pair[0] == (sum - target)) {
                //index要多加一位，因为这里查的时候list还没有放入目前的root，所有cur list少一位
                list.add(getList(cur, pair[1]+1, root.key));
            }
        }
        prefixSum.add(new int[]{sum,level});
        cur.add(root.key);
        tra(root.left, list, cur, level+1,sum,prefixSum,target);
       tra(root.right, list, cur, level+1,sum,prefixSum,target);
        prefixSum.remove(prefixSum.size()-1);
        cur.remove(cur.size()-1);
   }
   private List<Integer> getList(List<Integer> list,int start, int cur) {
        List<Integer> res = new ArrayList<>();
        for(int i = start; i < list.size(); i++) {
            res.add(list.get(i));
        }
       res.add(cur);
       return res;
   }
