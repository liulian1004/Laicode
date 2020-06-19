public class Solution {
  public boolean validPalindrome(String input) {
    // the longest subsequence palidrome
    if(input == null || input.length() == 0) {
        return true;
    }
    int i = 0;
    int j = input.length()-1;
    while(i <= j) {
      if(input.charAt(i) != input.charAt(j)) {
        return isValid(i+1,j,input) || isValid(i,j-1,input);
      }
      i++;
      j--;
    }
    return true;
  }
  private boolean isValid(int i, int j, String input) {
    while(i <= j) {
      if(input.charAt(i) != input.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

}
