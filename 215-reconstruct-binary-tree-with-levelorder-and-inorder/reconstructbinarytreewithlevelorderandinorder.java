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
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
    // step 1: 找到root
    //step2: find the subleft tree and subright tree by using recusivng way
    //T: O(n^2); S: O(n^2)
    Map<Integer, Integer> inMap = mapBuilder(inOrder); //O(n)
    List<Integer> levelList = listBuilder(levelOrder); //O(n)
    return helper(inMap, levelList);
  }
  // T: O(n^2) S: O(n^2)
  //worse case : 一边倒
  //T： n + n -1 + n-2+...1 = n^2
  //S: n + n -1 + n-2+...1 = n^2
  private TreeNode helper(Map<Integer, Integer> inMap, List<Integer> levelList) {
    if(levelList.isEmpty()) {
      return null;
    }
    //find root and remove from level list
    TreeNode root = new TreeNode(level.get(0));
    int rootIndex = inMap.get(root.key);
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    //find lefttree and righttree
    for(int num : levelList) {
      //if index smaller than root index, it's left tree
      if(inMap.get(num) < rootIndex) {
        left.add(num);
      } else if(inMap.get(i) > rootIndex) {
        right.add(num);
      }
    }
    //do the recusrsion by subleft-tree and subright tree
    root.left = helper(inMap, left);
    root.right = helper(inMap,right);
    return root;
  }
  private Map<Integer, Integer> mapBuilder(int[] inOrder) {
    Map<Integer, Integer> inMap = new HashMap<>();
    for(int i = 0; i < inOrder.length; i++) {
      inMap.put(inOrder[i],i);
    }
    return inMap;
  }
  private List<Integer> listBuilder(int[] levelOrder) {
    List<Integer> levelList = new ArrayList<>();
    for(int num: levelOrder) {
      levelList.add(num);
    }
    return levelList;
  }

}
