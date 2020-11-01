public class Solution {
  public int lenOflast(String input) {
    // Write your solution here
    input = input.trim();
    int i = 0;
    int index = -1;
    while(i < input.length()){
      if(input.charAt(i) == ' '){
        index = i;
      }
      i++;
    }
    return (i-(index+1));
  }
}
