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
//follow up : how to do it on the stream
solutio: double linkedlist + map
reason: can't keep the sliding window on the memory size
map<Character，most recent index of this character>
doulbe linked list： keep the order of index of character
i.e： <a, 10> <b,12> k = 2;
case1:
如果读一个C，left就需要移动到b(12)这个位置，这个时候直接读linkedlist的head,把<a>所在的key从map里踢掉
case2:
如果有读近一个a， update map<a,13>,
linkedlist a从linkedlist中移动到tail
