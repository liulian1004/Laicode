public class Solution {
  public int reverse(int x) {
    // T: O(n)
    if(x == 0) {
      return x;
    }
    long res = 0;
    int sign = x / Math.abs(x);
    x= Math.abs(x);
    while(x > 0) {
      int digit = x % 10;
      x /= 10;
      res *= 10;
      res += digit;
      if(res >= Integer.MAX_VALUE+1l) {
        res = 0;
        break;
      }
    }
    return (int)(res*sign);
  }
}
