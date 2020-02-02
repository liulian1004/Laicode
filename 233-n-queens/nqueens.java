public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // 皇后不冲突的三个条件
    // 1. 不在一行 2. 不在一列 3. 不在对角线上
    // T: n! * n S: O(n)
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    nqueens(res, cur, n);
    return res;
  }

  private void nqueens(List<List<Integer>>res, List<Integer> cur, int n) {
    //8行都放了一个queen
    if(cur.size() == n) {
          res.add(new ArrayList<>(cur));
          return;
    }
    //for loop 每一行
    for(int i = 0; i < n; i++) {
      if(isValid(cur, i)) {
        cur.add(i);
        nqueens(res, cur, n);
        cur.remove(cur.size()- 1);
      }
    }
  }
  //检查在新的一行里放在某column的位置上是否会和之前的queen有冲突
  private boolean isValid(List<Integer> cur, int column) {
    //之前的queen的行数
    int row = cur.size();
    //for loop之前的queen
    for(int i = 0; i < row; i++) {
      //case 1: cur.get(i) == column 检查是否是在一列上
      // case 2: Math.abs(cur.get(i) - column) == (row - i) 检查是否在对角线上
      // 坐标（a2，b2）; (a1, b1) ==> 如果在对角线上： |a2- a1| == |b2 - b1|

      if((cur.get(i) == column) || Math.abs(cur.get(i) - column) == (row - i)) {
        return false;
      }
    }
    return true;
  }

}
