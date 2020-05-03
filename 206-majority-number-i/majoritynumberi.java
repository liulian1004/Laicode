public class Solution {
  public int majority(int[] array) {
    // voting algorthim
    // A > 50&
    //count present one number's number
    //if count == 0 , change the candidiate
    //T O(n) S O(1)
    if(array == null || array.length == 0) {
      return 0;
    }
    int count = 0;
    int candidate = array[0];
    for(int i = 0; i<array.length; i++) {
        if(array[i] == candidate) {
          count++;
        } else if(array[i] != candidate & count > 0) {
          count--;
        } else if(count == 0) {
            candidate = array[i];
        }
    }
    return candidate;

  }
}
