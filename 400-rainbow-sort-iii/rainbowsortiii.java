public class Solution {
  public int[] rainbowSortIII(int[] array, int k) {
    // 按k进行binary search ; logk层，每一层linear scan n
    //T: nlogk; S： logk
    //quick sort变种
    if(array == null || array.length<= 1 || k <= 1) {
      return array;
    }
    helper(array, 0, array.length -1, 0, k);
    return array;
  }
  // min/max用于计算中间值
  private void helper(int[] array, int left, int right, int min, int max) {
    if(left >= right || min >= max) {
      return;
    }
    int mid = min + (max - min) / 2;
    int i = left;
    int j = right;
    while(i <= j) {
        if(array[i] <= mid) {
          i++;
        } else {
          swap(array, i, j);
          j--;
        }
    }
    helper(array, left, j, min, mid);
    helper(array, i, right, mid+1, max);
  }
  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
