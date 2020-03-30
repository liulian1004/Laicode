public class Solution {
  public int search(int[] array, int target) {
    // T: O(logn) --> worse case o(n) on the situation I don't which side to go ex:[3,3,3] ,target 4
    //S: O(1)
    if(array == null|| array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while(left < right -1) {
      int mid = left + (right - left) / 2;
      //check termination condition
      if(array[mid] == target) {
        return mid;
      }
      if(array[left] == target) {
        return left;
      }
      if(array[right] == target) {
        return right;
      }
      // go left
      if((array[mid] > array[left] && within(array[left], target, array[mid]) || array[mid] < array[right] && !within(array[mid],target, array[right]))) {
        right = mid - 1;
        //go right
      }else if((array[mid] < array[right]) && within(array[mid], target, array[right])|| (array[left] < array[mid] && !within(array[left], target, array[mid]))) {
        left = mid + 1;
        //can't decide which side to go
      }else {
        left = left + 1;
        right = right -1;
      }
    }
    // left = right -1;
    if(array[left] == target) {
      return left;
    }
    if(array[right] == target) {
      return right;
    }
    return -1;
  }
  private boolean within(int a, int t, int b) {
    return a <= t && t <= b;
  }
}
