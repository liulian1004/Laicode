public class Solution {
  public int[] heapsort(int[] array) {
    // T: O(nlogn)
    if(array == null || array.length <= 1) {
      return array;
    }
    int size = array.length;
    for(int i = size ; i > 0; i--) {
      heapify(array, i);
      swap(array, 0, i -1);
    }
    return array;
  }
  private void heapify(int[] array, int size) {
    for(int i = size/2-1; i >= 0; i--) {
      percolateDown(i, array, size);
    }
  }
  private void percolateDown(int i, int[] array, int size) {
    while(i <= size/2-1) {
      int left = i*2 + 1;
      int right = i*2 + 2;
      int maxIndex = left;
      if(right < size) {
        if(array[right] > array[left]) {
          maxIndex = right;
        }
      }
      if(array[i] < array[maxIndex]) {
        swap(array,i,maxIndex);
        i = maxIndex;
      }else {
        return;
      }
    }
  }
  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
