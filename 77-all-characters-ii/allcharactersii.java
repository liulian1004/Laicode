public class Solution {
  public boolean allUnique(String word) {
    // T: O(n) - word.length() S: O(1)
    // create a marix with 8 int (bit: 8 *32)
    int[] array = new int[8];
    for(char c: word.toCharArray()) {
      // check on the k row, whether the kth position is 1 or not
      if(((array[c / 32] >> (c % 32 )) & 1) != 0) {
        return false;
      }
      // mark the kth as 1 in the its row
      array[c / 32] |= 1 << (c %32);
    }
    return true;
  }
}
