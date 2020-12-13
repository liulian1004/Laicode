public class Solution {
  public String deDup(String input) {
    // T: o(n)
    if(input == null || input.length() <= 2){
      return input;
    }
    char[] array = input.toCharArray();
    char prev = array[0];
    int count = 1;
    int index= 1;
    int i = 1;
    while(i< array.length){
      if(array[i] == prev && count < 2){
          count++;
          array[index++] = array[i];
      }else if(array[i] != prev) {
        count = 1;
        array[index++] = array[i];
      }
      prev = array[i];
      i++;
    }
    return new String(array).substring(0,index) ;
  }
}
