public class Solution {
  public int search(int[] array, int target) {
    // T: O(logn); S: O(1)
    //at least three elements when entering into this condition
    if(array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while(left < right - 1) {
      int mid = left + (right - left) / 2;
      if(array[mid] == target) {
        return mid;
        // left ascending and target in the[left, mid) ex(target 3, array[2,3,4,5,1])
        // right ascending and target not int the (mid,right](ex: target 4, array[4,5,1,2,3])
        //turn to left
      }else if ((array[left] < array[mid] && within(array[left], target, array[mid])) || (array[mid] < array[right] && !within(array[mid], target, array[right]))) {
        right = mid - 1;
      }else {
        left = mid + 1;
      }
    }
    //left = right -1；
    //post - processing
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
