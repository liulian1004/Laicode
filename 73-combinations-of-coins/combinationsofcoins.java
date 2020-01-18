public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    // T: coin.length ^ (最多分支数) ex： target 99， coins = 【25，10，5，1】
    //cent从大到小排序，方便以后的减支/分叉数越来越小
    //4层 动态分支
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    helper(target, coins, 0, cur, res);
    return res;
  }
  private void helper(int moneyLeft, int[] coins, int index, List<Integer> cur, List<List<Integer>> res) {
    if(index == coins.length - 1) {
      if(moneyLeft % coins[index] == 0) {
        cur.add(moneyLeft / coins[index]);
        res.add(new ArrayList<Integer>(cur));
        cur.remove(cur.size()-1);
      }
        return;
      }
      int max = moneyLeft / coins[index];
      for(int i = 0; i<= max; i++) {
        //cur.add(i);
        helper(moneyLeft - coins[index] * i, coins, index + 1, cur.add(i), res);
        cur.remove(cur.size() - 1);
      }
    }
}
