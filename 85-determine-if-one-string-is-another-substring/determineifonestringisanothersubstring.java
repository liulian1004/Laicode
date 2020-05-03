public class Solution {
  public int strstr(String large, String small) {
    // silding windowns
    //T: O(n*m)
    if(small.length() > large.length()) {
      return -1;
    }
    if(small.length() == 0) {
      return 0;
    }
    //最多移几次比较,多包括一位
    for(int i = 0; i <= large.length() - small.length(); i++) {
      if(equals(large,small, i)) {
        return i;
      }
    }
    return -1;
  }
  private boolean equals(String large, String small, int start) {
      for(int i = 0; i < small.length(); i++) {
        //一个个char比较
        if(large.charAt(i + start) != small.charAt(i)) {
          return false;
        }
      }
      return true;
  }
}
//my Solution
for(int i = 0; i <large.length(); i++) {
       if(large.charAt(i) == small.charAt(0) && equals(large, small, i) ) {
           return i;
         }
}

   return -1;
 }
 private boolean equals(String big, String small, int i) {
    for(int j = 0; j < small.length(); j++) {
       if(i + j >= big.length() || small.charAt(j) != big.charAt(i + j)) {
     return false;
   }
}
return true;
