public class Solution {
  public String convert(String input, int row) {
    //每一行创建一个stringbuider，把字母append到这一行去
    // direction: -1/1
    // 竖排的时候direction == 1: index从0开始until index = row-1
    // 斜排的时候direction == -1， 从bottom to up， index 从 row-1开始，到0
    // do it again
    //T: O(n)
    if(input == null || input.length() == 0 || row <= 1) {
      return input;
    }
    StringBuilder[] array = new StringBuilder[row];
    // init the strinbuilder array
    for(int i = 0; i < row; i++) {
        array[i] = new StringBuilder();
    }
    int index = 0;
    int direction = -1;
    for(char c: input.toCharArray()){
      // append the char to sb
        array[index].append(c);
      if(index == 0 || index == row -1) {
        //1和-1的转化技巧
        direction = 0 - direction;
      }
      index += direction;
    }
    StringBuilder res = new StringBuilder();
    for(StringBuilder sb: array ) {
      res.append(sb);
    }
    return res.toString();
  }
}
