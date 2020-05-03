public class Solution {
  public void shuffle(int[] array) {
    // Math.random --> [0, 1) 区间内的double
    //i：[1, n]
    // i - 1: 右边界
    //double = 0.9, (int) double = 0;
    //Date Structure: nu-shuffle || shuffled

    if(array == null || array.length == 0) {
  	return;
      }
    int n = array.length;
      // i不能为0, 因为要random的数 * i, ==0结果就是0
    for(int i = n; i > 0; i--) {
      int ran = (int)(Math.random() *i);
      //把已经随机产生过的数换到最右边
      swap(array, ran, i-1);
    }
  }
  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
