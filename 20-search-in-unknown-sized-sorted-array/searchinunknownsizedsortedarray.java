public class Solution {
  public int search(Dictionary dict, int target) {
    if (dict == null) {
      return -1;
    }
    int left = 0;
    int right = 1;
    while(dict.get(right) != null && dict.get(right) < target) {
      left = right;
      right = 2*right;
    }
        return findTarget(dict, target, left, right);
    }
    private int findTarget(Dictionary dict, int target, int left, int right) {
        while (left <= right) {
            int midIndex = left + ( right - left) / 2;
            if ( dict.get(midIndex) != null && dict.get(midIndex) == target) {
                return midIndex;
            } else if (dict.get(midIndex) == null || dict.get(midIndex) > target) {
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
        }
        return -1;
    }

}
