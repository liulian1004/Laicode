public class Solution {
  public int maxProduct(int length) {
    // T: O(n^2);  S: O(1)
    //base case: 1m
    //iinduction rule: i米长的绳子，至少切一刀，最大乘积是多少？
    //只要考虑切一刀的情况，分成以前已经碰到到过的情况 4米切一刀，分成1米和3米
    //m[i] keep to max product of length at the i m
    int[] m = new int[length + 1];
    //base case,0 米和1 米情况
    // 以下情况induction rule是不用，可以不用写
    //m[0] = 0;
    m[1] = 0;
    for(int i = 2; i <= length; i++) { // i米的情况
      //内层循环是切几刀的原因
      //内层循环到i-1即可
      for(int j = 1; j < i; j++) {
       m[i] = Math.max(m[i], Math.max(m[j], j)* (i - j));
      }
    }
    return m[length];
  }
}
