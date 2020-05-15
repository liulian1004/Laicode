public class Solution {
  public String minWindow(String source, String target) {
    //step 1. 找到the first qualify length(i= 0, j++)
    // start to contract and try to find a shorter one(i++,j fix)
    // if not exist, contine expand j and find another qualified one
    //compare the length of each qualified one
    //T: O(n + m) S： O（1）
    if(source == null || source.length() == 0 || target == null || target.length() == 0) {
      return "";
    }
    // represent an ascii table
    int[] map = new int[128] ;
    for(int i = 0; i < target.length(); i++) {
      char c = target.charAt(i);
      map[c]++;
    }
    int res = Integer.MAX_VALUE;
    int count = target.length();
    int i = 0;
    int j = 0;
    int minStart = 0;
    while( j < source.length()) {
      char c1 = source.charAt(j);
      if(map[c1] > 0) {
        count--;
      }
      // reduce map whatever it exists or not
      map[c1]--;
      j++;
      //the valid string appear
      while(count == 0) {
        //update res
        if(res > (j - i)) {
          res = j - i;
          minStart = i;
        }
        char c2 = source.charAt(i);
        map[c2]++;
        if(map[c2] > 0) {
          count++;
        }
        i++;
      }
    }
    return res == Integer.MAX_VALUE ? "": source.substring(minStart, minStart+ res);
  }
}
