public class Solution {
  public int longest(int[] array) {
    // T: O(n); S o(1)
    //corner case, length == 1 will cover in the induction rule
    if(array.length == 0) {
      return 0;
    }
    //induction rule
    int max = 1;
    int cur = 1;
    for(int i = 1; i < array.length; i++) {
      // continue ascending
      if(array[i] > array[i - 1]) {
         cur ++;
         max = Math.max(max, cur);
         //stop ascending
      } else {
        cur = 1;
    }
  }
  return max;
}
}
