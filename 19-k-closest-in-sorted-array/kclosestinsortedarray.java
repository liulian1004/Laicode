public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    if(array.length == 0) {
    return new int[]{-1,-1};
  }
  int[] result = new int[k];
  int left = 0;
  int right = array.length - 1;
  while (left < right - 1) {
    int midIndex = left + (right - left) / 2;
    if (array[midIndex] >= target) {
        right = midIndex;
    } else {
       left = midIndex;
    }
  }
  for ( int i = 0; i < k; i++) {
    //1. right out of bound
    //2.|array[left] - target| > |array[right] - target|
  if(right >= array.length || left >= 0 && Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
    result[i] = array[left];
    left--;
    }else {
    result[i] = array[right];
    right++;
    }
  }
  return result;
  }

}
