public class Solution {
  public String reverse(String input) {
    // T: O(n) S: O(n)
    if(input == null || input.length() == 0) {
      return input;
    }
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    int i = 0;
    int j = input.length() -1;
    char[] array = input.toCharArray();
    while(i < j) {
      if(!set.contains(array[i])){
          i++;
          continue;
      }
      if(!set.contains(array[j])) {
        j--;
        continue;
      }
      swap(array, i++, j--);
    }
    return new String(array);
  }
  private void swap(char[] array, int i ,int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
