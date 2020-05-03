public class Solution {
  public List<String> subSetsOfSizeK(String set, int k) {
    // T: O(2^n * n)
    //S: O(n)
    List<String> list = new ArrayList<>();
    if(set == null || set.length() < k) {
      return list;
    }
    StringBuilder sb = new StringBuilder(); // O(n)
    helper(set, k, list, sb, 0);
    return list;
  }
  private void helper(String set, int k , List<String> list, StringBuilder sb, int index) {
    //base case
    //if length == k, add into list
    if(sb.length() == k) {
      list.add(sb.toString());
      return;
    }
    // if length not is k, just return
    if(index == set.length()) {
      return;
    }
    sb.append(set.charAt(index));
    helper(set, k, list, sb, index + 1);
    sb.deleteCharAt(sb.length() -1);
    helper(set,k, list, sb, index + 1);
  }
}
