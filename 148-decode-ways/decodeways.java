public class Solution {
  public int numDecodeWay(String s) {
    //T: O(n) S: O(n)
    // case 1 input.charAt(i) != 0 ==> dp[i] += dp[i-1]
    // case 2 substring(i-1,i+1) is valid ==> dp[i] += dp[i-2]
    int[] dp = new int[s.length()+1];
            dp[0] = 1;
            for(int index = 0; index < s.length(); index++){
                 int one = (int)(s.charAt(index) - '0');
                 if(one >= 1 && one <= 9){
                     dp[index+1] += dp[index];
                 }
                 if(index >= 1){
                     int prev = (int)(s.charAt(index-1) - '0');
                     if(prev == 1
                  || prev == 2 && one >= 0 && one <= 6) {
                         dp[index+1] += dp[index-1];
                     }
                 }
            }
            return dp[s.length()];
      }

  //follow up
  // if stirng contains * and * present 1 - 9
   1* = 19 ； * = 9 ； 2* = 9 + 6 = 15
   case 1
   input.charAt(i) != 0 ==> dp[i] += dp[i-1]
   input.charAt(i) != 0 ==> dp[i] += (dp[i-1] * 9)
   case 2
   substring(i-1,i+1) is valid ==> dp[i] += dp[i-2]
   substring equals(“1*”) ==> dp[i] += (dp[i-2] * 18);
   substring equals(“2*”) ==> dp[i] += (dp[i-2] * 15);
}
//follow up
// print all permuatation
//T: O(n*n) S: O(n)
private List<String> replace(String input) {
        List<String> list = new ArrayList<>();
        if(input.charAt(0) == '0') {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        helper(input, 0, input.length(), sb,list);
        return list;
    }
    private void helper(String input, int i, int length, StringBuilder sb, List<String> list) {
        if(i >= length) {
            list.add(sb.toString());
            return;
        }

        int c1 = Integer.parseInt(input.substring(i,i+1));
        if(c1 != 0) {
            char cur = (char)(c1 + 64);
            sb.append(cur);
            helper(input,i+1,length,sb,list);
            sb.deleteCharAt((sb.length() - 1));
        }else {
           // helper(input,i+1,length,sb,list);
            return;
        }

        if(i+1 <= length - 1) {
            c1 = Integer.parseInt(input.substring(i,i+2));
            if(c1 >= 10 && c1 <= 26) {
                char cur = (char)(c1 + 64);
                sb.append(cur);
                helper(input,i+2,length,sb,list);
                sb.deleteCharAt(sb.length()-1);
            }else {
                //helper(input,i+2,length,sb,list);
                return;
            }
        }
