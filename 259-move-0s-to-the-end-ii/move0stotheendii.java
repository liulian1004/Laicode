public class Solution {
  public int[] moveZero(int[] array) {
    // T: O(1); S: O(n)
    // fast: ready to scan and check
    // slow - 1: already scanned and kept
    if(array.length <= 1) {
      return array;
    }
    int slow = 0;
    for(int fast = 0; fast < array.length; fast++) {
      if(array[fast] != 0) {
        array[slow] = array[fast];
        slow++;
      }
    }
    // [0, slow-1] keep the realtive order of non- zore digits
    while(slow < array.length) {
      array[slow] = 0;
      slow++;
    }
    return array;
  }
}
