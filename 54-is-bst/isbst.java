public class Solution {
  public boolean isBST(TreeNode root) {
    //Time: max(height, #of node beween k1 and k2)
    //Space O(height)
    // assumpiton : no duplicated node and no value eaquals to min/max
    if (root == null) {
        return true;
      }
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  private boolean isBST(TreeNode root, int min, int max) {
    if(root == null) {
      return true;
    }
    if(root.key <= min || root.key >= max) {
      return false;
    }
    return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
  }
}

}
//follow up if Integer.min 和 Intger.MAX_VALUE在tree中
// 可以把min/max变成long, 或者TreeNode min = null || TreeNode max = null
或者

//不用min,max性质做，用ascending的性质做
tree里面有long, 并且long.min 和long.max包含在tree里面
solution：
step 1 ： do order traversal
step 2:  判断是不是升序， prev node.key vs cur node.key

public boolean isBST(TreeNode root) {
    // T: O(n) - every node is poll and offer one time
    // S: O(height)
    if(root == null) {
      return true;
    }
    TreeNode pre = null;
    Deque<TreeNode> stack = new ArrayDeque<>();
    // push the left tree from root
    pushLeft(root, stack);

    while(!stack.isEmpty()) {
      TreeNode cur = stack.pollFirst();
      if(pre != null && pre.key >= cur.key) {
        return false;
      }
      pre = cur;
      //push right-subtree from the first right element
      pushLeft(cur.right, stack);
    }
    return true;
  }
  private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
    while(root != null){
      stack.offerFirst(root);
      root = root.left;
    }
  }
//another Solution
public boolean isBST(TreeNode root) {
    // Write your solution here
    boolean[] res = new boolean[]{true};
    int[] pre = new int[]{Integer.MIN_VALUE};
    helper(root, pre, res);
    return res[0];
  }
  private void helper(TreeNode root, int[] pre, boolean[] res) {
    if(root == null) {
      return;
    }
    helper(root.left, pre, res);
    if(root.key <= pre[0]) {
      res[0] = false;
      return;
    }else {
      pre[0] = root.key;
    }
    helper(root.right, pre, res);
  }
