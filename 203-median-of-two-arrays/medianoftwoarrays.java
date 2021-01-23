public class Solution {
  public double median(int[] a, int[] b) {
    // Write your solution here
    PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> bigger = new PriorityQueue<>();
    for(int i: a){
            if(smaller.isEmpty() || i <= smaller.peek()){
                smaller.offer(i);
            }else {
                bigger.offer(i);
            }
            if(smaller.size() > bigger.size()+1){
                bigger.offer(smaller.poll());
            }else if(bigger.size()> smaller.size()+1){
                smaller.offer(bigger.poll());
            }
        }
        for(int i: b){
            if(smaller.isEmpty()|| i <= smaller.peek()){
                smaller.offer(i);
            }else{
                bigger.offer(i);
            }
            if(smaller.size() > bigger.size()+1){
                bigger.offer(smaller.poll());
            }else if(bigger.size() > smaller.size()+1){
                smaller.offer(bigger.poll());
            }
        }
        if(smaller.size() == bigger.size()){
            return (smaller.peek()+ bigger.peek())/2.0;
        }
        if(smaller.size() > bigger.size()){
          return smaller.peek()*1.0;
        }
        return bigger.peek()*1.0;

  }
}
