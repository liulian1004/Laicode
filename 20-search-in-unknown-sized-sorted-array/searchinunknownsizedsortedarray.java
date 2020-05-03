public class Solution {
  public int search(Dictionary dict, int target) {
    if (dict == null) {
      return -1;
    }
    int left = 0;
    int right = 1;
    // 2^k = n ==> k = logn
    while(dict.get(right) != null && dict.get(right) < target) {
      left = right + 1;
      right = 2*right;
    }
        return findTarget(dict, target, left, right);
    }
    private int findTarget(Dictionary dict, int left, int right, int target) {
  while(left <= right) {
    int midIndex = left + (right - left) / 2;
    //exclude the null first， otherwise NPE
    if(dict.get(midIndex) == null || dict.get(midIndex) > target ) {// 先把null排除掉
      right = midIndex - 1;
    } else if(dict.get(midIndex) < target) {
      left = midIndex + 1;
    } else {
      return midIndex;

    }
    return -1;

}
