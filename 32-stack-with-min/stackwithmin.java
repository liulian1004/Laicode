`1``public class Solution {
  public Solution() {
    // write your solution here
  }
  private Deque<Integer> stack = new LinkedList<>();
  private Deque<Integer> minStack = new LinkedList<>();

  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    int result = stack.pop();
    if ( minStack.peek()== result) {
       minStack.pop();
      }
    return result;
  }

  public void push(int element) {
    stack.push(element);
    if (minStack.isEmpty() || element <= minStack.peek()) {
      minStack.push(element);
    }
  }

  public int top() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.peek();
  }

  public int min() {
    if (minStack.isEmpty()) {
      return -1;
    }
    return minStack.peek();
  }
}
