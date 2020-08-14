public class Solution {
  public boolean allUnique(String word) {
    // T: O(n) - word.length() S: O(1)
    // create a marix with 8 int (bit: 8 *32)
    // assume the scope of this word is within the ASCII
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
  // my Solution
  //boolean[] array 比 int【】 array所占面积更加小
  //用boolean[] 比较好
  boolean[] flag = new boolean[256];
    for(char c: word.toCharArray()) {
      // char change to Ascii
      int index = (int)c;
      if(flag[index]) {
        return false;
      }
      flag[index] = true;
    }
    return true;
  }
}
