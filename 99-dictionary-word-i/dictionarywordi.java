public class Solution {
  public boolean canBreak(String input, String[] dict) {
    //T: n * n * (n + n) = n ^ 3  S: O(n)
    // M[i] present wether can cut into the verb till the end of i
    //base case M[0] = true;
    Set<String> set = builder(dict);
    boolean[] m = new boolean[input.length() + 1];
    m[0]= true;
      // no cut + one cut at different position of subString[j,i)
      //subString[i,j) T: O(n)
      for(int i = 1; i < m.length; i++) {
          for(int j = 0; j < i; j++ ) {
            if(set.contains(input.substring(j, i)) && m[j]) {
              m[i] = true;
              break;
            }
          }
        }
        return m[m.length - 1];
    }

  private Set<String> builder(String[] dict) {
    Set<String> set = new HashSet<>();
    for(String s: dict) {
      set.add(s);
    }
    return set;
  }
}
