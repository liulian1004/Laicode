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
  public String[] binaryTreePaths(TreeNode root) {
    // T: 2^n * n S: O(n)
    List<String> list = new ArrayList<>();
    if(root == null) {
      return list.toArray(new String[0]);
    }
      StringBuilder cur = new StringBuilder();
      helper(root, list, cur);
    return list.toArray(new String[0]);
  }
  private void helper(TreeNode root, List<String> list, StringBuilder cur) {
    //在最后一层加入list
    if(root == null) {
      return;
    }
    //没进一层如果cur不是空就加符号
    if (cur.length()>0) {
      cur.append("->");
    }
    //吃
    cur.append(root.key);
    int len = cur.length();
    if(root.left == null && root.right == null) {
        list.add(cur.toString());
        return;
      }
    // helper(root.left, list, new StringBuilder(cur));
    // helper(root.right, list, new StringBuilder(cur));
    //len是append之前的len
    helper(root.left, list, cur);
    //吐
    cur.delete(len, cur.length());
    helper(root.right, list, cur);
    cur.delete(len, cur.length());
  }
}

//follow up  return the sum of Path
private  List<Integer> binaryTreePaths(TreeNode root) {
         List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        int sum = 0;
        helper(root, list, sum);
        return list;
     }
     private void helper(TreeNode root, List<Integer> list, int sum) {
         if(root == null) {
             return;
         }
         //先把这一层的root加入到sum中
         sum += root.key;
         System.out.println(sum);
         if(root.left == null && root.right == null) {
             list.add(sum);
             return;
         }
         //这里sum不需要吐，因为return回来的sum值没有边
         if(root.left != null) {
             helper(root.left, list, sum);
         }
         if(root.right != null) {
             helper(root.right, list, sum);
         }
     }
