public class Solution {
  public int diffBits(int a, int b) {
    //T: O(1); S: O(1)
    //A: a / b is not null
     int count = 0;
     //把a,b的不同点提炼出来
     a ^= b;
     //a==0是停止loop
     while(a != 0) {
       //a & a -1 用来一位位消
       a = (a & (a-1));
       count++;
     }
     return count;

  }
}
