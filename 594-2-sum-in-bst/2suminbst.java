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
  public boolean existSumBST(TreeNode root, int target) {
    //T: O(n); S: O(height)
    // 用pushLeft 和 pushright来模拟 leftbound and  rightbound
    //用stack.offerFirst/pollFirst来模拟left++， right++
    //left++ pushleft(cur.right); right-- pushrigh(cur.left)
    if(root == null){
      return false;
    }
    Deque<TreeNode> leftStack = new ArrayDeque<>();
    Deque<TreeNode> rightStack = new ArrayDeque<>();
    TreeNode leftPointer = goLeft(root,leftStack);
    TreeNode rightPointer = goRight(root,rightStack);
    while(leftPointer != rightPointer){
      if(leftPointer.key + rightPointer.key == target){
        return true;
      }else if(leftPointer.key + rightPointer.key < target){
        leftPointer = goLeft(leftPointer.right,leftStack);
      }else{
        rightPointer = goRight(rightPointer.left, rightStack);
      }
    }
    return false;
  }
  private TreeNode goLeft(TreeNode root, Deque<TreeNode> stack){
    if(root == null && !stack.isEmpty()){
      return stack.pollFirst();
    }
    while(root != null){
          stack.offerFirst(root);
          root = root.left;
    }
    return stack.pollFirst();
  }
  private TreeNode goRight(TreeNode root, Deque<TreeNode> stack){
    if(root == null && !stack.isEmpty()){
      return stack.pollFirst();
    }
    while(root != null){
          stack.offerFirst(root);
          root = root.right;
    }
    return stack.pollFirst();
  }
  //recrusion ， similiar to the map method
  public boolean existSumBST(TreeNode root, int target) {
      // T: O(n) S: O(n)
      //所有的tree都可以用这个方法
      if(root == null) {
        return false;
      }
      Set<Integer> set = new HashSet<>();
      return helper(root, target, set);
    }
    private boolean helper(TreeNode root, int target, Set<Integer> set) {
        if(root == null) {
        return false;
      }
      if(set.contains(root.key)) {
        return true;
      }
      set.add(target - root.key);
      return helper(root.left, set, target) || helper(root.right, set, target);
    }
}
//follow up: 3 sum
public boolean Threesum(TreeNode root, int target){
       if(root == null){
           return false;
       }
       Deque<TreeNode> leftHalf = new ArrayDeque<>();
       Deque<TreeNode> rightHalf = new ArrayDeque<>();
       TreeNode pointer = goLeft(root,leftHalf);
       //righthalf多了一个root，需要poll出去
       // the size of lefthalf+righthalf 用于验证while loop
       goRight(root,rightHalf);
       while(!leftHalf.isEmpty() || !rightHalf.isEmpty()){
           int t = target - pointer.key;
           //deep copy the left half
           Deque<TreeNode> leftStack= deepCopy(leftHalf);
           Deque<TreeNode> rightStack = new ArrayDeque<>();
           TreeNode leftPointer = goLeft(pointer.right,leftStack);
           //重新计算rightstack和right pointer
           TreeNode rightPointer = goRight(root,rightStack);
           //right pointer 和 left pointer重合，return
           if(leftPointer == rightPointer){
               break;
           }
           if(twoSum(root,leftStack,rightStack,rightPointer,leftPointer,t)) {
               return true;
           }
           //指针移动到一个pointer
           pointer = goLeft(pointer.right,leftHalf);

       }
       return false;
   }
   public boolean twoSum(TreeNode root,  Deque<TreeNode> leftStack, Deque<TreeNode> rightStack, TreeNode rightPointer, TreeNode leftPointer,int target) {
       // Write your solution here
       while(leftPointer != rightPointer){
           if(leftPointer.key + rightPointer.key == target){
               return true;
           }else if(leftPointer.key + rightPointer.key < target){
               leftPointer = goLeft(leftPointer.right,leftStack);
           }else{
               rightPointer = goRight(rightPointer.left, rightStack);
           }
       }
       return false;
   }

   private TreeNode goLeft(TreeNode root, Deque<TreeNode> stack){
       if(root == null && !stack.isEmpty()){
           return stack.pollFirst();
       }
       while(root != null){
           stack.offerFirst(root);
           root = root.left;
       }
       return stack.pollFirst();
   }
   private TreeNode goRight(TreeNode root, Deque<TreeNode> stack){
       if(root == null && !stack.isEmpty()){
           return stack.pollFirst();
       }
       while(root != null){
           stack.offerFirst(root);
           root = root.right;
       }
       return stack.pollFirst();
   }
   private Deque<TreeNode> deepCopy(Deque<TreeNode> stack){
       Deque<TreeNode> temp = new ArrayDeque<>();
       Deque<TreeNode> res = new ArrayDeque<>();
       //interator，顺序相反，需要一个temp来过度
       for(TreeNode i: stack){
           temp.offerFirst(i);
       }
       while(!temp.isEmpty()){
           res.offerFirst(temp.pollFirst());
       }
       return  res;
   }
