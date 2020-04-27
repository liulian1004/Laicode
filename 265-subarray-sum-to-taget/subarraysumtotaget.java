public class Solution {
  public boolean sumToTarget(int[] array, int target) {
    //T: O(n^2), S: O(n)
    int[] sum = new int[array.length+1];
    for(int i = 0; i < array.length;i++) {
        sum[i+1] = sum[i] +array[i];
    }
    for(int i = 1; i <sum.length; i++) {
      for(int j = 0; j<i;j++) {
        if(target == (sum[i]-sum[j])) {
          return true;
        }
      }
    }
    return false;

  }
}
