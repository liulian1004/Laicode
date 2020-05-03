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
  public boolean isCousin(TreeNode root, TreeNode a, TreeNode b) {
    // T: O(n + list.length) S: O(list.length)
    // A: no duplicated elements
    // bst + map(node, root)
    if(root == null) {
         return false;
       }
       Queue<TreeNode> queue = new ArrayDeque<>();
       queue.offer(root);
       while(!queue.isEmpty()) {
         TreeNode pa = null;
         TreeNode pb = null;
         int size = queue.size();
         for(int i = 0; i < size; i++) {
             TreeNode cur = queue.poll();
             if(cur.left != null) {
               queue.offer(cur.left);
               if(cur.left.key == a) {
                 pa = cur;
               } else if(cur.left.key == b) {
                 pb = cur;
               }
             }
             if(cur.right != null) {
               queue.offer(cur.right);
               if(cur.right.key == a) {
                 pa = cur;
               }else if(cur.right.key == b) {
                 pb = cur;
               }
             }
         }
           if(pa != null && pb != null) {
           return pa.key != pb.key;
           }
           if(pa != null || pb != null) {
           return false;
           }
       }
       return false;
     } 

}
//another solution DFS
private boolean isCousin(TreeNode root, int a, int b) {
       List<Integer> list = new ArrayList<>();
       if (root == null) {
           return false;
       }
       helper(root, 0, null, a, b, list);
       if(list.size() == 4 && list.get(0) == list.get(2)) {
           return list.get(1) != list.get(3) ;
       }
       return false;
  }
  private void helper(TreeNode root, int level, TreeNode parent, int a, int b, List<Integer> list) {
       if(root == null || list.size() == 4) {
           return;
       }

       if(root.key == a) {
           list.add(level);
           list.add(parent.key);
       }
      if(root.key == b) {
          list.add(level);
          list.add(parent.key);
      }
       helper(root.left, level+1, root, a, b, list);
       helper(root.right, level+1, root, a, b, list);

  }
