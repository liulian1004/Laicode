public class Solution {
  public List<Integer> allAnagrams(String sh, String lo) {
    // T: O(m + n) S: O(n)
    // n = lo.length(); m = sh.length()
    List<Integer> res = new ArrayList<>();
    if(sh.length() == 0 || sh.length() > lo.length()) {
      return res;
    }
    Map<Character, Integer> map = mapBuilder(sh);
    //consider it might have duplicated element in the sh
    //here shall use the size of map
    int match = map.size();
    for(int i = 0; i < lo.length(); i++) {
      //check the situation of new element which just add into sliding window
      // if it's in the map and the value is 0, reduce match
        char e = lo.charAt(i);
        Integer value = map.get(e);
        if(value != null) {
           if (value == 1) {
              match--;
            }
            map.put(e, value - 1);
        }
        //check the situation of element which leave sliding window
        if( i >= sh.length()) {
        char l = lo.charAt(i - sh.length());
        if(map.containsKey(l)) {
          value = map.get(l);
          if(value == 0) {
            match++;
          }
          map.put(l, value + 1);
        }
      }
        // when match == 0, the sliding windown meet the requirment
        if(match == 0) {
        int start = i - sh.length() + 1;
        res.add(start);
        }
    }
    return res;
  }

  private Map<Character, Integer> mapBuilder(String lo) {
    Map<Character, Integer> res = new HashMap<>();
      for(char i: lo.toCharArray()) {
          Integer value = res.get(i);
          if(value == null) {
            res.put(i, 1);
          } else {
            res.put(i, value + 1);
          }
      }
      return res;
  }
  //mysolution
  public List<Integer> allAnagrams(String sh, String lo) {
    // Write your solution here
    List<Integer> list = new ArrayList<>();
    if(sh == null || sh.length () == 0 || lo == null || sh.length() == 0) {
      return list;
    }
    int[] map =  new int[26];
    for(char c : sh.toCharArray()) {
      map[c-'a']++;
    }
    int i = 0;
    int j = 0;
    int count = 0;
    while(j < lo.length()) {
      if(map[lo.charAt(j)- 'a'] > 0) {
        count++;
      }
      map[lo.charAt(j)- 'a']--;
      j++;
            while(count == sh.length()) {
            if(count == sh.length() && (j - i) == sh.length()) {
                list.add(i);
            }
            if(map[lo.charAt(i)- 'a'] == 0) {
              count--;
            }
            map[lo.charAt(i)- 'a']++;
            i++;
          }
      }

    return list;
  }
}
