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
  public List<Integer> inOrder(TreeNode root) {
    // T: O(n) S:O(h),最多为左边一条子树
    List<Integer> res = new ArrayList<>();
    if(root == null) {
      return res;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while(cur !=null || !stack.isEmpty()) {
      //一路往左走
        if(cur != null) {
          stack.offerFirst(cur);
          cur = cur.left;
      //碰到null, poll出stack的peek, 然后走cur的right tree
        } else {
          //cur == null
          cur = stack.pollFirst();
          res.add(cur.key);
          cur = cur.right;
        }
    }
    return res;
  }
}
// my Solution
public List<Integer> inOrder(TreeNode root) {
    // T： O（n) S: O(1)
    List<Integer> list = new ArrayList<>();
    if(root == null) {
      return list;
    }
    Deque<TreeNode> stack =new ArrayDeque<>();
    stack.offerFirst(root);
    while(!stack.isEmpty()) {
        if(root.left != null) {
        stack.offerFirst(root.left);
        root = root.left;
      }else {
        TreeNode cur = stack.pollFirst();
        list.add(cur.key);
        if(cur.right != null) {
          stack.offerFirst(cur.right);
          root = cur.right;
        }
      }
    }
    return list;
  }
