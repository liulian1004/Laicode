public class Solution {
  public int getSingleElement(int[] array) {
    // T: O(logn); S: O(n)
   if(array.length  == 1) {
     return array[0];
   }
   for(int i = 0; i < array.length - 1; i = i+2) {
     if(array[i] != array[i+1]) {
       return array[i];
     }
   }
   return array[array.length - 1];
}
}
//follow up
//how to find the single element in the unsorted subArray
// T: O(n) S: O(1)
public int singleNumber(int[] array) {
      int x =0;
      for (int i : array) {
          x ^= i;
      }
      return x;

  }
