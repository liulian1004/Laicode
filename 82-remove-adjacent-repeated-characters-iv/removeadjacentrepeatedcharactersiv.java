public class Solution {
  public String deDup(String input) {
    // T: O(n); S:O(n)
    //virtual stack
    //初始状态 end = 0, stack已经装有一个element， i从1开始和stack内的元素比较
    //每次poll/pop都先需要移动end状态
    if(input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray(); // O(n)
    int slow = 1;
    //start from the second element
    while(j < array.length) {
      //when stack is empty or the peek  of stack != fast
      if(slow == 0 || array[slow-1] != array[fast]) {
        array[slow] = array[fast];
        slow++;
        // the peek of stack == fast
      } else if(array[fast] == array[slow-1]) {
        // pop the peek
        slow--;
        // move the fast to the last duplucated char,
        // consider the out of bound first
        //the for loop will move fast pointer which is  the last duplicated elements
        while(fast + 1 < array.length && array[fast] == array[fast+1] ) {
          fast++;
        }
        fast++;
      }
    }
      // return [0,slow]
      //return(array, i, j) ==> array[i,j-1]
      return new String(array, 0 , slow+1);
  }
}
