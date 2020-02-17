public class Solution {
  public int random7() {
    // T: 除第一次外，每一次重新进入loop的几率是 5/24，可以忽略不计
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    int random;
    do {
      //5进制，random * 5 + 5
    random = (int)(RandomFive.random5() * 5 + RandomFive.random5());
    }
    //如果结果大于等于21，继续循环，因为[0-20]能等概率% 7
    while(random >= 21);
    return random % 7;
  }
}
