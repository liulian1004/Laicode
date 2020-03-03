public class Solution {
  //全局变量，整个class可以调用
  private static char[] parenthese = new char[]{'(',')','<','>','{','}'};
  public List<String> validParentheses(int l, int m, int n) {
    // T: O(n^2*n) S: O(n)
     List<String> list = new ArrayList<>();
     if(l == 0 && n == 0 && m ==0) {
       list.add("");
       return list;
     }
    //用数组记录左右括号剩余几个
    int[] remain = new int[]{l, l, m, m, n, n};
    //有效permuation的长度
    int length = l*2 + m * 2 + n * 2;
    Deque<Character> stack = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();
    helper(list, remain, length, stack, sb);
    return list;
  }
  private void helper(List<String> list, int[] remain, int length, Deque<Character> stack, StringBuilder sb) {
    if(sb.length() == length) {
      list.add(sb.toString());
      return;
    }
    for(int i = 0; i < parenthese.length; i++) {
      //加左括号
      //左边可以一直加到左边的额度用完
      if(i % 2 == 0) {
        //左边还有
        if(remain[i] > 0) {
          //吃
          sb.append(parenthese[i]);
          stack.offerFirst(parenthese[i]);
          remain[i]--;
          helper(list, remain, length, stack, sb);
          //吐
          sb.deleteCharAt(sb.length() - 1);
          stack.pollFirst();
          remain[i]++;
        }
        //加括号
      } else{
        //只有stack的peek和要加入的左括号配对才加
        //stack poll peak and stack add peak
        if(!stack.isEmpty() && stack.peekFirst() == parenthese[i-1]){
          sb.append(parenthese[i]);
          stack.pollFirst();
          remain[i]--;
          helper(list, remain, length, stack, sb);
          //吐
          sb.deleteCharAt(sb.length() - 1);
          stack.offerFirst(parenthese[i-1]);
          remain[i]++;
        }
      }
    }
  }
}
