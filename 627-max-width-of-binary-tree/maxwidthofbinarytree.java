public class Solution {
  public int maxWidthOfBinaryTree(TreeNode root) {
    // T: O(n) S; O(n)
    if(root == null) {
      return 0;
    }
    List<TreeNode> list = new LinkedList<>();
    list.add(root);
    int max = 0;
    while(list.size() > 0) {
      int size = list.size();
      max = Math.max(size, max);
      for(int i = 0; i < size; i++) {
        TreeNode cur = list.remove(0);
        if(cur == null) {
         list.add(null);
         list.add(null);
        } else{
          list.add(cur.left);
          list.add(cur.right);
        }
      }
      while(list.size() > 0 && list.get(0) == null) {
        list.remove(0);
      }
      while( list.size() > 0 && list.get(list.size()-1) == null) {
        list.remove(list.size()-1);
      }
    }
    return max;
  }
}
