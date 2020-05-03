public class Solution {
  public int knightDial(int N) {
    // Soultion 1 ： DFS
    // T:O (3^N) S: O(N)
    //how many number the knight can reach start from 0 to 9
    final int[][] neighbors  = new int[][]{
        {4,6},{6,8},{7,9},{4,8}, {3,9,0}, {},{1,7,0},{2,6}, {1,3}, {2,4}
    };
    int count = 0;
    //do dfs for each number
    for(int i = 0; i < 10; i++){
      count += dfs(i, neighbors,N - 1);
    }
      return count % (1000000007);
    //return count % (10 ^ 9 + 7); 这么写是XOR，不是 10的9次方
  }
  private int dfs(int i, int[][] neighbors, int hop){
      if(hop == 0) {
        return 1;
      }
      int count = 0;
      for(int next : neighbors[i]){
        count += dfs(next, neighbors, hop - 1 );
      }
      return count;
  }
  //Solution 2:
  //dfs + memorization
  //weakness： call stack time outofstack
  //T: O(n * 10) S: O(n)
  //how many number the knight can reach start from 0 to 9
    final int[][] neighbors  = new int[][]{
        {4,6},{6,8},{7,9},{4,8}, {3,9,0}, {},{1,7,0},{2,6}, {1,3}, {2,4}
    };
    int count = 0;
    // 从每一个数字出发，还能走N步，能走到多少不同的数字
    int[][] dp = new int[N][10];
    //base case: 从每一个数出发，还能走0步，只能走到这个数字本身，即1步
    Arrays.fill(dp[0],1);
    //do dfs for each number
    for(int i = 0; i < 10; i++){
      count += dfs(i, neighbors,N-1, dp);
    }
      return count % (1000000007);
    //return count % (10 ^ 9 + 7); 这么写是XOR，不是 10的9次方
  }
  private int dfs(int i, int[][] neighbors, int hop, int[][] dp){
      if(dp[hop][i] != 0){
        return dp[hop][i];
      }
      int count = 0;
      for(int next : neighbors[i]){
        count += dfs(next, neighbors, hop - 1,dp );
      }
      dp[hop][i] = count;
      return count;
  }
  //solution 3 :DP
  //T:O(n) S: O(n)
  final int[][] neighbors  = new int[][]{
        {4,6},{6,8},{7,9},{4,8}, {3,9,0}, {},{1,7,0},{2,6}, {1,3}, {2,4}
    };
    // 从每一个数字出发，还能走N步，能走到多少不同的数字
    int mod = 1_000_000_007;
    long[][] dp = new long[N][10];
    //base case: 从每一个数出发，还能走0步，只能走到这个数字本身，即1步
    Arrays.fill(dp[0],1);
    //induction rule
    for(int i = 1; i < N; i++){
      for(int pos = 0; pos < 10; pos++) {
        for(int next : neighbors[pos]) {
           dp[i][pos] += dp[i-1][next];
           //every step need to mod because of the large result
           dp[i][pos] %= mod;
        }
      }
    }
    long count = 0;
    for(int i = 0; i <10; i++) {
      count += dp[N-1][i];
      //every step need to mod because of the large result
      count %= mod;
    }
    return (int)count;
  }
  //Solution 4
  // T:O (n * 10) S: O(1)
    // dp[hops][pos] represents the distinct numbers ending at pos in hops
    final int[][] neighbors  = new int[][]{
        {4,6},{6,8},{7,9},{4,8}, {3,9,0}, {},{1,7,0},{2,6}, {1,3}, {2,4}
    };
    // 从每一个数字出发，还能走N步，能走到多少不同的数字
    int mod = 1_000_000_007;
    long[][] dp = new long[2][10];
    //base case: 从每一个数出发，还能走0步，只能走到这个数字本身，即1步
    Arrays.fill(dp[0],1);
    //induction rule
    for(int i = 1; i < N; i++){
      for(int pos = 0; pos < 10; pos++) {
        //重置表格
        dp[i%2][pos] = 0;
        for(int next : neighbors[pos]) {
           dp[i%2][pos] += dp[(i-1) %2][next];
           //every step need to mod because of the large result
           dp[i%2][pos] %= mod;
        }
      }
    }
    long count = 0;
    for(int i = 0; i <10; i++) {
      count += dp[(N-1)%2][i];
      //every step need to mod because of the large result
      count %= mod;
    }
    return (int)count;

  }
}
