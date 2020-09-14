public class Solution {
  public int random1000() {
    // Write your solution here.
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.

    // 5^k > 1000  ==> k = 5
    // k = log5 (1000) = log 1000 / log 5
    int k = (int)(Math.log(1000 * 1.0) / Math.log(5*1.0))+1;
    int bound = ((int)(Math.pow(k*1.0,5*1.0))/1000) * 1000;
    while(true) {
      int ran = 0;
      for(int i = 0; i < k; i++){
          ran = (int)(ran*5 + RandomFive.random5());
      }
      if(ran < bound) {
        return ran%1000;
      }
    }
  }
}
