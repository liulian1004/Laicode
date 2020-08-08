public class Solution {
  public int[] rainbowSortIII(int[] array, int k) {
    // 按k进行binary search ; logk层，每一层linear scan n
    //T: nlogk; S： logk
    //quick sort变种
    // min/max用于计算中间值
    if(array == null || array.length <= 1) {
      return array;
    }
    helper(array, 1, k, 0, array.length -1);
    return array;
  }
  private void helper(int[] array, int min, int max, int left, int right) {
    if(left >= right || min >= max) {
      return;
    }
    int m = min + (max-min)/2;
    int i = left;
    int j = right;
    while(i <= j) {
      if(array[i] <= m){
        i++;
      }else{
        swap(array, i, j--);
      }
    }
    helper(array, min, m, left, j);
    helper(array, m+1, max,i, right);
  }
  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
