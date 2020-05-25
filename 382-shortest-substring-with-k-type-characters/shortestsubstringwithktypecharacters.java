public class Solution {
  public String shortest(String input, int k) {
    //T: O(n) S: O(1)
    if(k == 0 || input == null || input.length() == 0) {
      return "";
    }
    int[] map = new int[26];
    int i = 0;
    int j = 0;
    int count = 0;
    int length = Integer.MAX_VALUE;
    int[] res = new int[2];
    while(j < input.length()) {
      if(map[input.charAt(j) - 'a'] == 0) {
        count++;
      }
      map[input.charAt(j) - 'a']++;
      j++;
      while(count == k && i < j) {
          if(j - i < length) {
            res[0] = i;
            res[1] = j;
            length = j - i;
          }
          if(map[input.charAt(i) - 'a'] == 1) {
            count--;
          }
          map[input.charAt(i) - 'a']--;
          i++;
      }
    }
    if(res[1] <= input.length() -1) {
        return input.substring(res[0], res[1]);
    }
    return input.substring(res[0]);

  }
}
