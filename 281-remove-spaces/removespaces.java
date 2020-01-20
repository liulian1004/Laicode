public class Solution {
  public String removeSpaces(String input) {
    // Write your solution here
    //T: O(n);S: O(n)
    char[] array = input.toCharArray();
    int slow = 0;
    for(int fast = 0; fast < array.length; fast++) {
      //delete the leading and duplicated empty space
      if(array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
        continue;
      }
      array[slow] = array[fast];
        slow++;
    }
    //maybe there will be empty spaces on the trailing,doulbe check the suitaiton
    // check outofbound first
    if(slow > 0 && array[slow - 1] == ' ') {
      slow--;;
    }
    return new String(array, 0, slow);
  }
}
