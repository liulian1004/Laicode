public class Solution {
  public int smallestElementLargerThanTarget(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        //similar to the last occurance
        while (left < right -1) {
            int midIndex = left + (right - left) / 2;
            if (array[midIndex] <= target) {
                left = midIndex;
            } else {
                right = midIndex;
            }
        }
        // return left, right，-1三种情况
        if(array[left] > target) {
          return left;
        }
        if(array[right] > target) {
          return right;
        }
        return -1;
  }
}
