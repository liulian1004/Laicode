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
  public List<Integer> zigZag(TreeNode root) {
    // cur layer alwasy store the nodes from left to right
    //if pollFirst, offerlast(left, right)
    // if pollLast, offerfirst(right, left)
    //each level diff
//    deque    first            last
//
// 0		          3                     pollLast(), offerFirst(right，left)
// 1             2 3                   pollFirst(), offerLast(left, right)
// 2   	         4  5 0                   pollLast(), offerFirst(right，left)
// 3             7  8 5 3              pollFirst(), offerLast(left,right)

    //T： O(n); S: O(n)
    List<Integer> result = new ArrayList<>();
    if(root == null) {
      return result;
    }

    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.offerFirst(root);
    //lay = 1 是奇数， layer 0 是偶数
    //从roof层开始，是0层，偶数
    //刚开始进外层while loop是从level 0层开始
    int layer = 0;
    while(!deque.isEmpty()) {
      int size = deque.size();
      for(int i = size; i > 0; i--) {
          if(layer == 1) {
            TreeNode cur = deque.pollFirst();
            result.add(cur.key);
            if(cur.left != null) {
              deque.offerLast(cur.left);
            }
            if(cur.right != null) {
              deque.offerLast(cur.right);
            }
          }else {
            TreeNode cur = deque.pollLast();
            result.add(cur.key);
            if(cur.right != null) {
              deque.offerFirst(cur.right);
            }
            if(cur. left != null) {
              deque.offerFirst(cur.left);
            }
          }
      }
      layer = 1 - layer;
  }
  return result;
}
}
