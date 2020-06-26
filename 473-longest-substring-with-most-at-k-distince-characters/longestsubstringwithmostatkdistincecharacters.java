public class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    // T: O(n)
    if(s == null || s.length() == 0 || k <= 0) {
      return 0;
    }
    if(k >= s.length()) {
      return s.length();
    }
int i = 0;
int j = 0;
int[] base = new int[256];
int count = 0;
int max = 0;
while(i < s.length()) {
	char cur = s.charAt(i);
	if(base[cur - 'a'] == 0) {
	  count++;
  }
  base[cur-'a']++;
  if(count <= k) {
	  max = Math.max((i-j+1), max);
  }else if(count > k) {
		while(j < s.length() && count > k ) {
	    char left = s.charAt(j);
	    if(base[left - 'a'] == 1) {
	      count--;
      }
      base[left - 'a']--;
      j++;
    }
  }
  i++;
}
return max;

}
}
