public class Solution {
  public int[] countBits(int num) {
    // T: O(n)
    //第i+1 index上，转化成2进制，出现多少个1
    // ex: 第3位对应2，转成2进制，出现1个1
    //循环从第1位开始
    //偶数右移1位，和之前的偶数的二进制一样 不影响，
    //奇数右移1位， 少一个1，要单独加1

    if(num == 0) {
      return new int[]{0};
    }
    //res[0] = 0
    int[] res = new int[num + 1];
    for(int i = 1; i <= num; i++) {
      res[i] = res[i >>1] + (i%2);
    }
    return res;
  }
}
