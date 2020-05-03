public class Solution {
  public int[] dedup(int[] array) {
    //T: O(n); S: O(1)
    //fast: ready to scan and check;
    //slow - 1 : already scanned and kept
    // fast = 0; slow = 0;
    if(array.length <= 1) {
      return array;
    }
    int slow = 0;
    int fast = 0;
    while(fast < array.length) {
      if(slow == 0 || array[slow - 1] != array[fast]) {
        array[slow] = array[fast];
        slow++;
        fast++;
      } else {
        while(fast < array.length && array[slow-1] == array[fast]) {
          fast++;
        }
        slow--;
      }
    }
    return Arrays.copyOf(array,slow);
  }
}
