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
 public int countNodes(TreeNode root) {
        //T： （logn）^ 2 == > O(h) S: O(1)
        if(root == null) {
            return 0;
        }
        if(root.left == null) {
          return 1;
        }
        if(root.right == null) {
            return 2;
        }
        int h = findH(root);
        int left = 1;
        //最后一层最多有几个node， index从0开始
        int right = (int)(Math.pow(2,h)-1);
        while(left <= right) {
            int m = left + (right - left)/2;
            if(exist(m,h,root)) {
                left = m +1;
            }else  {
                right = m -1;
            }
        }
        return (int)(Math.pow(2,h)-1)+ left;
    }
    private int findH(TreeNode root) {
        //从0开始
        int h = 0;
        while(root.left != null) {
            root = root.left;
            h++;
        }
        return h;
    }
    private boolean exist(int index, int h, TreeNode root) {
        int left  = 0;
        int right = (int)(Math.pow(2,h)-1);
        for(int i = 0; i < h; i++) {
            int m = left + (right - left)/2;
            if(index <= m) {
                //从左子树走
                root = root.left;
                right = m;
            }else{
                //从右子树走
                root = root.right;
                left = m +1;
            }
        }

        //走到底，即node== index; 找到了想要看的index
        return root != null;
    }
}
