public class Solution {
  public int random1000() {
    // Write your solution here.
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    // 5^k > 1000  ==> k = 5
    int ran;
    do{
      ran = 0;
      for(int i = 0; i < 5 ; i++) {
        ran = (int)(ran* 5 + RandomFive.random5());
      }
     } while(ran >= 3000);
    return ran %1000;
  }
}
