public class Solution {
  public int longestValidParentheses(String input) {
    // T： O(n) s:o(1)
    // put index into stack
    // case 1 cur = (
    // case 2 cur = ) && no match ( in the stack
    //After poll , if stack is empty, reset the start to -1
    // ex: ()()
    if(input == null || input.length() <= 1) {
      return 0;
    }
    Deque<Integer> stack = new ArrayDeque<>();
    int i = 0;
    int res = 0;
    while(i < input.length()) {
      char cur = input.charAt(i);
      if(cur == '(' || (cur == ')' && (stack.isEmpty() || input.charAt(stack.peekFirst()) != '('))){
        stack.offerFirst(i);
      }else if(!stack.isEmpty() && input.charAt(stack.peekFirst()) == '('){
          stack.pollFirst();
          int start = -1;
          if(!stack.isEmpty()){
            start = stack.peekFirst();
          }
          res = Math.max(i - start, res);
      }
     i++;
    }
    return res;
  }
}
