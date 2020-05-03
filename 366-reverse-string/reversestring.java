public class Solution {
  public String reverse(String input) {
    if(input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    int i = 0;
    int j = array.length -1;
      // iteration
    while(i <= j) {
      swap(array, i, j);
      i++;
      j--;
    }
    return new String(array, 0, array.length);

    //recurssion
    helper (array, i, j);
    return new String(array, 0, array.length);
  }

  private void swap(char[] array, int a, int b) {
    char temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
  private void helper(char[] array, int i, int j) {
  if(i > j) {
    return;
  }
  swap(array, i, j);
  helper(array, i+1, j-1);
  }

}
