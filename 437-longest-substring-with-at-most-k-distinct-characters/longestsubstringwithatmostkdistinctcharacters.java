public class Solution {
  public int lengthOfLongestSubstringKDistinct(String input, int k) {
    // T: O(2n)
    if(input == null || input.length() == 0 || k <= 0) {
      return 0;
    }
    int[] map = new int[128];
    int i = 0;
    int j = 0;
    int ans = Integer.MIN_VALUE;
    int count = 0;
    while(j < input.length()) {
      if(map[input.charAt(j)] == 0) {
        count++;
      }
      map[input.charAt(j)]++;
      j++;
      while(count > k) {
        //anti case： cfggg
        //ans = Math.max(ans, j - i);
        if(map[input.charAt(i)] == 1) {
          count--;
        }
        map[input.charAt(i)]--;
        i++;
      }
      //ask for at most k，so if count > k, it's not valid substring
      //j走最后一轮是outofscope,多一个1,所以这里不需要-1
      ans = Math.max(ans, j - i);
    }
    return ans;
  }
}
