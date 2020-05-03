public class Solution {
  //Space： O(1) Time: o(1), worst case o(n) Amoritzie = (O(n) +O(n)+O(1) + O(1) * O（n-1)) / n
  Deque<Integer> input;
	Deque<Integer> buffer;
  public Solution() {
    input = new ArrayDeque<>();
	  buffer = new ArrayDeque<>();
  }
  public Integer poll() {
    move();
    return buffer.isEmpty()? null : buffer.pollFirst();

  }

  public void offer(int element) {
    input.offerFirst(element);
  }

  public Integer peek() {
    move();
    return buffer.isEmpty()? null : buffer.peekFirst();
  }

  public int size() {
    return input.size() + buffer.size();
  }

  public boolean isEmpty() {
    return input.isEmpty() && buffer.isEmpty();
  }
  private void move() {
    if(buffer.isEmpty()) {
      while(!input.isEmpty()) {
      buffer.offerFirst(input.pollFirst());
      }
    }
  }
}
