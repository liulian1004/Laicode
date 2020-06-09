public class Solution {
  public int missing(int[] array) {
    //smilar to find the first element
    // T: logn
    if(array.length == 0) {
      return 1;
    }
    int left = 0;
    int right = array.length -1;
    while(left < right - 1) {
      int mid = left + (right - left) / 2;
      if(array[mid] != mid + 1 ){
        right = mid;
      }else if(array[mid] == mid + 1) {
        left = mid + 1;
      }
  }
  if(array[left] != left + 1) {
    return left + 1;
  }
  if(array[right] != right + 1) {
    return right + 1;
  }
  //miss number is the latest one
  return array.length + 1;
  }
}
