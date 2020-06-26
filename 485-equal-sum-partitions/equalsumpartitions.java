public class Solution {
  public int getMinEqualSumPartition(int N, int[] X) {
    //N只有N个数
    //T: O(n^2) S: O(1)
    if(X == null || X.length == 0) {
      return -1;
    }
    int sum = 0;
    for(int i: X) {
      sum += i;
    }
    int min = sum;
    for(int i = 1; i <= N; i++) {
      int subSum = 0;
      for(int j = 0; j <i; j++) {
        subSum +=X[j];
      }
      if(sum % subSum == 0) {
        if(canPartition(subSum, X, i)) {
           min = Math.min(subSum, min);
        }
      }
    }
    return min;
  }
  private boolean canPartition(int sum, int[] X, int index) {
    int subSum = 0;
    for(int i = index; i <= X.length-1; i++) {
      subSum += X[i];
      if(subSum < sum) {
        continue;
      }else if(subSum == sum) {
        subSum = 0;
      }else if(subSum > sum) {
        return false;
      }
    }
    if(subSum == 0) {
      return true;
    }
    return false;
  }
}
