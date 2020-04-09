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
  public List<Integer> topView(TreeNode root) {
    //T: O(n) ;S O(map.size + stack.size) == O(n) --> complete tree
  //stack.upper bound the last level of complete tree ~~O(n)
  //size of map : O(n)
    // create a pair class to keep col and treenode
    // map<col, treenode>
    // max col , min col to traversal the map and put the first element of the list into the result

    List<Integer> list = new ArrayList<>();
    if(root == null) {
      return list;
    }
    Map<Integer, List<Integer>> map = new HashMap<>();
    Deque<Pair> stack = new ArrayDeque<>();
    int min = 0;
    int max = 0;
    stack.offerFirst(new Pair(0,root));
    map.put(0, new ArrayList<>());
    map.get(0).add(root.key);
    while(!stack.isEmpty()) {
      int size = stack.size();
      while(size > 0) {
        int index = stack.peekFirst().col;
        TreeNode cur = stack.pollFirst().node;
        if(cur.left != null) {
          int col = index -1;
          min = Math.min(min, col);
          if(!map.containsKey(col)) {
            map.put(col, new ArrayList<>());
          }
          map.get(col).add(cur.left.key);
          stack.offerFirst(new Pair(col ,cur.left));
        }
        if(cur.right != null) {
          int col = index + 1;
          max = Math.max(max, col);
          if(!map.containsKey(col)) {
            map.put(col, new ArrayList<>());
          }
          map.get(col).add(cur.right.key);
          stack.offerFirst(new Pair(col, cur.right));
        }
        size--;
      }
    }
    for(int i = min; i <= max; i++) {
      int first = map.get(i).get(0);
      list.add(first);
    }
    return list;
  }
  static class Pair{
      int col;
      TreeNode node;
      Pair(int col, TreeNode node){
        this.col = col;
        this.node = node;
      }
  }
}
