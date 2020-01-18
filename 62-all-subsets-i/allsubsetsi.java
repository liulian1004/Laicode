public class Solution {
  public List<String> subSets(String set) {
    // S: O(n)
    //T: 2^n *n (最后一层print每个node时间复杂度是n)
    // 3层，每层加“a或者不加”， b或者不加“，”c或者不加“
    List<String> res = new ArrayList<>();
    if (set == null) {
      return res;
    }
    char[] charSet = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    helper(charSet, 0, sb, res);
    return res;
  }
  private void helper(char[] set, int index, StringBuilder sb, List<String> res) {
    if(index == set.length) {
      res.add(sb.toString());
      return;
    }
    helper(set, index + 1, sb, res);
    helper(set, index + 1, sb.append(set[index]), res);
    sb = sb.deleteCharAt(sb.length() - 1);
  }

}
