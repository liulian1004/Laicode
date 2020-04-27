public class Solution {
  public boolean canJump(int[] array) {
    //Assumpt non-negative integer
    // T: O(n^2) ;S O(n)
    //jump from right to left, it's true if it can reach index 0
    //corner, null/empty does not exit
    if(array.length == 1) {
      return true;
    }
    //boolean[] 的默认值是false
     boolean[] jump = new boolean[array.length];
     for(int i = array.length - 2; i >= 0; i--) {
      //能直接跳到最后一个index
      //不添加这个条件，后面jump[i+j]会NPE
      if(array[i] + i >= array.length - 1) {
        jump[i] = true;
        //能跳到下一个为true的index
        //必须要一个个跳，因为后面有几位有可能位false
        //并且要从能达到的最后一位往前跳
        //这里只要看第一位是不是true即可
      } else {
        for(int j = array[i]; j >= 1; j--) {
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
