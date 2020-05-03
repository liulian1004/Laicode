public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    // k层
    //T： O(n!)
    //S: O(k)
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    if(n <= 1 || k <= 0 || k > n) {
      list.add(new ArrayList<>(cur));
      return list;
    }

    helper(n, k, 1, list, cur);
    return list;
  }
  private void helper(int n, int k, int index, List<List<Integer>> list, List<Integer> cur ) {
    if(cur.size() == k) {
      list.add(new ArrayList<>(cur));
      return;
    }
    for(int i = index; i <= n; i++) {
      cur.add(i);
      helper(n, k ,1 + i, list, cur);
      cur.remove(cur.size() - 1);
    }
  }
}
