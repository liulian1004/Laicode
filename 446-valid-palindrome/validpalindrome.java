public class Solution {
  public boolean valid(String input) {
    // T: O(n)
    //大小写字母视为相同的字母
    if(input == null || input.length() <= 1) {
      return true;
    }
    int i =0;
    int j = input.length() - 1;
    while(i <= j) {
      char a = input.charAt(i);
      char b = input.charAt(j);
      a = toLowerCase(a);
      b = toLowerCase(b);
      if(unValid(a)) {
        i++;
      } else if(unValid(b)) {
        j--;
      }else if( a != b) {
          return false;
      }else {
        i++;
        j--;
      }
    }
    return true;
  }
 private boolean unValid(char a) {
    return  a< '0' || a > '9' && a < 'A' || a > 'Z' && a <'a' || a > 'z';
  }
  private char toLowerCase(char a) {
    if( a >= 'A' && a <='Z') {
      a = (char)('a' + (a -'A'));
    }
    return a;
  }
}
