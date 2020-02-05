public class Solution {
  public long fibonacci(int K) {
    // T: O(n); S: O(n)
    // corner case
    if(K < 0) {
      return 0;
    }
    IF(K == 1) {
      return K;
    }
    long[] m = new long[K +1];
    //base case
    //以下情况induction rule是不考虑，可以不用写
    //m[0] = 0;
    m[1] = 1;
    //induction rule
    for(int i  = 2; i <= K; i++ ) {
        m[i] = m[i-1] + m[i-2];
    }
    return m[K];
  }

  //Solution 2:
    //T: O(n); S: O(1)
    long a = 0;
    long b = 1;
    //corner case + base case
    if(K <= 0) {
      return a;
    }
    //induction rule + base case
    while(K > 1) {
        long temp = a + b;
        a = b;
        b = temp;
        K--;
    }
    return b;
  }
}
