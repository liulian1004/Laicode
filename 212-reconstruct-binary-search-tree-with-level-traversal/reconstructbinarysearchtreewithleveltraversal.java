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
   public TreeNode reconstruct(int[] level) {
     // Write your solution here
     // corner cases:
     if (level == null || level.length == 0) {
       return null;
     }
     int index = 0;
     Queue<Wrapper> queue = new LinkedList<>();
     TreeNode root = new TreeNode(level[index++]);
     queue.offer(new Wrapper(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
     while (index < level.length) {
       Wrapper cur = queue.poll();
       // if there is any node in the array we can append to the left child of current tree node
       if (index < level.length && level[index] < cur.node.key && level[index] > cur.min) {
         TreeNode left = new TreeNode(level[index++]);
         cur.node.left = left;
         queue.offer(new Wrapper(left, cur.min, cur.node.key));
       }
       // if there is any node in the array we can append to the right child of current tree node
       if (index < level.length && level[index] > cur.node.key && level[index] < cur.max) {
         TreeNode right = new TreeNode(level[index++]);
         cur.node.right = right;
         queue.offer(new Wrapper(right, cur.node.key, cur.max));
       }
     }
     return root;
   }
   private class Wrapper {
     TreeNode node;
     int min;
     int max;
     public Wrapper(TreeNode node, int min, int max) {
       this.node = node;
       this.min = min;
       this.max = max;
     }
   }
 }
