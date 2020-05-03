public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    if(array.length <= 1) {
      return array;
    }
    int slow = 1;
    //count原始状态是1，因为initialize的状态是已经默认第一个元素copy完成
    int count = 1;
    for(int fast = 1; fast < array.length; fast++) {
      if(array[fast] != array[slow-1]) {
        array[slow] =array[fast];
        slow++;
        count = 1;
        //fast == slow -1
        //coun <2 才能继续copy
      } else if(count < 2) {
          array[slow] = array[fast];
          slow++;
          count++;
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
