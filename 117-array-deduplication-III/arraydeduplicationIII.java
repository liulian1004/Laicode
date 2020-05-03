public class Solution {
  public int[] dedup(int[] array) {
    //fast1 points to the current index of ready to process
    //slow - 1 points to the index which has been scannedn and keep/
    // fast2 = fast1+ 1, for calcualate the group range which shall be removed
    //if fast2- fast1 > 1, fast1 = fast2;
    if(array.length <= 1) {
      return array;
    }
    int slow = 0;
    int fast1 = 0;
    while(fast1< array.length) {
      int fast2 = fast1 + 1;
      while(fast2 <array.length && array[fast1] == array[fast2]) {
        fast2++;
      }
      //没有重复的元素/group存在
      if(fast2 - fast1 == 1) {
        array[slow] = array[fast1];
        slow++;
        fast1++;
        //有重复元素/group不存在
      } else {
          fast1 = fast2;
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
