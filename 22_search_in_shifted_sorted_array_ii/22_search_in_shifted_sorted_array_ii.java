public class Solution {
  public int search(int[] array, int target) {
    // T: O(logn) --> worse case o(n) on the situation I don't know which side to go ex:[3,3,3] ,target 4
    //S: O(1)
    if(array == null|| array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while(left < right -1) {
      int mid = left + (right - left) / 2;
      //since return the smallest index, check the result from the small index
      if(array[left] == target) {
        return left;
      }
      if(array[mid] == target) {
        return mid;
      }

      if(array[right] == target) {
        return right;
      }
      // go left
      //找到有序的哪一边，并查看target是否在有序的那一边，这里给的是ascending,所有有序的那一边是ascending的
      if((array[mid] > array[left] && within(array[left], target, array[mid]) || array[mid] < array[right] && !within(array[mid],target, array[right]))) {
        right = mid - 1;
        //go right
      }else if((array[mid] < array[right]) && within(array[mid], target, array[right])|| (array[left] < array[mid] && !within(array[left], target, array[mid]))) {
        left = mid + 1;
        //can't decide which side to go
        //at least exclue the boundary
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
