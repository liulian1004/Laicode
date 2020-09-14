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

// find the max element
//以下soluton是找到max element再往后+1
public int shiftPosition(int[] array) {
    // Write your solution here
    if(array == null || array.length == 0){
      return -1;
    }
    int i = 0;
    int j = array.length - 1;
    while(i < j -1){
      int mid = i + (j-i)/2;
      if(array[mid] > array[mid-1] && array[mid] > array[mid+1]) {
        return (mid+1)%array.length;
      }else if(array[mid] > array[i]){
        i = mid;
      }else if(array[mid] < array[j]){
        j = mid;
      }
    }
    if(array[i] > array[j]){
      return j;
    }
    return (j+1)% array.length;
  }
