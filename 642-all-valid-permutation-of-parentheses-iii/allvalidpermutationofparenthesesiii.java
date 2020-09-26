public class Solution {
  public List<String> validParenthesesIII(int l, int m, int n) {
    // T: 6*the max(l,m,n) S: the max (l,m,n)
    //stack用于看之前的permutation的状态
    char[] base = new char[]{'(',')','<','>','{','}'};
    int[] array = new int[]{l,l,m,m,n,n};
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int length = (n+m+l)*2;
    Deque<Integer> stack = new ArrayDeque<>();
    helper(list,sb,base,array,length,stack);
    return list;
  }
  private void helper(List<String> list, StringBuilder sb, char[] base,int[] array, int length, Deque<Integer> stack){
      if(sb.length() == length){
        list.add(sb.toString());
        return;
      }
      for(int i = 0; i < array.length ;i++){
        int value = array[i];
        if(value > 0 && i % 2 == 0){
          //这里的规定是不能（（）），必须（）（）
          //所以到了下一层 append新的符号，stack.peekfirst的i必须要比之前的大，至少大一
          if(stack.isEmpty() || stack.peekFirst() > i){
            stack.offerFirst(i);
            sb.append(base[i]);
            array[i]--;
            helper(list,sb,base,array,length,stack);
            stack.pollFirst();
            sb.deleteCharAt(sb.length()-1);
            array[i]++;
          }
        }else if(i%2 == 1){
          if(!stack.isEmpty() && stack.peekFirst() + 1 == i){
            stack.pollFirst();
            sb.append(base[i]);
            array[i]--;
            helper(list,sb,base,array,length,stack);
            stack.offerFirst(i-1);
            sb.deleteCharAt(sb.length()-1);
            array[i]++;
          }

        }
      }


  }
}
