public class Solution {
  //for loop
  public boolean isPowerOfThree(int n) {
    // T: log_3 n
    if(n < 1) {
      return false;
    }
    while(n != 1) {
      int res = n%3;
      if(res > 0) {
        return false;
      }
      n = n/3;
    }
    return n == 1;
  }
}
// non-for loop
// find out the max of power 3
// max power 3 = log(maxInteger) / log3
public boolean isPowerOfThree(int n) {
  // T: O(1)
  if(n < 1) {
    return false;
  }
  //calculate the max log3
  int maxLog3 = (int)(Math.log(Integer.MAX_VALUE) / Math.log(3));
  //calcuate the max power 3
  int maxPower3= (int)(Math.pow(3, maxLog3));
  return maxPower3% n == 0;
}
