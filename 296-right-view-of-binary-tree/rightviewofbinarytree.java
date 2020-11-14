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
  public List<Integer> rightView(TreeNode root) {
    // T: O(n) S: O(n) → the last level of tree -> upper bound is n
    //scan right child, then scan left child
    //queue, right first, left second
    List<Integer> list = new ArrayList<>();
    if(root == null) {
      return list;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      TreeNode first = queue.peek();
      list.add(first.key);
      int size = queue.size();
      for(int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        if(cur.right != null) {
              queue.offer(cur.right);
        }
        if(cur.left != null) {
          queue.offer(cur.left);
        }
      }
    }
    return list;
  }
  //left view只要先traversal左边即可
  //another Solution
  private List<Integer> rightView(TreeNode root) {
	Deque<TreeNode> deque = new ArrayDeque<>();
   	List<Integer> list = new ArrayList<>();
  	deque.offerFirst(root);
  	while(!deque.isEmpty()) {
    	list.add(deque.peekLast().key);
    	int size = deque.size();
    	for(int i = 0; i < size; i++) {
        	TreeNode cur = deque.pollFirst();
        	if(cur.left != null) {
        	deque.offerLast(cur.left);
          }
          if(cur.right != null) {
          	deque.offerLast(cur.right);
          }
    }
  }
  return list;
  }
//recursion
// in order: go right, go left
//如果现在的层高比之前的high/
//这个就是新的level，把当前的root放在结构集里

private void recursion(TreeNode root, int[] level, int high, List<Integer> list) {
      if(root == null) {
        return;
    }
    if(high > level[0]) {
      list.add(root.key);
      level[0] = high;
    }
    recursion(root.right, level, high+1,list);
    recursion(root.left,level, high+1,list);
    }
}
