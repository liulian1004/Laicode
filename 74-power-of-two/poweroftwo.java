public class Solution {
  public boolean isPowerOfTwo(int number) {
    // power of two: non negative number & only one 1 in the bits
    // number :    0.1000...00
    // number -1 : 0.0111...11
    return number > 0 && (number & (number - 1)) == 0;

  }
}
