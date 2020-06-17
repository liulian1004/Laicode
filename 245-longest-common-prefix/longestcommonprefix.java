public class Solution {
  public String longestCommonPrefix(String[] strs) {
    // T: O(number of strs*min) S: O(1)
    if(strs == null || strs.length < 1) {
      return "";
    }
    int i = 0;
    int min = Integer.MAX_VALUE;
    for(String s: strs) {
      min = Math.min(s.length(), min);
    }
    while(i < min) {
      char c = strs[0].charAt(i);
      for(int j = 1; j <strs.length; j++) {
         if(c != strs[j].charAt(i)) {
           return strs[0].substring(0,i);
         }
      }
      i++;
    }
    return strs[0].substring(0,i);
  }
}
