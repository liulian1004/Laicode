public class Solution {
  public String rightShift(String input, int n) {
    // Write your solution here
    if(input == null || input.length() <= 1 || n == 0) {
      return input;
    }
    char[] array = input.toCharArray();
    reverse(array, 0, array.length -1 );
    int swithIndex = n % array.length -1;
    reverse(array, 0, swithIndex);
    reverse(array, swithIndex + 1, array.length - 1);
    return new String(array);
  }
  private void reverse(char[] array, int i, int j) {
    while (i <= j) {
      char temp = array[i];
      array[i] = array[j];
      array[j] = temp;
      i++;
      j--;
    }
  }
}
