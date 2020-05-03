public class Solution {
  public int atoi(String str) {
    // SPC:: = ' ';
    // NUM:: = '0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9'|'0'
    //['+'|'-'](num+)
    // long overflow and int overflow
    if(str == null || str.length() == 0) {
      return 0;
    }
    int i = 0;
    int s = str.length();
    // no leading space
    while( i < s && str.charAt(i) == ' ') {
      i++;
    }
    // + or -
    boolean signed = true;
    if(i < s && (str.charAt(i) == '-' || str.charAt(i) == '+' )) {
      signed = (str.charAt(i) == '+');
      i++;
    }
    // change digits to integer
    // here sum is absolute valu
    long sum = 0;
    while(i < s && str.charAt(i) >= '0' && str.charAt(i) <= '9' ) {
        sum = sum * 10 + str.charAt(i) - '0';
        // check whether sum will be long overflow
        // it cover for both negative and positive number
        if(sum > (long) Integer.MAX_VALUE + 1) {
          break;
        }
        i++;
    }
    //give signed to sum
    sum = (signed? sum: -sum);
    // check the int overflow
    if(sum > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    if(sum < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }
    // 长变短，需要强制转换
    return (int)sum;
  }
}
