public class Solution {
  public int[] reorder(int[] array) {
    // Write your solution here
    if(array.length % 2 == 0) {
      helper(array, 0, array.length - 1);
    } else {
      helper(array, 0 , array.length - 2);
    }
    return array;
  }
  private void helper(int[] array, int left, int right) {
    int length = right - left + 1;
    if(length <= 2) {
      return;
    }
    int m = left + length / 2;
    int lm = left + length / 4;
    int rm = left + length * 3 / 4;
    reverse(array, lm, m - 1);
    reverse(array, m, rm - 1);
    reverse(array, lm, rm - 1);
    //make sure the swap group matches => a | bc | 1 | 23 => a1 | bc23
    helper(array, left, left + (lm- left) * 2 - 1);
    helper(array, left + (lm- left) * 2, right);
  }
  private void reverse(int[] array, int i, int j) {
      while(i < j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
      }
  }
}
