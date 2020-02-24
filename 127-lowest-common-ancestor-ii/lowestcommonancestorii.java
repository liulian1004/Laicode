/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // 先找到one 和two 的落差
    // 让他们走到同一level,找共同的parenet： one.parent = two.parent
   int l1 = findLength(one);
   int l2 = findLength(two);
   if(l1 >= l2) {
     return merge(one, two, l1- l2);
   }
    return merge(two, one, l2- l1);
  }
  private int findLength(TreeNodeP node){
    int length = 0;
    //trick:这里要先node++，因为是返回的当前层的length情况
    //nodd++写在后面是返回后面一层的length情况
    while(node != null) {
      length++;
      node = node.parent;
    }
    return length;
  }
  private TreeNodeP merge(TreeNodeP longer, TreeNodeP shorter, int differ) {
    while(differ > 0) {
      differ--;
      longer = longer.parent;
    }
    while(longer!= shorter) {
      longer = longer.parent;
      shorter = shorter.parent;
    }
    return longer;
  }
}
