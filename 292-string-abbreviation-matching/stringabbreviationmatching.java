public class Solution {
  public boolean match(String input, String pattern) {
    // T: pattern.length
    //S: pattern.length

    return helper(input, pattern, 0, 0);
  }
  private boolean helper(String input, String pattern, int il, int pl) {
    // two base case
   if(il == input.length() && pl == pattern.length()) {
     return true;
   }
   if(il >= input.length() || pl >= pattern.length()) {
     return false;
   }
   // is letter
   if(pattern.charAt(pl) < '0' ||pattern.charAt(pl) > '9' ) {
     if(input.charAt(il) == pattern.charAt(pl) ) {
       return helper(input, pattern, il + 1, pl + 1);
     }
      return false;
   }
   // is digit
   // move the point of input
   // no need to move the point of patter, because that point has move to the next letter
   // no need to check
  // it will check under letter condition
   int count = 0;
    while(pl < pattern.length() && pattern.charAt(pl) >= '0' && pattern.charAt(pl) <= '9' ) {
      count = count * 10 + (pattern.charAt(pl) - '0');
      pl++;
    }
    return helper(input, pattern, il + count, pl);
  }

}
