public class Solution {
  public boolean canBreak(String input, String[] dict) {
    //dp[i] represents for the first i letter ,it can break
    // n = input.length, m = dict.length()
    //T: n * n * (n + n) + O(m) = n ^ 3  + m  S: O(n)
    // M[i] present wether can cut into the verb till the end of i
    // 左大段（look back） * 右小段（不继续切割，直接查是否在dic里面）
    //base case M[0] = true;
    Set<String> set = builder(dict);
    boolean[] m = new boolean[input.length() + 1];
    //空集也是dict一个子集
    m[0]= true;
      // j代表判断的字符串
      //subString[i,j) T: O(n)
      //i必须从1开始,这里代表的是travsal m
      for(int i = 1; i < m.length; i++) {
        //j代表切在哪里
        // start from 0 ==> for first letter i, check whether it's in the dict
          for(int j = 0; j < i; j++ ) {
            // no cut + one cut at different position of subString[j,i)
            //input.substring 是O(n), set.contains shi O(n)
            //这两个API不是同一时间操作，所有时间复杂度是n+n
            //i,j mapping to array is j-1， i-1 ==> the scope of substring is (i,j) 
            if(set.contains(input.substring(j, i)) && m[j]) {
              m[i] = true;
              //如果已经确认里一个substring里有一个位置能分割成在字典里面的单词，就不需要在往下判断了
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
