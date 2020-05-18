public class Solution {
  public String longest(String input, int k) {
    // T: O(n) S: O(1)
    if(input == null || input.length() == 0) {
      return "";
    }
    int i = 0;
    int j = 0;
    int start = i;
    int end = j;
    int count = 0;
    int max = 0;
    int[] map = new int[128];
    while(j < input.length() ) {
      if(map[input.charAt(j)] == 0) {
        count++;
      }
      map[input.charAt(j)]++;
      j++;
      while(count > k){
        if(map[input.charAt(i)] == 1){
          count--;
        }
        map[input.charAt(i)]--;
        i++;
      }
      if(count == k && (j -i) > max) {
        start = i;
        end = j;
        max = j - i;
      }
    }
    if(end == 0) {
      return "";
    }

  return input.substring(start, end);
  }
}
