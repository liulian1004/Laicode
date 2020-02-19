public class Solution {
  public boolean canBreak(String input, String[] dict) {
    // n = input.length, m = dict.length()
    //T: n * n * (n + n) + O(m) = n ^ 3  + m  S: O(n)
    // M[i] present wether can cut into the verb till the end of i
    //base case M[0] = true;
    Set<String> set = builder(dict);
    boolean[] m = new boolean[input.length() + 1];
    m[0]= true;
      // j代表判断的字符串
      //subString[i,j) T: O(n)
      //i必须从1开始,这里代表的是travsal m
      for(int i = 1; i < m.length; i++) {
        //j代表切在哪里
          for(int j = 0; j < i; j++ ) {
            // no cut + one cut at different position of subString[j,i)
            //input.substring 是O(n), set.contains shi O(n)
            //这两个API不是同一时间操作，所有时间复杂度是n+n
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
