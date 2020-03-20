public class Solution {
  public int minCost(int[] cuts, int length) {
    // 1D 要用 2d 做的题目
    //考虑第一刀切在哪里
    //左大段 右大段
    // 用切口做m的index base case m[i][i+1] == 0
    //induction rule M[i][j] = cuts[j] - cuts[i] + min(A[i+1], A[i+2],A[i+3]...A[j-1])
    //A[i+1] = m[i][i+1] + m[i+1][j]; A[i+1] = m[i][i+2] + m[i+2][j];....
    //A[j]-A[i] + min_k(m[i][k] + m[k][j]) ; i < k < j
    // 要先算M[i][j]的左边和下面
    //所以要算从下到上，从左到右的算
    //T：O(n^3) S: O(n)
    int len = cuts.length;
    // create a role with the cut of index, include index 0 + index role of length;
    int[] role = new int[len + 2];
    role[0] = 0;
    for(int i = 0; i < len; i++) {
      role[i+1] = cuts[i];
    }
    role[len+1] = length;
    len = role.length;
    // m[i][j]: the min cost of cuting the tree from i to j
    int[][] m = new int[len][len];
    //m[i][j]要从左边和下面往右边和上面算
    //从左到右走
    for(int i = 1; i <len; i++) {
      // 从下往上走
      for(int j = i -1; j >= 0; j--) {
        //已经切到最小单元，不用切
        if(j + 1 == i) {
          m[j][i] = 0;
        } else{
          //初始值是最大值
          m[j][i] = Integer.MAX_VALUE;
          for(int k = j + 1; k < i; k++) {
            m[j][i] = Math.min(m[j][i], m[j][k] + m[k][i]);
          }
          m[j][i] += role[i] - role[j];
        }
      }
    }
    // 右上角的值
    return m[0][len-1];
  }
}
