public class Solution {
  public boolean containsPermutation(String s1, String s2) {
    //T: O(n) S: O(1)
        if( s2 == null || s2.length() == 0 || s1.length() > s2.length()) {
            return false;
        }
        if(s1 == null || s1.length() == 0 ) {
            return true;
        }
        int i = 0;
        int j = 0;
        int[] map = new int[26];
        for(int k = 0; k < s1.length(); k++){
            map[s1.charAt(k) - 'a']++;
        }
        while(j < s2.length()) {
            map[s2.charAt(j) - 'a']--;
            while(map[s2.charAt(j) - 'a'] < 0) {
                map[s2.charAt(i)- 'a']++;
                i++;
            }
            j++;
            if( j - i == s1.length()) {
                return true;
            }

        }
        return false;
  }
}
