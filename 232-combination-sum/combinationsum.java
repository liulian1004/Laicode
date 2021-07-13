public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    // T: length of candiates^h S: o(h) --> the longest length of combination

    Set<Integer> set = new HashSet<>(candidates);
    Set<List<Integer>> ans = new HashSet<>();
    helper(set, target, ans, new ArrayList<>());
    return new ArrayList<>(combinationSum);
  }
  private void helper(Set<Integer> set, int target, Set<List<Integer>> ans, List<Integer> cur) {
    if(target == 0){
      //这里需要deep copy 一个temp
      //如果直接sort cur，返回去的cur的状态不对，删掉的元素不是想删除的元素
      List<Integer> temp = new ArrayList<>(cur);
     Collections.sort(temp);
      set.add(temp);
    }
     //这里的base不需要判断index == array.length，因为这里可以无限用一个数字无数次
    if(target < 0){
      return;
    }
    for(int i: set){
      cur.add(i);
      helper(set, target-i,ans, cur);
      cur.remove(cur.size()-1);
    }
  }
}
