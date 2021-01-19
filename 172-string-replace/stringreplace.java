public class Solution {
  public String replace(String input, String source, String target) {
    // Write your solution here
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while(i < input.length()){
      char cur = input.charAt(i);
      //小心outofbound，在查substring的时候需要先查会不会outofbound
      if(cur == source.charAt(0) && i+source.length() <= input.length() && input.substring(i,i+source.length()).equals(source)){
          sb.append(target);
          i = i+source.length();
      }else{
        sb.append(cur);
        i++;
      }
    }
    return sb.toString();
  }
}
