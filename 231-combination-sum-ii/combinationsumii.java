public class Solution {
  public List<List<Integer>> combinationSum2(int[] num, int target) {
        // T：O(nlogn + n^2) S: O(n)
        //base case the sum of cur == target || index = num.length
        //sort the collections first to for the hashset(avoid duplicated res)
    List<List<Integer>> list = new ArrayList<>();
    if(num == null || num.length == 0) {
      return list;
    }
    Arrays.sort(num);
    List<Integer> cur = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    helper(num, target, list, cur, set, 0);
    return list;
  }
  private void helper(int[] num, int target, List<List<Integer>> list, List<Integer> cur, Set<List<Integer>> set, int index) {
    int sum = getSum(cur);
    if(sum == target && set.add(new ArrayList<>(cur)) ) {
      list.add(new ArrayList<>(new ArrayList<>(cur)));
      return;
    }
    if(index == num.length) {
      return;
    }
    cur.add(num[index]);
    helper(num, target, list, cur, set, index+1);
    cur.remove(cur.size()-1);
    helper(num, target, list, cur, set, index+1);
  }
  private int getSum(List<Integer> cur) {
    int sum = 0;
    for(int i: cur){
      sum += i;
    }
    return sum;
  }
}
