public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // 皇后不冲突的三个条件
    // 1. 不在一行 2. 不在一列 3. 不在对角线上
    // T: n! * n S: O(n)
    //dfs： 层高 n， 每一个branch代表这个piece可以放在哪一个位置
   List<List<Integer>> res = new ArrayList<>();
   List<Integer> cur = new ArrayList<>();// worse case: SO(n)
    helper(res, cur, n);
    return res;
    }
    //S: O(n) = O(1)*O(h)
    //cur并不是在recursion里面new出来的，在recursion这一段不需要考虑
    private void helper(List<List<Integer>> res, List<Integer> cur, int n) {
      //这里的recursion rule不能动n
      // 因为每一次n
      if(cur.size() == n) {
        res.add(new ArrayList<>(cur)); // S: O(n)
        return;
    }
        for(int i = 0; i < n ;i++) {
          if(isValid(i ,cur)) {
          cur.add(i);
          helper(res, cur, n);
          cur.remove(cur.size() -1 );
        }
      }
    }

    private boolean isValid(int index, List<Integer> cur){
      int size = cur.size();
      //遍历这个cur
      for(int i  = 0; i < size; i++) {
        // cur.get(j)查是否在竖线上重合
        // i是在这一层准备要插入的位置
        //两个坐标（cur.get(i), i) (index, size)
        if((cur.get(i) == index) || size - i == Math.abs(index - cur.get(i))) {
          return false;
        }
    }
    return true;
    }
}
