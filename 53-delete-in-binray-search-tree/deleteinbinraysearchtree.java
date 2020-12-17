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
  public TreeNode deleteTree(TreeNode root, int key) {
    // T: 找到key之前的部分 + findSmallest的while部分 => max： O(h); S: O(h);
    //need to declare: always replace by the smallest element that is larager than target
    if(root == null) {
      return root;
    }
    //find the key
    // no child
    // only one child
    // two children root.right.left == null(替代的节点即为root.right,右子树的最小值，不需要在往下找了)
    // two children  find the 右子树的最小值
    if(root.key == key) {
      if(root.left == null) {
          return root.right;
      } else if(root.right == null) {
        return root.left;
      } else if(root.right.left == null) {
        root.right.left = root.left;
        return root.right;
        //最后两个情况不分开写，如果合并在一起
        //在findS函数中会出现N，语句 cur = cur.left会出现PE
      } else {
        //这里注意是找右子树的最小值，传入值是root.right
        TreeNode smallest = findSmallest(root.right);
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
      }
    }
    if(root.key > key) {
      root.left = deleteTree(root.left, key);
    } else if(root.key < key ) {
      root.right = deleteTree(root.right, key);
    }
    return root;
  }

  private TreeNode findSmallest(TreeNode cur) {
    //一路从left走到底，cur为最小值，pre为cur的parent
      TreeNode prev = cur;
      cur = cur.left;
      while(cur.left != null) {
        prev = cur;
        cur = cur.left;
      }
      // cur 为最小值，pre要与cur的right child 挂钩
      //这里如果cur.right为null,也没有关系
      prev.left = cur.right;
      return cur;
  }
}
//easy Solution
//T： logn/H S: logn/H
// left == null, return right
// right == null, return left
// 找到root的右子树的最小数，把root的值替换掉，然后在通过recursion方法把那个最小的数删除
public TreeNode deleteTree(TreeNode root, int key) {
    if (root == null) return root;
        if (root.key > key) { // key < root.val check in left sub-tree
            root.left = deleteTree(root.left, key);
        } else if (root.key < key) { // key > then root.val check in right sub-tree
            root.right = deleteTree(root.right, key);
        } else { // key == root.val we found nodes need to delete
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = findLeft(root.right);
            root.right = deleteTree(root.right, root.key);
        }
        return root;
    }

    private int findLeft(TreeNode node) {
      while(node.left != null){
        node = node.left;
      }
      return node.key;
    }
