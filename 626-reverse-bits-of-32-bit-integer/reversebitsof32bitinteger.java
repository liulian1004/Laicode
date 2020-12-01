public class Solution {
  public long reverseBits(long n) {
    // T: O(1); S: O(1)
    //这里用long的原因是如果负数swap之后还是希望是负数
    //所以用long把第64位当成符号位
    long i = 0;
    long j = 31;
    while(i < j) {
        //bit operation, don't pass by value, need to assign the value
        n = swap (n, i, j);
        i++;
        j--;
    }
    return n;
  }
  private long swap(long n, long i, long j) {
      // check index i == index j?
      // if not, change 1 to 0, and 0 to 1
      if( ( (n >> i) & 1l) != ( (n >> j) & 1l) ) {
	        n ^= (1l<< i);
          n ^= (1l <<j);
        }
      return n;
  }
}
