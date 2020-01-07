public class Solution {
  public List<Integer> getRange(TreeNode root, int min, int max) {
    // Time： O(height + #of nodes in the range of{min,max}) ;
    //Space: O(h);
    List<Integer> list = new ArrayList<>();
    getRange(root, min, max, list);
    return list;
  }
  public void getRange(TreeNode root, int min, int max, List<Integer> list) {
    if(root == null) {
      return;
    }
    if(root.key > min) {
       getRange(root.left, min, max, list);
    }
    if((root.key >= min) && (root.key <= max)) {
        list.add(root.key);
    }
    if(root.key < max) {
      getRange(root.right, min, max, list);
    }


  }
}
