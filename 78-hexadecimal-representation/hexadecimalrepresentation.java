public class Solution {
  public String hex(int number) {
    // consider hexadecimal is 8 * 4 bit
    // hexadeciaml 0x xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx
    if(number == 0) {
      return "0x0";
    }
    char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E','F'};
    StringBuilder sb = new StringBuilder("0x");
    boolean leadingZero = true;
    for(int i = 28; i >=0; i -= 4) {
      // 0xF = 0x 0000 0000 0000 0000 0000 0000 0000 1111
      //(number >> i) & 0xF 这样就能把单独4位拿出来
      //不能number >>i, 只有在最后一组数字才有效，其他情况不能处理之前的几组4位数字
        char cur = base[(number >> i) &0xF];
        //这种写法也可
        //char cur = base[(number >> i) &0b11];
      if( cur != '0' || !leadingZero) {
       sb.append(cur);
       leadingZero = false;
      }
      //sb.append(base[fourDigits]);
    }
    return sb.toString();
  }
}
