public class Solution {
  public String remove(String input, String t) {
    // T: O(n)
    //不等于target，slow copy fast， slow++，return [0,s)
    char[] chart = input.toCharArray();
    Set<Character> set = buildSet(t);
    int slow = 0;
    for(int fast = 0; fast < chart.length; fast++) {
      if(!set.contains(chart[fast])) {
        chart[slow] = chart[fast];
        slow++;
      }
    }
    return new String(chart, 0, slow);
  }
  private Set<Character> buildSet(String t) {
    Set<Character> set = new HashSet<>();
    for(int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }
    return set;
  }
}
