public class Solution {
  public String reverseWords(String input) {
    // T: O(n) S: O(n)
    if(input == null || input.length() <= 1){
      return input;
    }
    input = input.trim();
    char[] array = input.toCharArray();
    int i = 0;
    int j = array.length -1;
    reverse(array, i, j);
    int left = 0;
    boolean flag = false;
    for(int k = 0; k < array.length; k++) {
        if(array[k] == ' ') {
          if(flag) {
            left++;
          } else {
            reverse(array, left, k-1);
            left = k + 1;
            flag = true;
          }
        }else if(flag) {
          flag = false;
        }
    }
    if(left < array.length-1) {
      reverse(array, left, array.length -1);
    }
    int t = 0;
    boolean space = false;
    for(int k = 0; k < array.length; k++) {
        if(array[k] == ' ' && space == false) {
              array[t++] = array[k];
              space = true;
        }else if(array[k] != ' ') {
          if(space) {
            space = false;
          }
          array[t++] = array[k];
        }
    }
    String res = new String(array);
    return res.substring(0,t);
  }
  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
  private void reverse(char[] array, int i ,int j) {
    while(i < j) {
      swap(array,i++, j--);
    }
  }
}
