public class Solution {
  public String compress(String input) {
    // Write your solution here
    char[] array = input.toCharArray();
    int i = 0;
    int j = 0;
    while (j < array.length) {
      int begin = j;
      //in any condition, j will point to the different characater
      while(j < input.length() && array[begin] == array[j]) {
        j++;
      }
      //sigle character - copy the character
      // muplute characters - copy the first letter
      array[i]= array[begin];
      i++;
      //calculater the number
      if(j - begin > 1) {
      int gap = isDigits(array, i, j -begin);
      i += gap;
      }
    }
    return new String(array, 0 , i);
  }

  private int isDigits(char[] array, int begin, int count ) {
      int gap = 0;
      for(int i = count ; i >0; i /= 10) {
            // for the gap of put numbers
            gap++;
            // mark the postion to put number
            begin++;
      }
      for(int i = count; i >0; i /= 10) {
        int digits = i % 10;
        //one step back to put the number
        begin--;
        array[begin] = (char)(digits + '0');
      }
      return gap;
  }
}
