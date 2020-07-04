public class Solution {
  public int numWays(int n, int k) {
    // diff[i] represent the ith index is the different color with i-1th
    // same[i] represents the ith index is the same color of i-1th
    //induction rule:
    // same[i] = diff[i-1]: 因为i和i-1颜色相同，所以i-1有多少种方法
    //i就有多少中方法
    //另外，所以i-1和i-2一定要颜色不同，所以取diff[i-1]
    //diff[i] = same[i-1]*（k-1) + diff[i-1]*(k-1)
    //因为i和i-1取的颜色不同，所有需要i-1的方法*（k-1）
    //这里的i-1可以和i-2相同（取same[i-1]),也可以颜色不同（取diff[i-1])
    //base case:
    //n == 1 ==> same[1] = k, diff[1] = k
    // n == 2 == > same[2] = k, diff[2] = k *(k-1)

    //T: O(n) S: O(1)
    if(n <= 0) {
      return 0;
    }
    if(n == 1) {
      return k;
    }
    int same = k;
    int diff = k*(k-1);
    for(int i = 3; i <= n;i++) {
      int preSame = same;
      int preDiff = diff;
      same = preDiff;
      diff = (preSame + preDiff) *(k-1);
    }
    return same + diff;
  }
}
