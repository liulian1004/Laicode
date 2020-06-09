public class Solution {
  public int longestValidParentheses(String input) {
    // T： O(n) s:o(1)
    // only update the length when find the valid pair
    //stack record the index of before the pair
    if(input == null || input.length() <= 1) {
      return 0;
    }
    Deque<Integer> stack = new ArrayDeque<>();
    int i = 0;
    int res = 0;
    //initial stack
    stack.offerFirst(-1);
    while(i < input.length()) {
      if(input.charAt(i) == '(') {
          stack.offerFirst(i);
      }else if(input.charAt(i) == ')' && stack.size() > 1 && input.charAt(stack.peekFirst()) == '(') {
          stack.pollFirst();
          res = Math.max(res, i - stack.peekFirst());
      }
     i++;
    }
    return res;
  }
}
