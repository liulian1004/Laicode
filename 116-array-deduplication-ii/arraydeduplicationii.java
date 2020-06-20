public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    if(array.length <= 2) {
        return array;
      }
      int i = 2;

      for(int j = 2; j < array.length; j++) {
        if(array[j] != array[i-1] || array[j] != array[i-2]) {
          array[i++]= array[j];
        }
    }
    return Arrays.copyOf(array, slow);
  }
}
