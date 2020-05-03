public class Solution {
  public int[] merge(int[][] arrayOfArrays) {
    // linear scann the arrayOfArrays
    // put elements into minHeap
    // minHeap.poll() = array[i]
    //T：O(n) -- the number of elements * logn
    //S: O(row)
    PriorityQueue<Element> minHeap = new PriorityQueue<>(new myComparator());
    //用于找到这个matrix有多少个元素
    int length = 0;
    //这里是不规则matrix， 需要用特殊方法traversal
    //traversal 整个第一列，并找到每一行的第一个元素
    for(int i = 0; i < arrayOfArrays.length ;i++){
      //array代表每一个行
      int[] array = arrayOfArrays[i];
      //跟新有多少个元素
      //把每一行有多少个元素都更新进去
      length +=array.length;
      //如果这个行不是空的话，就把这一行的第一个元素放进minheap比大小
      if(array.length != 0) {
        minHeap.offer(new Element(i,0,array[0])); //logn
      }
    }
    //最终需要返回的结果
    int[] array = new int[length];
    int cur = 0;
    while(!minHeap.isEmpty()) {
      Element tmp = minHeap.poll(); // logn
      array[cur++] = tmp.val;
      //traversal这个行，把poll出的元素的下一个元素放进去
      if(tmp.col + 1 < arrayOfArrays[tmp.row].length){
        //跟新tmp并放入minHeap
        tmp.col++;
        //这里的tmp.col已经更新
        //所以直接传入即可
        tmp.val = arrayOfArrays[tmp.row][tmp.col];
        minHeap.offer(tmp);
      }
    }
    return array;
  }
  static class Element{
      int row;
      int col;
      int val;
      Element(int row, int col,int val){
        this.row = row;
        this.col = col;
        this.val = val;
      }
  }
  private static class myComparator implements Comparator<Element> {
    @Override
    public int compare(Element a, Element b) {
      if(a.val == b.val) {
        return 0;
      }
      return a.val < b.val? -1 : 1;
    }
  }

}
