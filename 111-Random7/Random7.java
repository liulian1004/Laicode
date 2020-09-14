public class Solution {
  public int random7() {
    // T: 除第一次外，每一次重新进入loop的几率是 5/24，可以忽略不计
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    //step 1 找到k， 5^k > 7, 然后循环k次得到random数
//step 2 找到boundary数，能被7整除切最接近于5^k,这里是21
  while(true) {
    int ran = 0;
      for(int i = 0; i < 2; i++){
      ran = (int)(ran*5 + RandomFive.random5());
    }
    if(ran <21 ) {
      return ran%7;
    }
  }

  }

}
