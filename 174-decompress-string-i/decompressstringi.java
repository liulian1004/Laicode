public class Solution {
  public String decompress(String input) {
    // T: o(n)
    if(input.length() <= 1){
      return input;
    }
    StringBuilder sb = new StringBuilder();
    char[] array = input.toCharArray();
    sb.append(array[0]);
    char prev = array[0];
    for(int i = 1; i < input.length(); i++){
      char temp = array[i];
      if(Character.isDigit(temp)){
         int  count = temp - '0';
         while(count > 1){
          sb.append(prev);
           count--;
          }
      } else{
        sb.append(temp);
        prev = temp;
      }
    }
    return sb.toString();
  }
}
