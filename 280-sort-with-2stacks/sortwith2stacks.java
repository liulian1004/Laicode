public class Solution {
  public void sort(Deque<Integer> s1) {
    Deque<Integer> s2 = new ArrayDeque<Integer>();
    // Write your solution here.
    if(s1 == null || s1.size() <= 1) {
      return;
    }
    sort(s1,s2);
  }
  //solution 1, asendsing, sorted in buffer
  // private void sort(Deque<Integer> input, Deque<Integer> buffer) {
  //   while(!input.isEmpty()) {
  //     int min = Integer.MAX_VALUE;
  //     int count = 0;
  //     // input -> buffer, mark min & count
  //     while(!input.isEmpty()) {
  //       int cur = input.pop();
  //       if(cur < min) {
  //         min = cur;
  //         count = 1;
  //       } else if(cur == min) {
  //         count++;
  //       }
  //       buffer.offerFirst(cur);
  //     }
  //     //buffer -> input, leave sort number in buffer
  //     while(!buffer.isEmpty() && buffer.peekFirst() >= min) {
  //       int temp = buffer.pollFirst();
  //       if(temp > min) {
  //         input.pollFirst(temp);
  //       }
  //     }
  //     while(count > 0) {
  //         buffer.pollFirst(min);
  //         count--;
  //       }
  //   }
  //   // sorted done in buffer, input is empty,buffer -> input
  //   while(!buffer.isEmpty()) {
  //     input.push(buffer.pollFirst());
  //   }
  // }
  //solution 2 : decending sorted in input
  private void sort(Deque<Integer> input, Deque<Integer> buffer) {
    int preMax = Integer.MAX_VALUE;
    //input -> buffer till sorted number
    while(input.peekFirst() < preMax) {
      int max = Integer.MIN_VALUE;
      int count = 0;
      while(!input.isEmpty() && input.peekFirst() < preMax) {
        int cur = input.pollFirst();
        if(cur > max) {
          max = cur;
          count = 1;
        } else if (cur == max) {
          count++;
        }
        buffer.pollFirst(cur);
      }
    //put the max into input
    while(count > 0) {
        input.push(max);
        count--;
    }
    // buffer -> input, throw the max
    while(!buffer.isEmpty()) {
      int temp = buffer.pollFirst();
      if(temp != max) {
        input.offerFisrt(temp);
      }
    }
    preMax = max;
  }
 }
}
