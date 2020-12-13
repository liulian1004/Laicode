public class Solution {
  public void sortInPair(int[] array) {
    // T: nlogn S: o(1)
    Arrays.sort(array);
    for(int i = 1; i < array.length; i = i+2){
      if(i+1 < array.length){
        int temp = array[i];
        array[i] = array[i+1];
        array[i+1] = temp;
      }
    }
  }
}
