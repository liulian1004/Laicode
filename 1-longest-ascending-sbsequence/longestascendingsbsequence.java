public class Solution {
  public int longest(int[] array) {
    // M[i] presents the longest ascending subsequence from 0 to i;
    // initalize: m[i] = 1;
    // induction rule: linear scan and look back
    //to look for an element which smaller than array[i].
    //If it does exit, update the  m[i] of Math.max(m[i], m[i] + 1)
    // each loop,update the max of M[i]

    //T: O(n^2); SO(1)
    int result  = 0;
    if(array == null || array.length == 0) {
      return result;
    }
    int[] m = new int[array.length];
    for(int i = 0; i < array.length; i++) {
      //base case
      m[i] = 1;
      //linear scan and look back
      for(int j = 0; j < i; j++) {
        if(array[j] < array[i]) {
          m[i] = Math.max(m[j] + 1, m[i]);
        }
      }
      result = Math.max(result, m[i]);
    }
    return result;
  }
}
