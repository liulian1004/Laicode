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
    // mysolution
    int count = 0;
    for(int i = 0; i < 32; i++) {
      if((a & (1<<i)) != (b & (1<<i))){
        count++;
      }
    }
return count;
  }
}
// another solution
//这个方法负数不行。
int res = 0;
   for(int i = 0; i < 31; i++){
       res +=(number>>i&1);
   }
   return res == 1;
