public class Solution {
  public boolean isMatch(String s, String p) {
     int m = s.length(), n = p.length();
        if (n == 0) return m == 0;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < n; i+=2) {
            if (p.charAt(i) != '*') break;
            else dp[0][i + 1] = true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char a = s.charAt(i), b = p.charAt(j);
                if (b == '.' || a == b) dp[i + 1][j + 1] = dp[i][j];
                else if (b == '*') dp[i + 1][j + 1] = dp[i + 1][j - 1]  // zero
                    || ((s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i][j + 1]); // 1 or more;  // consider ".*"
            }
        }

        return dp[m][n];
  }
}
