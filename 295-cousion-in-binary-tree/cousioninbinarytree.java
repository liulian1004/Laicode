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
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while(!queue.isEmpty()) {
      TreeNode pa = null;
      TreeNode pb = null;
      int size = queue.size();
      for(int i = size; i > 0; i--) {
        TreeNode cur = queue.poll();
        if(cur.left != null) {
          if(cur.left == a) {
              pa = cur;
          }else if(cur.left == b)  {
            pb = cur;
          }
          queue.offer(cur.left);
        }
        if(cur.right != null) {
          if(cur.right == a) {
              pa = cur;
          }else if(cur.right == b)  {
            pb = cur;
          }
          queue.offer(cur.right);
        }
      }
      if(pa != null && pb != null) {
        return pa  != pb;
      } else if(pa != null || pb!= null) {
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
