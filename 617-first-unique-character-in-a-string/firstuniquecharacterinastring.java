public class Solution {
  public int firstUniqChar(String input) {
    // T: O(n) S: O(n)
    Map<Character, List<Integer>> map = new HashMap<>();
    for(int i = 0; i < input.length(); i++){
      char c = input.charAt(i);
      if(!map.containsKey(c)){
        map.put(c, new ArrayList<>());
      }
      map.get(c).add(i);
    }
    int index = input.length();
    for(Map.Entry entry: map.entrySet()){
      List<Integer> list = (List<Integer>)entry.getValue();
      if(list.size() == 1){
        index = Math.min(index,list.get(0));
      }
    }
    return index == input.length()? -1:index;
  }
}
