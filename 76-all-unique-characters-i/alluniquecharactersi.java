public class Solution {
  public boolean allUnique(String word) {
    ////T: O(1); S: O(1)
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
// mysolution
public boolean allUnique(String word) {
    // map represent a 32 binary form
    int map = 0;
    for(int i = 0; i <word.length(); i++) {
      int index = word.charAt(i) - 'a';
      //check the i bit is 1 or not
      //if already 1， it means this char is not unqiue，return false
      if((map>>index&1) == 1){
        return false;
      }
      map +=(1<<index);
    }
    return true;
  }
