public class Solution {
  public List<List<Integer>> combinations(int target) {
    //最多有多少分支 * 层数
    //最小的fator是2，所以最多有log_2(n)分支/logn
    //最多有number of factor层数
    //T: log_2(n) ^ factor
    List<List<Integer>> list = new ArrayList<>();
    if(target <= 1) {
        return list;
    }
    //creat a list of factors
    List<Integer> factor = getFactors(target);
    List<Integer> cur = new ArrayList<>();
    helper(list, cur, factor, target,0);
    return list;
  }
  private void helper(List<List<Integer>> list, List<Integer> cur, List<Integer> factor, int target, int index) {
    if(index == factor.size()) {
      //如果target已经被除尽
      //cur符合条件装入list
      if(target == 1) {
        list.add(new ArrayList<>(cur));
      }
      //没有被除尽就不装入list，返回
      return;
    }
    //不加
    //如果把不加的放在加后面执行，target已经变化，状态不对
    //这里从不加的helper返回，target还是不变
    helper(list, cur, factor, target, index + 1);
    //加
    int number = factor.get(index);
    int count = 0;
    //吃
    //查重
    while(target % number == 0) {
      cur.add(number);
      count++;
      //因为每一次循环target的值必须都要变
      //所以在helper外面先变好，之后再传入
      target /= number;
      //加必须在while loop里面
      helper(list, cur, factor, target, index+1);
    }
    for(int i = 0; i < count;i++) {
        cur.remove(cur.size() - 1);
    }
  }
  private List<Integer> getFactors(int target) {
    //最小factor是2，从2开始查
    //i最多是走到target/2，因为fator是从2开始的
    List<Integer> list = new ArrayList<>();
    for(int i = 2; i <= target / 2; i++) {
        if(target % i == 0) {
          list.add(i);
        }
    }
    return list;
  }
}
