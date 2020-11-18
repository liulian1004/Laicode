public class Solution {
  public int longestConsecutive(int[] array) {
    // Write your solution here
    if(array == null || array.length == 0){
      return 0;
    }
    Arrays.sort(array);
    int beg = array[0];
    int length = 1;
    int res = length;
    for(int i = 1; i < array.length; i++){
      if(array[i] == beg+1){
        length++;
      }else{
        length = 1;
      }
      beg = array[i];
      res = Math.max(res, length);
    }
    return res;
  }
}
