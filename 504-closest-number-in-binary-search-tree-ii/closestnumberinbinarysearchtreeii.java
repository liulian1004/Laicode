public class Solution {
  public int[] closestKValues(TreeNode root, double target, int k) {
    // inorder travesel because of BST + sliding windowns
    // T: O(n) S: O(k)
    Deque<Integer> deque = new ArrayDeque<>();
    inOrderTraversal(root, target, k, deque);
    //in case k > root.size
    //注意array的size不一定是k
    int size = deque.size();
    int[] result = new int[size];
    for(int i = 0; i < size; i++) {
      result[i] = deque.pollFirst();
    }
    return result;
  }
  private void inOrderTraversal(TreeNode root, double target, int k, Deque<Integer> deque) {
    if(root == null) {
      return;
    }
    inOrderTraversal(root.left, target, k, deque);
    if(deque.size() < k){
      deque.offerLast(root.key);
      //如果后面加进去的数更靠近target，淘汰的一定是最开始加进去的数
    } else if (Math.abs(deque.peekFirst() - target) > Math.abs(root.key - target)) {
      deque.pollFirst(); //T: O(1)
      deque.offerLast(root.key);
      //不满足条件 直接返回 后面的nood也不需要traversal了
    } else {
      return;
    }
    inOrderTraversal(root.right, target, k, deque);
  }


}
//another solutoin - Interative-- better
public int[] closestKValues(TreeNode root, double target, int k) {
   // T: O(n)
   //S: O(height + k)
   if(root == null) {
     return new int[]{};
  }
  //deque比list好，因为poll.peek,offer的时间复杂度为O（1）
  Deque<Integer> buffer = new ArrayDeque<>();
  Deque<TreeNode> stack = new ArrayDeque<>();
  pushLeft(root, stack);
  while(!stack.isEmpty()) {
     TreeNode cur = stack.pollFirst();
     if(buffer.size() < k) {
       buffer.addLast(cur.key);
    }else if(Math.abs(buffer.peekFirst() - target) <= Math.abs(cur.key - target)) {
      break;
    }else{
       buffer.pollFirst();
       buffer.offerLast(cur.key);
    }
    pushLeft(cur.right, stack);
    }
  return toArray(buffer);
}
private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
 while(root != null) {
   stack.offerFirst(root);
   root = root.left;
  }
}
private int[] toArray(Deque<Integer> buffer) {
 int[] res = new int[buffer.size()];
 //这里必须是res的size，不能是buffer的size
 //因为buffer的size一直在变
 for(int i = 0; i < res.length; i++) {
   res[i] = buffer.pollFirst();
 }
return res;
}
