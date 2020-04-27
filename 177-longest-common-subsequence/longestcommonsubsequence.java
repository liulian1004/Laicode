public class Solution {
  public int longest(String source, String target) {
    // m[i][j] present the longest  substring from s1(0) to s1(i) and from s2(0) to s2(j)
    // induction rule s[i] == s[j] => m[i][j] = m[i-1][j-1] + 1
    //s[i] != s[j]
    //give up i==> m[i][j] = m[i-1][j]
    //give up i==> m[i][j] = m[i][j-1]
    // T: O(m * n); S: O(m)
    if(source == null || target == null || source.length() == 0 || target.length() == 0) {
      return 0;
    }
    int[][] m = new int[source.length()+1][target.length()+1];
    for(int i = 1; i <= source.length(); i++) {
      for(int j = 1; j <= target.length();j++) {
        if(source.charAt(i-1) == target.charAt(j-1)) {
          m[i%2][j] = m[(i-1)%2][j-1] + 1;
        } else {
            m[i%2][j] = Math.max(m[(i-1)%2][j], m[i%2][j-1]);
        }
      }
    }
    return m[source.length()%2][target.length()];
  }
}
