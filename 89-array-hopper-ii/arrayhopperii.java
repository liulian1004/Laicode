import java.util.Arrays;

public class Solution {
  public int minJump(int[] array) {
    //Assumpt non-negative integer
    //m[i] represt the min Jump steps from 0 to index i;
    // induction rule: m[i] = 1 + minstep of m[j] j = i-1]
    //T: O(n^2); S: O(n);

    // not reacheable is -1;
    int n = array.length;
    int[] m = new int[n];
  m[0] = 0;
  for(int i = 1; i < n; i++) {
    //in case can't jump to this step
    m[i] = -1;
    for(int j = i - 1; j >= 0; j--) {
      //从j能够跳到i并且j已经被能够跳到
      if(j + array[j] >= i && m[j] != -1) {
        // i要么之前没有被跳过，要么之前跳过的步数比后面可以更新的步数更加大
        //替换成新的步数
          if(m[i] == -1 || m[i] > m[j] + 1) {
            m[i] = m[j] + 1;
          }
      }
    }
  }
  return m[n-1];
}
