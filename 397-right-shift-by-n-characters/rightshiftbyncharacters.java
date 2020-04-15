public class Solution {
  public String rightShift(String input, int n) {
    // 整体reverse
    // 在swithindex的地方两边分别局部reverse
    //T： O(n) S: O(1)
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
  //T: O(n) S: O(n)
  //abcde
  //left shift 2  ab cde --> cde ab
   return s.substring(index, lenght - 1) + s.substring(0, index);
  //right shfit  abc de --> de abc
  return s.substring(index, length) + s.substring(0, length - index);

}
