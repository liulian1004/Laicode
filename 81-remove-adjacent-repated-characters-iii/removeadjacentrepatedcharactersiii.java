public class Solution {
  public String deDup(String input) {
    // Write your solution here
    if(input == null || input.length() <= 1){
      return input;
    }
    char[] array = input.toCharArray();
    char prev = array[0];
    int index = 1;
    int i = 1;
    while(i < array.length){
      if(prev == array[i]){
         while(i < array.length && array[i] == prev){
           i++;
         }
         index--;
      }else{
        prev = array[i];
        array[index++] = array[i++];
      }
    }
    //if index == 0 => return empty string
    return new String(array).substring(0,index);
  }
}
