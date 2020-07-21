public class Solution {
  public String addBinary(String a, String b) {
    // T: O(n) S: O(n)
    if(a == null || a.length() == 0) {
      return b;
    }
    if(b == null || b.length() == 0) {
      return a;
    }
    char[] a1 = reverse(a);
    char[] a2 = reverse(b);
    StringBuilder sb = new StringBuilder();
    int[] carry = new int[1];
    int i = 0;
    for(i = 0; i < a1.length && i < a2.length; i++) {
      int sum = (a1[i]- '0') + (a2[i]-'0') + carry[0];
      getSum(sb,sum, carry);
    }
    while(i < a1.length) {
      int sum = (a1[i++]- '0') + carry[0];
      getSum(sb,sum, carry);
    }
    while(i < a2.length) {
      int sum = (a2[i++]- '0') + carry[0];
      getSum(sb,sum, carry);
    }
    if(carry[0] == 1) {
      sb.append(1);
    }
    return sb.reverse().toString();
  }
  private char[] reverse(String s) {
    char[] res = new char[s.length()];
    int j = 0;
    for(int i = s.length()-1; i>=0; i--) {
        res[j++] = s.charAt(i);
    }
    return res;
  }
  private void getSum(StringBuilder sb, int sum, int[] carry) {
    if(sum <= 1) {
      sb.append(sum);
      carry[0] = 0;
    }else if(sum == 2) {
        sb.append(0);
        carry[0] = 1;
     }else {
        sb.append(1);
        carry[0] = 1;
    }
  }
}
