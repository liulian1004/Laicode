public class Solution {
  public boolean valid(String input) {
    // T: O(n)
    //大小写字母视为相同的字母
    if(s == null || s.length() <= 1 ) {
            return true;
        }
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
           while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
               i++;
           }
           while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
               j--;
           }
            if(i < j && s.charAt(i) != s.charAt(j)) {
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
  }
}
