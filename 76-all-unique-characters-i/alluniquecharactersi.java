public class Solution {
  public boolean allUnique(String word) {
    ////T: O(n); S: O(1)
    // create bitmap in the int(36 bit)
    int bitMap = 0;
    for(char c : word.toCharArray()) {
      //change letter to index, ie 0 = 'a', 2 = 'b'... 25 = 'z'
      int charIndex = c - 'a';
      // check whether the kth is 1 or not
      if( (bitMap & (1 << charIndex)) != 0 ) {
        return false;
      }
      //mark the charIndex in the bitMap
      bitMap += 1<< charIndex;
    }
    return true;
  }
}
