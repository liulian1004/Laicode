public class Solution {
  public int[] heapify(int[] array) {
    // Write your solution here
    //从最后一个非叶子节点所在的三角形做precolatedown,先从局部开始heapify之后，再往上走继续heapify
    //T： 每一层元素向下看的层数 * 每一层元素的数列
    // T: 2^0 * (k-1) + 2^1 *(k-2) + 2^2 *(k-3)+...+2^(k-2) * 1 =2^k-k-1;(k=logn) = 2(logn) -logn-1 = n
    if(array == null || array.length <=1 ) {
      return array;
    }
    int size = array.length;
    for(int i = size /2 -1; i >= 0; i--){
      percolatedDown(array,i);
    }
    return array;
  }
  private void percolatedDown(int[] array, int index) {
    int size = array.length;
    while(index <= size/2 - 1) {
      int leftIndex = 2 * index +1;
      int rightIndex = 2 * index +2;
      int swapIndex = leftIndex;
        if(rightIndex <= size - 1 && array[rightIndex] < array[leftIndex]) {
          swapIndex = rightIndex;
        }
        if(array[index] > array[swapIndex]) {
          swap(array, index, swapIndex);
        } else {
          break;
        }
        index = swapIndex;
    }
  }

  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
