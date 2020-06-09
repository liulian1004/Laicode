public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    // T: coin.length ^ (最多分支数) ex： target 99， coins = 【25，10，5，1】
    //在每一层中， 每一个node最大分支为target，一共又N层（N种不同的coin）
    //cent从大到小排序，方便以后的减支/分叉数越来越小
    //4层 动态分支
    //
    //T= 99^4 --> [taget/min(coins)] ^n
    // 4 power of 99
    //每一个node最多分出多少叉^层数（算up bound）
    //S: O(n)
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    helper(target, coins, 0, cur, res);
    return res;
  }
  private void helper(int moneyLeft, int[] coins, int index, List<Integer> cur, List<List<Integer>> res) {
    if(index == coins.length - 1) {
      if(moneyLeft % coins[index] == 0) {
        cur.add(moneyLeft / coins[index]);
         //deep copy,后面cur再改变也没有关系了
        //res.add(cur),加入的是cur的地址，后面cur会变
        res.add(new ArrayList<Integer>(cur));
        //和63题不同 这里return以后需要马上remove掉结果
        //下一个分支是从头开始算
        cur.remove(cur.size()-1);
      }
        return;
      }
      for(int i = 0; i<= moneyLeft / coins[index]; i++) {
        //cur.add(i);
        // moneyLeft如果再helper里面更改，不需要吐因为value不传
        //这里不能在helper外面先更改moneyLeft，因为每一次for loop是moneyleft的值都不变
        helper(moneyLeft - coins[index] * i, coins, index + 1, cur.add(i), res);
        cur.remove(cur.size() - 1);
      }
    }
}
