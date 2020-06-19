public class Solution {
  public int[] plus(int[] digits) {
    // T: O(n)
    if(digits == null || digits.length == 0) {
      return digits;
    }
    int carry = 1;
    for(int i = digits.length - 1; i >= 0; i--) {
      if(carry > 0) {
        digits[i]++;
        if(digits[i] == 10) {
        digits[i] = 0;
        } else {
           carry = 0;
        }
      }
    }
    if(carry == 1) {
      int[] res = new int[digits.length+1];
      res[0] = 1;
      for(int i = 0; i < digits.length; i++) {
        res[i+1] = digits[i];
      }
      return res;
    }
    return digits;
  }
}
