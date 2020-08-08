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
  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    if(root == null) {
      return res;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    TreeNode pre = null;
    while(!stack.isEmpty()) {
      TreeNode cur = stack.peekFirst();
      if(pre == null || cur == pre.left || cur == pre.right) {
        if(cur.left != null) {
          stack.offerFirst(cur.left);
        } else if(cur.right != null) {
          stack.offerFirst(cur.right);
        } else {
          stack.pollFirst();
          res.add(cur.key);
        }
      } else if(pre == cur.right || pre == cur.left && cur.right == null) {
        stack.pollFirst();
        res.add(cur.key);
      } else {
        //cur = cur.right; 这里cur指向不能变，因为下面cur要和pre互换
        //cur的指向不能变
        stack.offerFirst(cur.right);
      }
      pre = cur;
    }
    return res;
  }
  //my Solution
  //revsese : root rightSubTree ,leftSubTree
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null ) {
      return list;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    while(!stack.isEmpty()) {
      TreeNode cur = stack.pollFirst();
      list.add(cur.key);
      if(cur.left != null) {
        stack.offerFirst(cur.left);
      }
      if(cur.right != null ) {
        stack.offerFirst(cur.right);
      }
    }
    Collections.reverse(list);
    return list;
  }
}
// my solution
public List<Integer> postOrder(TreeNode root) {
   List<Integer> list = new ArrayList<>();
 if(root == null) {
   return list;
 }
 Deque<TreeNode> temp = new ArrayDeque<>();
 TreeNode cur = root;
 while(cur != null) {
   while(cur != null) {
     list.add(cur.key);
     temp.offerFirst(cur);
     cur = cur.right;
   }
   while(cur == null && !temp.isEmpty()) {
   cur = temp.pollFirst();
   cur = cur.left;
   }
 }
 List<Integer> res = new ArrayList<>();
 for(int i = list.size()-1; i>=0; i--) {
   res.add(list.get(i));
 }
 return res;

}
