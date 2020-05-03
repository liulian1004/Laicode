public class Solution {
  public String decompress(String input) {
    //T: O(n);S:O(n)
    char[] array = input.toCharArray();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < array.length; i++) {
      char letter = array[i];
      i++;
      //transfer chart to digits;
      int count = array[i] - '0';
      for(int j = count; j > 0; j--) {
        //在forloop里面循环append letter
        //在外面先append会出现digit是0的情况，就不需要加letter了
        sb.append(letter);
      }
    }
    return sb.toString();
  }
}
