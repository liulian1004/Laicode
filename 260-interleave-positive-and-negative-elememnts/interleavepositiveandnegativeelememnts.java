public class Solution {
  public int[] interleave(int[] array) {
    // clearifaction: not 0
    // quick sort the arrary as [p,p,p,n,n]
    // swap the array
    // i = 1; j = the first negative element
    //swap(i,j) j++ / i = i + 2
    // termination condition : j > end or i = the first negative element
    //T : O(n) S: O(1)
    if(array == null || array.length == 0) {
      return array;
    }
    int i = 0;
    int j = array.length -1;
    int index = partition(array, i ,j);
    // i points to the first negative element
    helper(array, 1, index);
    return array;
  }
  // i pooint to the first negative number
  private int partition(int[] array, int i, int j) {
    while(i <= j){
      if(array[i] > 0) {
          i++;
      } else{
        swap(array,i, j);
        j--;
      }
    }
    return i;
  }
  private void helper(int[] array, int i, int j) {
    while(i <= array.length - 1 && j <= array.length - 1 && array[i] > 0) {
        swap(array, i, j);
        i = i+2;
        j++;
    }
  }
  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
