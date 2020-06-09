public class Solution {
  int count = 0;
  public int countPalindromeSubs(String input) {
    //T: O(n) S: O(1)
    //check the possibility of palnidrome for each palindrome
    if(input == null || input.length() == 0) {
      return count;
    }
    for(int i = 0; i < input.length(); i++) {
      findP(input,i,i);
      findP(input,i,i+1);
    }
    return count;
  }
  private void findP(String s, int i, int j) {
    while(i >= 0 && j < s.length()) {
      char a = s.charAt(i);
      char b = s.charAt(j);
      if(a != b) {
        return;
      }
      count++;
      i--;
      j++;
    }
  }
}
