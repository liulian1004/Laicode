public class Solution {
  public Solution() {
    // Write your solution here.
  }
  private Deque<Integer> stack1 = new LinkedList<>();
  private Deque<Integer> stack2 = new LinkedList<>();

  public Integer poll() {
    if (stack1.isEmpty()) {
      return null;
    }
    reshuffle(stack1, stack2);
    int result = stack2.pop();
    reshuffle(stack2, stack1);
    return result;
    }

  public void offer(int element) {
    stack1.push(element);
  }

  public Integer peek() {
    if (stack1.isEmpty()) {
      return null;
    }
    reshuffle(stack1, stack2);
    int result = stack2.peek();
    reshuffle(stack2, stack1);
    return result;
  }

  public int size() {
    return stack1.size() + stack2.size();
  }

  public boolean isEmpty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
  public static void reshuffle(Deque<Integer> stack1, Deque<Integer> stack2) {
    while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
  }

}
