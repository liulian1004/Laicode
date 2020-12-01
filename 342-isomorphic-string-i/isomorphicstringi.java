public class Solution {
  public boolean isomorphic(String source, String target) {
    // T: O(n)S: O(n)
    Map<Character, List<Integer>> m1 = buildMap(source);
    Map<Character, List<Integer>> m2 = buildMap(target);
    Set<Character> set = m1.keySet();
    for(char c: set){
      List<Integer> l1 = m1.get(c);
      int index = l1.get(0);
      char ch = target.charAt(index);
      List<Integer> l2 = m2.get(ch);
      if(!l1.equals(l2)){
        return false;
      }
    }
    return true;
  }
  private  Map<Character, List<Integer>> buildMap(String s){
    Map<Character, List<Integer>> map = new HashMap<>();
    for(int i = 0; i< s.length(); i++) {
      if(!map.containsKey(s.charAt(i))){
        map.put(s.charAt(i), new ArrayList<>());
      }
      map.get(s.charAt(i)).add(i);
    }
    return map;
  }
}
