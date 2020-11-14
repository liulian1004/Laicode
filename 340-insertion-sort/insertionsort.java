public class Solution {
  public int[] sort(int[] array) {
    // T: O(n^2) S: O(1)
    // array[i] 和之前的数比较，如果不在正确的位置，就swap 直到sort
    // ie 6 7 1
    // step 1: 7 和 1交换 => 6, 1,7
    //step 2: 1 和 6交换 => 1, 6, 7
    // step 2： i move 到下一个节点
    if(array == null || array.length <= 1){
      return array;
    }
    for(int i = 1; i < array.length; i++){
      if(array[i] < array[i-1]){
        int k = i;
        while(k > 0 && array[k] < array[k-1]){
          int temp = array[k];
          array[k] = array[k-1];
          array[k-1] = temp;
          k = k -1;
        }
      }
    }
    return array;
  }
}
