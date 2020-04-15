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
  //solution 2
  public class Solution {
  Deque<Integer> stack;
  Deque<Integer> min;
  //map<cur min element, the size of stack>
  //优化min的空间，用一个map代替重复的元素
  //适用于有很多重复的元素
  Map<Integer, Integer> map;
  public Solution() {
    stack = new ArrayDeque<>();
    min = new ArrayDeque<>();
    map = new HashMap<>();
  }
  public int pop() {
    if(stack.isEmpty()) {
      return -1;
    }
    int size = stack.size();
    int cur = stack.pollFirst();
    if(min.peekFirst() == cur && size == map.get(cur)) {
      min.poll();
      map.remove(cur);
    }
    return cur;
  }

  public void push(int element) {
    stack.offerFirst(element);
    if(min.isEmpty() || (min.peekFirst() > element && !map.containsKey(element))) {
        min.offerFirst(element);
        map.put(element, stack.size());
    }
  }

  public int top() {
    if(stack.isEmpty()) {
      return -1;
    }
    return stack.peekFirst();
  }

  public int min() {
    if(min.isEmpty()) {
      return -1;
    }
    return min.peekFirst();
  }
}
