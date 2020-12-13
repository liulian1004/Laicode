public class Solution {
  public boolean wordPatternMatch(String pattern, String input) {
    //S: O(pattern+input)
    //T:(input^input) -> 算每一次最多分出多少个branch^层高
    // dfs, 尝试每一个组合情况
    //用于对应的<letter in the patter, substring in the put>
    Map<Character, String> map = new HashMap<>();
    //对应已经产生过的substring
    Set<String> set = new HashSet<>();
    return dfs(pattern, input,0,0,map, set);
  }
  private boolean dfs(String s1, String s2, int i1, int i2, Map<Character, String> map, Set<String> set){
    if(i1 == s1.length() || i2 == s2.length()){
      return i1 == s1.length() && i2 == s2.length();
    }
    char cur = s1.charAt(i1);
    //之前已经找到对应的关系，直接看这一次的对应关系对不对
    if(map.containsKey(cur)){
      String prev = map.get(cur);
      int length = prev.length();
      if(i2+length > s2.length()){
        return false;
      }
      String curString = s2.substring(i2,i2+length);
      if(!prev.equals(curString)){
        return false;
      }
      return dfs(s1,s2,i1+1,i2+length, map, set);
      //之前没有找到，只能一个个试过来
    }
      for(int i = i2; i < s2.length(); i++){
        String curString = s2.substring(i2,i+1);
        //之前已经产生过，这一组不可能是答案
        if(!set.add(curString)){
          continue;
        }
        map.put(cur, curString);
        if(dfs(s1,s2,i1+1,i+1,map,set)){
          return true;
        }
        set.remove(curString);
        map.remove(cur);
      }
      return false;
  }
}
