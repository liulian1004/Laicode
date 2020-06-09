public class Solution {
  public String longestPalindrome(String input) {
    //T: O(n^2)
    //start from each index and expand it to check the longest panlondrom.
    // expand like odd or even
    if(input == null || input.length() <= 1) {
      return input;
    }
    int max = 1;
    int start = 0;
    for(int i = 0; i < input.length(); i++) {
      // the max panlidrome that the mid start from i
      int cur = Math.max(findP(input, i, i ), findP(input,i, i+1));
      if(cur > max) {
        max = cur;
        //以i为panlidrom中心点的最左边index
        start = i - (cur-1)/2;
      }
    }
    return input.substring(start, start + max);
  }
  private int findP(String input, int i, int j) {
    while(i >= 0 && j < input.length()) {
      char a = input.charAt(i);
      char b = input.charAt(j);
      if(a != b) {
        break;
      }
      i--;
      j++;
    }
    return j-i-2+1;
  }
}
