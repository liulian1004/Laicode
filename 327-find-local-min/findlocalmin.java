public class Solution {
  public int localMinimum(int[] array) {
    // T: O(n) S: O(1)
   for(int i = 0; i < array.length ; i++) {
     int left = Integer.MAX_VALUE;
     int right = Integer.MAX_VALUE;
     if(i-1 > 0) {
       left = array[i-1];
     }
     if(i+1 < array.length) {
       right = array[i+1];
     }
     if(array[i] < left && array[i]< right) {
       return i;
     }
   }
   return -1;
  }
}
