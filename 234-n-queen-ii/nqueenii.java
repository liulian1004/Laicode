public class Solution {
  public int totalNQueens(int n) {
    // Write your solution here
   // List<List<Integer>> list = new ArrayList<>();
    int[] count = new int[]{0};
    List<Integer> cur = new ArrayList<>();
    helper(n, count, cur);
    return count[0];
  }
  private void helper(int n, int[] count,List<Integer> cur){
    if(cur.size() == n){
      count[0]++;
      return;
    }
    for(int i = 0; i < n; i++){
      if(isValid(cur, i)){
        cur.add(i);
        helper(n, count, cur);
        cur.remove(cur.size()-1);
      }
    }
  }
  private boolean isValid(List<Integer> cur, int index){
    for(int i = 0; i < cur.size(); i++){
      int lastIndex = cur.get(i);
      if(lastIndex == index || (cur.size()- i) == Math.abs(index-lastIndex)){
        return false;
      }
    }
    return true;
  }
}
