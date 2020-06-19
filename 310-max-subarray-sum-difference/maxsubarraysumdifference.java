public class Solution {
  public int maxDiff(int[] array) {
    // maxsubarray/min subarray from [0,i] & from[i+1, n-1]
    //res = Math.max(|maxsubarray[0,i]-minsubarray[i+1,n-1]|, |minsubarray[0,i]-maxsubarray[i+1,n-1]|)
    //T: O(n^2) s: O(1)
    int res = Integer.MIN_VALUE;
    for(int i = 0; i < array.length-1; i++) {
      int min1 = subarrayMin(array, 0,i);
      int max1 = subarrayMax(array,0,i);
      int min2 = subarrayMin(array, i+1, array.length-1);
      int max2 = subarrayMax(array, i+1, array.length-1);
      res = Math.max(res, Math.max(Math.abs(min1 - max2), Math.abs(max1-min2)));
    }
    return res;
  }
  private int subarrayMin(int[] array, int i, int j) {
    int res = array[i];
    int min = array[i];
    for(int k = i+1; k <= j; k++) {
        min = Math.min(min + array[k], array[k]);
        res = Math.min(res, min);
    }
    return res;
  }
  private int subarrayMax(int[] array, int i, int j) {
    int res = array[i];
    int max = array[i];
    for(int k = i+1; k <= j; k++) {
      max = Math.max(max+array[k], array[k]);
      res = Math.max(res, max);
    }
    return res;
  }
}
