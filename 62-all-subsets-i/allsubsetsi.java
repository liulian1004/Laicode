public class Solution {
  public List<String> subSets(String set) {
    // S: O(n)
    //T: 2^n + 2^n * n = 2^n *n
    // 3层，每层加“a或者不加”， b或者不加“，”c或者不加“
    // set是空的时候，也要返回一个包括“ ”的list，不需要包括到corner case
    List<String> res = new ArrayList<>();
    if (set == null) {
      return res;
    }
    StringBuilder sb = new StringBuilder();
    char[] array = set.toCharArray();
    int index = 0;
    subSets(res, sb, 0, array);
    return res;

  }
  private void subSets(List<String> res, StringBuilder sb, int index, char[] array) {
    //这里index已经+1 所以要多加一才能出来
    // T：2^n * n 最后一层print每个node时间复杂度是n，因为sb.toString
    if(index == array.length) {
      res.add(sb.toString());
      return;
    }

    //T: base case之前是 2^0+2^1+2^2+...2^(n-1) = 2^n
    //加array内的字母，吃
    sb = sb.append(array[index]);
    //traveral left
    subSets(res, sb, index + 1, array);
    //吐
    sb = sb.deleteCharAt(sb.length() - 1);
    //traversal right
    subSets(res, sb, index + 1, array);
    }
}
