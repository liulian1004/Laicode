public class Solution {
  public String toLowerCase(String str) {
    // Write your solution here
    StringBuilder sb = new StringBuilder();
    for(char c: str.toCharArray()) {
        if(c >= 'A' && c <= 'Z') {

        //注意字母之间的距离算出后要转换成char
        sb.append((char)(c - 'A' + 'a'));
        } else {
          sb.append(c);
        }
    }
    return sb.toString();
  }
}
