public class Solution {
  public int random1000() {
    // Write your solution here.
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.

    // 5^k > 1000  ==> k = 5
    // k = log5 (1000) = log 1000 / log 5
    int k = (int)(Math.log(1000.0) / Math.log(5.0)) + 1;
    //算出大于多少要重新random
    int boundary = ((int)(Math.pow((double)k, 5.0)) / 1000) * 1000;
    int ran;
    do{
      //每一次循环 rand都要重制为0
      ran = 0;
      for(int i = 0; i < k ; i++) {
        ran = (int)(ran* 5 + RandomFive.random5());
      }
     } while(ran >= boundary);
    return ran %1000;
  }
}
