public class Solution {
  public int countDigitOne(int n) {
    // ex: 345iXX
    //每一位数有多个digit one
    //ex 数第三位 i
    // case1
    //前三位<=344==> 从000iXX ..344iXX => 一共是 345*100个
    //case2
    //前三位==345
    // i > 1 ==> 一共是100个
    // i == 0 ==> 一共0个
    //i ==1 ==》一个xx+1从（从00开始算，多一位）
    if(n <= 0){
      return 0;
    }
    int res = 0;
    String num = n+"";
    num = new StringBuilder(num).reverse().toString();
    for(int i = 0; i<num.length();i++){
      //case1
      int temp = n/(int)Math.pow(10.00,i+1);
      res += temp*(int)Math.pow(10.00,i);
      int digit = num.charAt(i)-'0';
      //case 2
      if(digit > 1){
        res += (int)Math.pow(10.00,i);
      }else if(digit == 1){
        res += n%(int)Math.pow(10.00, i) + 1;
      }// no need to write the case that digit == 0
    }
    return res;
  }
}
