public class Solution {
  public int diffBits(int a, int b) {
    //T: O(1); S: O(1)
    // my solution
    int count = 0;
    for(int i = 0; i < 32; i++) {
      int c = ((a >> i) & 1) ^ ((b >> i) & 1);
      if(c == 1) {
        count++;
      }

    }
    return count;
  }
  //recommend solution
  int count = 0;
    a ^= b;
    while( a != 0) {
      count += a & 1;
      //count = count + (a & 1);
      a >>>= 1;
    }
    return count;
  }
}
