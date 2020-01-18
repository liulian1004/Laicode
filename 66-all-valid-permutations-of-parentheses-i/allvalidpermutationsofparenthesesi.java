public class Solution {
  public List<String> validParentheses(int n) {
    // T：1*2^2n + n* 2^2n = 2n* 2^2n = n * 2 ^2n
    // S：O(2n) = O(n)
    // 2*n 层，2个分支，加“（” 和“加”）“
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    helper(n, 0, 0, sb, res);
    return res;
  }

  private void helper (int n, int left, int right, StringBuilder sb, List<String> res) {
    //left == right == n,打印结果
    if(left == n && right == n) {
      res.add(sb.toString());
      return;
    }
    // left < n， 可以继续加“（”
    if(left < n) {
      helper(n, left +1, right, sb.append('('), res);
      sb = sb.deleteCharAt(sb.length()- 1);
    }
    //right < left, 可以继续加“）”
    if(right < left) {
      helper(n, left, right +1, sb.append(')'), res);
      sb = sb.deleteCharAt(sb.length()- 1);
    }
  }
}
