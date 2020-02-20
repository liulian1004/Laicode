public int editDistance(String one, String two) {
    // T: O(n^2); S: O(n^2)
    // m[i][j]代表前i个字母转换成前j个字母的最少操作步骤
    // return m[i][j]
    //base case已经包含了corner case,one == null || two == null
    //one, two都是从最后一个字母开始看
    int[][] m = new int[one.length() + 1][two.length() + 1];
    for(int i = 0; i <= one.length(); i++) {
      for(int j = 0; j <= two.length(); j++) {
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
}
