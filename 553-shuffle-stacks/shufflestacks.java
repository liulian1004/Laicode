class Solution {
	public void shuffle(Deque<Integer> stack1, Deque<Integer> stack2) {
    while(!stack2.isEmpty()) {
      stack2.pop();
    }
    while (!stack1.isEmpty() ) {
      stack2.push(stack1.pop());
    }
	}
}
