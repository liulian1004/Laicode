public class Solution {
  public int shiftPosition(int[] array) {
    // T: logn
    if(array == null || array.length == 0) {
      return -1;
    }
    int i = 0;
    int j = array.length - 1;
    while(i < j) {
      int m = i + (j-i)/2;
      if(array[m] < array[j]) {
        j = m;
      }else if(array[m] > array[j]) {
        i = m +1;
      }
    }
    return i;
}
// follow up
// if has duplicated elements in the array?
// j--;
//check leetcode 154. Find Minimum in Rotated Sorted Array II
