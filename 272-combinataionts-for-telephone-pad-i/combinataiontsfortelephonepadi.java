public class Solution {
  public String[] combinations(int number) {
    //T: O(n! *n) s:O(n)
    // Assumption : number >= 0
    String[] letter = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    //int --> string --> chararry
    char[] array = Integer.toString(number).toCharArray(); //T: O(n）+O(n); S: O(n)+O(n)
    StringBuilder sb = new StringBuilder();
    List<String> list = new ArrayList<>();
    helper(array, sb, letter, 0,list);
    //list转成array的特殊方式
    return list.toArray(new String[0]);
  }
  private void helper(char[] array, StringBuilder sb, String[] letter, int index, List<String> list) {
      if(index == array.length) {
        list.add(sb.toString()); // O(n)
        return;
      }
      //找到当前index所对应的字母并且转换成char[] array
      //array[index] - '0' --> char --> index
      char[] cur = letter[array[index] - '0'].toCharArray();
      //如果对应的是空，即0 和1的情况，直接进入下一层
      if(cur.length == 0) {
        helper(array, sb, letter, index + 1, list);
        //如过有对应的字母组，走正常dfs流程
      } else {
        for(int i = 0; i < cur.length; i++) {
          sb.append(cur[i]);
          helper(array, sb, letter, index+1, list);
          sb.deleteCharAt(sb.length() - 1);
        }
      }
  }
}
