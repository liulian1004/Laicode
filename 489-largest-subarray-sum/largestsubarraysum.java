public class Solution {
  public int[] largestSum(int[] array) {
    // Write your solution here
    //T: O(n); S: O(1)
    int left = 0;
    int curLeft = 0;
    int right = 0;
    int curLargest = array[0];
    int largest = array[0];
    for(int i = 1; i < array.length; i++) {
      if(curLargest < 0) {
        curLargest = array[i];
        curLeft = i;
      } else {
        curLargest = array[i] + curLargest;
      }
      if(curLargest > largest) {
        largest = curLargest;
        left = curLeft;
        right = i;
      }
    }
    return new int[]{largest, left, right};
  }
}
