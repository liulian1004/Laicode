public class Solution {
  public String longestCommon(String source, String target) {
    // m[i][j] present the longest commom substring from s1(0) till s1(i) and s2(0) till s2(j)
    // base case M[0][0]; M[i][0]; M[0][j] == 0
    //induction rule : S1[i-1] == s2[j-1] m[i][j] == m[i-1][j-1] + 1
    //  S1[i-1] != s2[j-1] m[i][j] = 0;
   //T: O(m*n) S: O(m*n)
    int longest = 0;
    int start = 0;
    int[][] m = new int[source.length() ][target.length() + 1];
    String result = new String();
    if(source == null || target == null) {
      return result;
    }
    for(int i = 0; i < source.length(); i++) {
            for(int j = 0; j < target.length(); j++) {
                if(source.charAt(i) == target.charAt(j)) {
                    if(i == 0 || j == 0) {
                        m[i][j] = 1;
                    } else {
                        m[i][j] = m[i-1][j-1] + 1;
                    }
                }
                if(m[i][j] > longest) {
                    longest = m[i][j];
                    start = i - longest + 1;
                }
            }
        }
  return source.substring(start, start + longest);
  }
}
