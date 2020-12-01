public class Solution {
  // maxHeap(small half) + 1 (奇数), minHeap(large half)
  // ==> if max_heap.size() > min_heap.size() + 1; ---> min_heap.poll(max_heap.poll())
  // maxHeap <= minHeap  == > if x < max_heap.top() --> max _heap.insert(x)
  // T: nlogn; S: n
  private PriorityQueue<Integer> min;
  private PriorityQueue<Integer> max;
  private int count;

  public Solution() {
    min = new PriorityQueue<>();
    //max = new PriorityQueue<>(new MyComparator());
    max = new PriorityQueue<>(Collections.reverseOrder());
    count = 0;
  }
  private static class MyComparator implements Comparator<Integer>{
    //override需要public
    @Override
    public int compare(Integer a, Integer b) {
      if(a.equals(b)) {
        return 0;
      }
        return a > b? -1 : 1;
      }
  }

  public void read(int value) {
    // corner case
    count++;
    if(max.isEmpty() || value <= max.peek()) {
      max.offer(value);
    } else {
      min.offer(value);
    }
    if(max.size() > min.size() + 1 ) {
      min.offer(max.poll());
    } else if(min.size() > max.size()) {
      max.offer(min.poll());
    }
  }

  public Double median() {
    // corner case
    //不同类别的primitive不能自动转换，如 int 不能自动转成double
    if(count == 0) {
      return null;
    }
    if(count % 2 == 1) {
      return (double)max.peek();
    }
    return (max.peek() + min.peek()) / 2.0;
  }
}
//mysolution
public class Solution {
  PriorityQueue<Integer> large;
  PriorityQueue<Integer> small;
  int count;
  public Solution() {
    // add new fields and complete the constructor if necessary.
    large = new PriorityQueue<>();
    small = new PriorityQueue<>(Collections.reverseOrder());
    count = 0;
  }

  public void read(int value) {
    // write your implementation here.
    if(small.isEmpty() || small.peek() >= value){
      small.offer(value);
    }else{
      large.offer(value);
    }
    if(small.size() - large.size() > 1){
      large.offer(small.poll());
    }else if(large.size() - small.size() > 1){
      small.offer(large.poll());
    }
    count++;
  }

  public Double median() {
    // write your implementation here.
    if(count == 0){
      return null;
    }
    if(count%2 == 0){
      return (small.peek()+ large.peek())/2.0;
    }
    if(small.size() > large.size()){
      return small.peek()*1.0;
    }
    return large.peek()*1.0;
  }
}
//follow up 如果input的数字太多，要放一绝大部分的数字在disk
// small array (disk) | maxHeap | minHeap | large array(disk)
//方法同上题类似
//不同的：
//需要确保 maxValue in the small array is samller than min value of max_heap
//条件不符合要调换位置
// maxHeap满的时候，放一半数字到small array
// 因为如果都放到small array只留下一个element在maxHeap
//后续进入的元素如果比maxHeap小，又要和small array调换位置，浪费时间
