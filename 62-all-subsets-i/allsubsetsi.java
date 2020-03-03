public class Solution {
  public List<String> subSets(String set) {
    // S: O(n)
    //T: 2^n + 2^n * n = 2^n *n
    //看最后一层的时间复杂度
    // 3层，每层加“a或者不加”， b或者不加“，”c或者不加“
    // set是空的时候，也要返回一个包括“ ”的list，不需要包括到corner case
    List<String> res = new ArrayList<>();
    if (set == null) {
      return res;
    }
    StringBuilder sb = new StringBuilder();
    int index = 0;
    subSets(res, sb, 0, set;
    return res;

  }
  private void subSets(List<String> res, StringBuilder sb, int index, String set) {
    //这里index已经+1 所以要多加一才能出来
    // T：2^n * n 最后一层print每个node时间复杂度是n，因为sb.toString
    if(index == sb.length()) {
      res.add(sb.toString()); // O(n)
      return;
    }

    //T: base case之前是 2^0+2^1+2^2+...2^(n-1) = 2^n
    //加array内的字母，吃
    sb.append(sb.charAt(index)); //O(1)
    //traveral left
    subSets(res, sb, index + 1, set);
    //吐
    sb.deleteCharAt(sb.length() - 1);
    //traversal right
    subSets(res, sb, index + 1, set);
    }
}
