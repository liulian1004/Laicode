public class Solution {
  public boolean isValid(String input) {
    // T: O(n) S: O(n)
    if(input == null || input.length() == 0) {
      return true;
    }
    Deque<Character> queue = new ArrayDeque<>();
    for(int i = 0; i < input.length(); i++) {
      char cur = input.charAt(i);
      if(cur == '(' || cur == '{' || cur== '[') {
        queue.offerFirst(cur);
      } else if(cur == ')') {
        if(queue.isEmpty() || queue.peekFirst() != '(') {
          return false;
        } else{
          queue.pollFirst();
        }
      } else if(cur == '}') {
        if(queue.isEmpty() ||queue.peekFirst() != '{') {
          return false;
        }else {
          queue.pollFirst();
        }
      } else if(cur == ']') {
        if(queue.isEmpty() ||queue.peekFirst() != '[') {
          return false;
        }else{
          queue.pollFirst();
        }
      }
    }
    if(!queue.isEmpty()) {
      return false;
    }
    return true;
  }
}
