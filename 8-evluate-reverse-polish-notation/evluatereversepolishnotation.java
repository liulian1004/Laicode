public class Solution {
  public int evalRPN(String[] tokens) {
    // stack:
    // number : add into stack
    // operation: pop two numbers and work with operation, then put the result into stack
    Deque<Integer> stack = new ArrayDeque<>();
    for(String s: tokens){
        if(s.equals("+")){
          int num1 = stack.pollFirst();
          int num2 = stack.pollFirst();
          stack.offerFirst(num2+num1);
        }else if(s.equals("-")){
          int num1 = stack.pollFirst();
          int num2 = stack.pollFirst();
          stack.offerFirst(num2-num1);
        }else if(s.equals("*")){
          int num1 = stack.pollFirst();
          int num2 = stack.pollFirst();
          stack.offerFirst(num2*num1);
        }else if(s.equals("/")){
          int num1 = stack.pollFirst();
          int num2 = stack.pollFirst();
          stack.offerFirst(num2/num1);
        }else{
          stack.offerFirst(Integer.valueOf(s));
        }
    }
    return stack.pollFirst();
  }
}
