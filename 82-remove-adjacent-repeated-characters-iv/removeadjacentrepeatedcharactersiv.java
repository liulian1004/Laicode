public class Solution {
  public String deDup(String input) {
    // T: O(n); S:O(n)
    //virtual stack
    //初始状态 end = 0, stack已经装有一个element， i从1开始和stack内的元素比较
    //每次poll/pop都先需要移动end状态
    if(input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    int slow = 0;
    //start from the second element
    for(int fast = 1; fast <array.length; fast++) {
      //when stack is empty or the peek  of stack != fast
      if(slow == -1 || array[slow] != array[fast]) {
        slow++;
        array[slow] = array[fast];
        // the peek of stack == fast
      } else {
        // pop the peek
        slow--;
        // move the fast to the last duplucated char,
        // consider the out of bound first
        //the for loop will move fast to the first non duplicated element
        while(fast + 1 < array.length && array[fast] == array[fast+1] ) {
          fast++;
        }
      }
    }
      // return [0,slow]
      return new String(array, 0 , slow+1);
  }
}
