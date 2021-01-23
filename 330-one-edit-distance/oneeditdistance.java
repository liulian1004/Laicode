public class Solution {
  public boolean oneEditDistance(String s, String t) {
    // Write your solution here
      if(s.length() == t.length()+1){
            return delete(s,t);
        }
        if(s.length() + 1 == t.length()){
            return delete(t,s);
        }
        if(s.length() == t.length()){
            return replace(s,t);
        }
        return false;
  }
  private boolean delete(String l, String s){
        int i = 0;
        int j = 0;
        boolean diff = false;
        while(i < l.length() && j < s.length()){
            if(l.charAt(i) != s.charAt(j)){
                if(diff){
                    return false;
                }
                diff = true;
                i++;
            }else{
                i++;
                j++;
            }
        }
        return (i == l.length() && j == s.length()) || !diff&&i == j;
    }
    private boolean replace(String s1, String s2){
        int i = 0;
        int j = 0;
        boolean diff = false;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) != s2.charAt(j)){
                if(diff){
                    return false;
                }
                diff = true;
            }
                i++;
                j++;
        }
        return diff;
    }

}
