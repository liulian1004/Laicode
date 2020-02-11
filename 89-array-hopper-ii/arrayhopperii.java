import java.util.Arrays;

public class Solution {
  public int minJump(int[] array) {
    // Array is not null/empty
    //T: O(n^2); S: O(n);
    //到达第i-index所需要的最短步骤
    int[] m = new int[array.length];
    Arrays.fill(m, -1);
    m[0] = 0;
    //从i出发能跳到的后面所有格子，每一个格子j累计的最短步骤
    for(int i = 0; i < array.length - 1; i++) {
      //注意j不要跳出array.length的范围
        for(int j = i + 1; j <= i + array[i] && j <= array.length - 1; j++) {
          if(m[j] == -1) {
            m[j] = m[i] + 1;
          } else {
            m[j] = Math.min(m[i] + 1, m[j]);
          }
        }
        //只要m[i] 出现 -1，就直接终止返回-1, 说明跳不到
        if(m[i] == -1) {
           return -1;
        }
    }
    return m[array.length -1];
  }
}
// standard Solution
public int minJump(int[] array) {
    //m[i] represt the min Jump steps from 0 to index i;
    // not reacheable is -1;
    int n = array.length;
    int[] m = new int[n];
  m[0] = 0;
  for(int i = 1; i < n; i++) {
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
