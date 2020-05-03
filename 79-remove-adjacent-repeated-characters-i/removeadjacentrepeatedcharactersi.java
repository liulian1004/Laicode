public class Solution {
  public String deDup(String input) {
    // Write your solution here
    if(input == null) {
      return new String();
    }
    char[] array = input.toCharArray();
    //要从0开始，在循环里加一个判断开头的条件，否则要outofbound
    int slow = 0;
    for(int fast = 0; fast < array.length; fast++) {
      if(fast == 0 || array[fast] != array[fast - 1]) {
        array[slow] = array[fast];
        slow++;
      }
    }
    return new String(array, 0, slow);
  }
}
