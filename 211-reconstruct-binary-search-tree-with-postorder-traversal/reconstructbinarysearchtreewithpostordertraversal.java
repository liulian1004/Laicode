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
  public TreeNode reconstruct(int[] post) {
    // T: O(n) S: O(h)
    //代表当前层的最后一位index，即root的值
    int[] index = new int[]{post.length - 1};
    return helper( post, index, Integer.MIN_VALUE);
  }
  private TreeNode helper(int[] post, int[] index, int min) {
    //corner case
    //index已经扫描完了或者当前层的post[index[0]](root)值小于min值即不符合条件，往上return
    if(index[0] < 0 || post[index[0]] <= min) {
      return null;
    }
    TreeNode root = new TreeNode(post[index[0]]);
    //index值每一次传入root后要更新
    index[0]--;
    //每一次index和min值都会更新
    //先扫描subright tree 因为是postorder traversal, root旁边的数又很大可能是root.right
    root.right = helper(post, index, root.key);
    root.left = helper(post,index, min);
    return root;
  }
}
// my solution:
// create a in-order array, do in-order + postorder reconstruct
public TreeNode reconstruct(int[] post) {
    // Write your solution here
    if(post == null || post.length == 0) {
      return null;
    }
    int[] inOrder = new int[post.length];
    for(int i = 0 ; i < inOrder.length; i++) {
      inOrder[i] = post[i];
    }
    Arrays.sort(inOrder);
    return recon(inOrder, post);
  }
  private TreeNode recon(int[] inOrder, int[] postOrder) {
    // T: O(n) S: O(n)
    if(inOrder == null || postOrder == null || inOrder.length == 0 || postOrder.length == 0) {
      return null;
    }
    Map<Integer, Integer> map = buildMap(inOrder);
    return helper(0,inOrder.length -1, 0, postOrder.length - 1, postOrder, map);
  }
  private TreeNode helper(int inLeft, int inRight, int postLeft, int postRight, int[] postOrder, Map<Integer, Integer> map) {
    if(inLeft > inRight) {
      return null;
    }
    TreeNode root = new TreeNode(postOrder[postRight]);
    int index = map.get(postOrder[postRight]);
    int leftSubTree = index - inLeft;
    int rightSubTree = inRight - index;
    TreeNode left = helper(inLeft, index - 1, postLeft, postLeft + leftSubTree - 1, postOrder, map);
    TreeNode right = helper(index + 1, inRight, postLeft+leftSubTree,postRight-1,postOrder, map);
    root.left = left;
    root.right = right;
    return root;
  }
  private Map<Integer, Integer> buildMap(int[] inOrder) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inOrder.length; i++) {
      map.put(inOrder[i], i);
    }
    return map;
  }
}
