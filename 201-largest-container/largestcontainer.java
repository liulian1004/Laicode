public class Solution {
  public int largest(int[] array) {
    // 移动小的那一边
    int max_area = 0;
    int left = 0, right = array.length - 1;
    while (left < right) {
      max_area = Math.max(max_area, Math.min(array[left], array[right]) * (right - left));
      if (array[left] <= array[right]) left++;
      else right--;

    }

    return max_area;
  }
}
