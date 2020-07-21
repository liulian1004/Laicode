public class Solution {
  public int longestBitonic(int[] array) {
    //T：O(n)
    // dp[i] : the longest bitnoic end at i
    //maxIndex要考虑到最后一个出现的max值的index
    //corner case： 1 5 2 4 5 4 == 》 maxIndex如果是1就会出错，maxIndex需要是5
    if(array == null || array.length == 0){
      return 0;
    }
    int length = 1;
    int maxIndex  = findMax(array);
    for(int i= 1; i < array.length; i++) {
      if(i <= maxIndex && array[i] > array[i-1]) {
        length++;
      }else if(i > maxIndex && array[i] < array[i-1]) {
        length++;
      }
    }
    return length;
  }
  private int findMax(int[] array) {
    int res = 0;
    int max = array[0];
    for(int i = 1; i < array.length; i++) {
        if(array[i] >= max) {
          max = array[i];
          res = i;
        }
    }
    return res;
  }
}
