public class Solution {
  public String reverseWords(String input) {
    // T: O(n) ;S : O(n)
    if(input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    reverse(array, 0, array.length -1);
    int start = 0;
    for(int i = 0; i < array.length; i++) {
      //find the first element after space, move start
      //case1: the beginnig of sentence
      //case 2: the mid of sentence
      if(array[i] != ' ' && (i == 0 || array[i-1] == ' ')) {
        start = i;
      }
      //find the last elment before space, reverse[start, i]
      //case1 : the mid of sentence
      //case2 : the last word of sentec
      if(array[i] != ' ' && (i == array.length - 1 || array[i+1] == ' ')) {
        reverse(array, start, i);
      }
    }
    return new String(array);

  }

  private void reverse(char[] array, int i, int j) {
    while(i <= j) {
      swap(array, i, j);
      i++;
      j--;
    }
  }
  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

//mysolution

char[] array = input.toCharArray();
    int left = 0;
    int right = array.length - 1;
    reverse(array, left, right);
    for(int i = 0; i < array.length; i++) {
      if(array[i] == ' ') {
      reverse(array, left, i - 1);
      left = i + 1;
      }
    }
    if(left < right) {
    reverse (array, left, right);
    }
