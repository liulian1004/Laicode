public class Solution {
  public boolean oneEditDistance(String a, String b) {
    // T: O(n)
    if(a == null && b == null || a.length() == 0 && b.length() == 0){
      return false;
    }
    if(a.length() == b.length()){
      return replace(a,b);
    }else if(a.length() == b.length()+1){
      return delete(a,b);
    }else if(a.length()+1 == b.length()){
      return delete(b,a);
    }
    return false;
  }
  private boolean replace(String a, String b){
    boolean flag = false;
    int i = 0;
    int j = 0;
    while(i < a.length()){
      if(a.charAt(i) != b.charAt(j)){
        if(!flag){
          flag = true;
        }else{
          return false;
        }
      }
      i++;
      j++;
    }
    return flag == true;
  }
  private boolean delete(String a, String b){
    boolean flag = false;
    int i =0;
    int j = 0;
    while(i < a.length() && j < b.length()){
      if(a.charAt(i) != b.charAt(j)){
        if(!flag){
          flag = true;
          i++;
        }else{
          return false;
        }
      }else {
        i++;
        j++;
      }
    }
    if(!flag && i == a.length()-1 || flag && j == b.length()&&i == a.length()){
      return true;
    }
    return false;
  }
}
