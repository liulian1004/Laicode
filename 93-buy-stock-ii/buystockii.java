public class Solution {
  public int maxProfit(int[] array) {
    //找到局部min，然后买入
    //往后局部max,卖出
    // 7 1 5 4 7
    //1 买进，5卖出，4买进，7卖出
    //如果最后一位是buy,或者一直没有sell, 最后一位要强制卖出
    // T: O(n); S: O(1)
    int profit = 0;
    if(array == null || array.length == 0) {
      return profit;
    }
    //寻找局部最低买入价
    int min = array[0];
    int cur = 1;
    while(cur < array.length) {
      if(array[cur]< array[cur -1]){
        //case 1: 没有buy过，找低点买入
        //把之前以为是低点buy的股票反悔，一加一减相当于没有买
        //case2: 没有sell过，找到第一低点以后
        //在前一个点卖出
        profit = profit + array[cur-1] - min;
        //更新min值
        min = array[cur];
      }
      cur++;
    }
    //case1: 一直没有sell过，在最后一位sell掉
    //case2: 最后一位buy了(最后一位是min值），在最后一位sell掉，一加一减等于没有买
    profit = profit + array[cur-1] - min;
    return profit;

  }
}
