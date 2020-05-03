public class Solution {
  Deque<Integer> left;
  Deque<Integer> right;

  public Solution() {
    // T:Amortized O(1).
    left = new ArrayDeque<>();
    right = new ArrayDeque<>();

  }

  public void offerFirst(int element) {
    left.offerFirst(element);
  }

  public void offerLast(int element) {
    right.offerFirst(element);
  }

  public Integer pollFirst() {
    move(right, left);
	  return left.isEmpty()? null : left.pollFirst();
  }

  public Integer pollLast() {
    move(left, right);
	  return right.isEmpty()? null : right.pollFirst();

  }

  public Integer peekFirst() {
    move(right, left);
	  return left.isEmpty()? null : left.peekFirst();
  }

  public Integer peekLast() {
    move(left, right);
    return right.isEmpty()? null : right.peekFirst();

  }

  public int size() {
    return left.size() + right.size();
  }

  public boolean isEmpty() {
    return left.isEmpty() && right.isEmpty();
  }

  private void move(Deque<Integer> scr, Deque<Integer> dest) {
      while(!dest.isEmpty()) {
      return;
    }
    Deque<Integer> buffer = new ArrayDeque<>();
    int halfSize = scr.size() / 2;
    for(int i = 0; i< halfSize; i++) {
      buffer.offerFirst(scr.pollFirst());
    }
    while(!scr.isEmpty()) {
      dest.offerFirst(scr.pollFirst());
    }
    while(!buffer.isEmpty()) {
      scr.offerFirst(buffer.pollFirst());
    }
}

}
