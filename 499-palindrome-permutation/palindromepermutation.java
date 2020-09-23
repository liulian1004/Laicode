public class Solution {
  public boolean canPermutePalindrome(String input) {
    // check how many time of odd char appears
    // if over 2, it's false
    //T: O(n) S: O(n)
    Map<Character, Integer> map = new HashMap<>();
    for(char c: input.toCharArray()){
        map.put(c, map.getOrDefault(c,0)+1);
    }
    int odd = 0;
    for(Map.Entry entry: map.entrySet()){
      int num = (int)entry.getValue();
      if(num % 2 == 1){
        if(odd == 0){
          odd++;
        }else{
          return false;
        }
      }
    }
    return true;
  }
}
