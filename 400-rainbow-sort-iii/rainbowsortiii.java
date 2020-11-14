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
    //if(min >= max) 也可
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
//give your 26 chars, sort in place
//swap one by one until in the right position
//T: n^2
private void sort (String[] array) {
  for(int i = 0; i < array.length; i++) {
    char letter = array[i].indexAt(0);
    if(i - 1 >= 0 && array[i-1].indexAt(0) > letter) {
      swap(array, index,letter);
    }
  }
}
private void swap(String[] array, int index, char letter ) {
       while (index - 1 >= 0) {
           char temp = array[index - 1].charAt(0);
           if (temp > letter) {
               String t = array[index];
               array[index] = array[index - 1];
               array[index - 1] = t;
           }
           index--;
       }
   }
