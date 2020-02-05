public class Solution {
  public boolean canJump(int[] array) {
    // T: O(n) ;S O(1)
    //jump from right to left, it's true if it can reach index 0
    //corner, null/empty does not exit
    if(array.length == 1) {
      return true;
    }
    //boolean[] 的默认值是false
     boolean[] jump = new boolean[array.length];
     for(int i = array.length - 2; i >= 0; i--) {
      //能直接跳到最后一个index
      if(array[i] + i >= array.length - 1) {
        jump[i] = true;
        //能跳到下一个为true的index
      } else {
        for(int j = array[i]; j >= 0; j--) {
          if(jump[j + i]) {
            //如果跳到true，就不用往下走
            jump[i] = true;
            break;
          }
        }
      }
    }
    return jump[0];
    }
}
