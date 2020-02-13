public class Solution {
  public int longest(int[] array) {
    // Write your solution here
    //m represent the longest subarray of consecutive 1s from 0 index to i-index
    // global max : the longest of subarray
    //T: O(n); S O(1)
    int m = 0;
    int max = 0;
    for(int i = 0; i < array.length; i++) {
      if(array[i] == 1) {
        if( i == 0 || array[i - 1] == 0) {
          m = 1;
        } else {
          m++;
        }
      } else {
        m = 0;
      }
      max = Math.max(max, m);
    }
    return max;
  }
}
