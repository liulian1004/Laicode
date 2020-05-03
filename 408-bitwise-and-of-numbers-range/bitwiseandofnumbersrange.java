public class Solution {
  public int rangeBitwiseAnd(int m, int n) {
    // T: O(n) S: O(1)
    // T: O(n) S: O(1)
    // n ^(n-1) --> a quick way to remove the last one
    // 1100(m);1101;1110;1111,10000(n) = 00000
    //  10000(n) ^ (1111)(n-1) ==>10000
    //10000 ^ m = 00000
    if(m == 0) {
      return 0;
    }
    while(n > m) {
      n = n&(n-1);
    }
    return m&n;
  }
  //blueforth
  //timeout
   // int res=n;
  // int i = m;
  // while (i<n) {
  //     res = res & i;
  //     i++;
  // }
  // return res;
  }
}
