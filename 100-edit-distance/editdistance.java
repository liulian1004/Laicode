public int editDistance(String one, String two) {
    // T: O(n^2); S: O(n^2)
    // m[i][j]代表前i个字母转换成前j个字母的最少操作步骤
    // return m[i][j]
    //base case已经包含了corner case,one == null || two == null
    //one, two都是从最后一个字母开始看
    int[][] m = new int[one.length() + 1][two.length() + 1];
    for(int i = 0; i <= one.length(); i++) {
      for(int j = 0; j <= two.length(); j++) {
        //这里是3个case是，
        //最后一个case是3个不同option
        // base case
        if (i == 0) {
          m[i][j] = j;
        } else if(j == 0) {
          m[i][j] = i;
          //charaters are equal
        } else if (one.charAt(i- 1) == two.charAt(j - 1)) {
          m[i][j] = m[i-1][j-1];
        } else {
          // replace: m[i][j] = m[i-1][j-1] + 1;
          //detelet: m[i][j] = m[i-1][j] + 1;
          //在第i个字母后面insert 第j个字母
          // i.e xxxsig --> xxxabg ==> xxxsaig --> xxxabg
          // insert: m[i][j] = m[i][j-1]+1;
          // delete, replace and insert
          // Math.min only can have two input
          // compare replace, delete and insert
          m[i][j] = Math.min(m[i-1][j] + 1 , m[i][j-1] + 1);
          m[i][j] = Math.min(m[i][j], m[i-1][j-1]+ 1);
        }
      }
    }
    return m[one.length()][two.length()];
  }
  //优化空间
  public int editDistance(String one, String two) {
    // T： O(n^m) S: O(m)
    if(one == null || two == null) {
      return -1;
    }
    int[][] dp = new int[2][two.length()+ 1];
    for(int i = 0; i <= one.length(); i++) {
      for(int j = 0; j <= two.length(); j++) {
        if(i == 0) {
          dp[i%2][j] = j;
        }else if(j == 0) {
          dp[i%2][j] = i;
        }else if(one.charAt(i-1) == two.charAt(j-1)) {
          dp[i%2][j] = dp[(i-1)%2][j-1];
        }else {
          dp[i%2][j] = Math.min(dp[(i-1)%2][j-1], Math.min(dp[i%2][j-1],dp[(i-1)%2][j]))+1;
        }
      }
    }
    return dp[one.length() % 2][two.length()];
  }
}
