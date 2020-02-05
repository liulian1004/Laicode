public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // 皇后不冲突的三个条件
    // 1. 不在一行 2. 不在一列 3. 不在对角线上
    // T: n! * n S: O(n)
   List<List<Integer>> res = new ArrayList<>();
   List<Integer> cur = new ArrayList<>();// worse case: SO(n)
    helper(res, cur, n);
    return res;
    }
    //S: O(n) = O(1)*O(h)
    //cur并不是在recursion里面new出来的，在recursion这一段不需要考虑
    private void helper(List<List<Integer>> res, List<Integer> cur, int n) {
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

    private boolean isValid(int i, List<Integer> cur){
      int size = cur.size();
      for(int j  = 0; j < size; j++) {
        if((cur.get(j) == i) || Math.abs(size - j) == Math.abs(i - cur.get(j))) {
          return false;
        }
    }
    return true;
    }
}
