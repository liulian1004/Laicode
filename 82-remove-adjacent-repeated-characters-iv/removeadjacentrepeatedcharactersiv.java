public class Solution {
  public String deDup(String input) {
    // T: O(n); S:O(n)
    //virtual stack
    //初始状态 end = 0, stack已经装有一个element， i从1开始和stack内的元素比较
    //每次poll/pop都先需要移动end状态
    if(input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray(); // O(n)
    int j = 0;
    //start from the second element
    for(int i = 0; i < array.lenght; i++) {
      //when stack is empty or the peek  of stack != fast
      if(j == 0 || array[j-1] != array[i]) {
        array[j] = array[fast];
        j++;
        // the peek of stack == fast
      } else if {
        // pop the peek
        j--;
        // move the fast to the last duplucated char,
        // consider the out of bound first
        //the for loop will move fast pointer which is  the last duplicated elements
        while(i + 1 < array.length && array[i] == array[i+1] ) {
          i++;
        }
      }
    }
      // return [0,slow]
      //return(array, i, j) ==> array[i,j-1]
      return new String(array, 0 , j);
  }
}
//follow up revmove k adjacent Characters
private String wordCompression(String s, int k){
        Deque<Cell> stack = new ArrayDeque<>();
        for(char cur: s.toCharArray()){
            if(stack.isEmpty() || stack.peekFirst().ch != cur){
                stack.offerFirst(new Cell(cur,1));
            }else if(stack.peekFirst().ch == cur){
                int time = stack.peekFirst().time;
                stack.offerFirst(new Cell(cur,time+1));
            }
            if(stack.peekFirst().time == k){
                int pollTime = k;
                while(pollTime > 0){
                    stack.pollFirst();
                    pollTime--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollFirst().ch);
        }
        return sb.reverse().toString();
    }
    static class Cell{
        Character ch;
        int time;
        Cell(Character ch,int time){
            this.ch = ch;
            this.time = time;
        }
    }
