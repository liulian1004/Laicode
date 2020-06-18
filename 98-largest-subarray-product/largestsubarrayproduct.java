public class Solution {
  public double largestProduct(double[] array) {
    // curMin: the min subarray product end at current index
    //curMax, the max subarray product end at current index
    double curMin = array[0];
    double curMax = array[0];
    double res = array[0];
    for(int i = 1; i<array.length; i++) {
      double temp = curMax;
      curMax = Math.max(array[i], Math.max(array[i]*curMin, array[i]*curMax));
      curMin = Math.min(array[i], Math.min(array[i]*curMin, array[i]*temp));
      res = Math.max(res, curMax);
    }
    return res;
  }
}
