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
    return list.toArray(new String[list.size()]);
  }
  private void helper(TreeNode root, List<String> list, StringBuilder sb) {
      if(root == null) {
          return;
      }
      if(root != null && root.left == null && root.right == null){
          sb.append(root.key);
          list.add(sb.toString());
          //sb.deleteCharAt(sb.length()-1);
          return;
      }
      sb.append(root.key);
      sb.append("->");
      int len = sb.length();
      helper(root.left, list, sb);
      sb.delete(len, sb.length());
      helper(root.right, list,sb);
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
