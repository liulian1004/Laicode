public class Solution {
  public List<String> subSets(String set) {
    //level = the number of unique character
    // each leave decide add how many duplicated characters
    //   ex: abb  => 1a2b
    //      /   \
    //     "     a
    // /  |  \  / | \
    //""  b  bb a ab abb   ==> result
    //T：
    //S: O(the amount of unique character) + O(the size of map) -->O(n)
    // T: O(n^n) --->worsecase ： 每一个index有n个选择--> 
    List<String> list = new ArrayList<>();
    if(set == null) {
        return list;
    }
    //set为空的情况在下面的逻辑中也包括了
    //find the number of unique character
    Map<Character, Integer> map = build(set);
    List<Character> uniqueChar = new ArrayList<>(map.keySet());
    StringBuilder sb = new StringBuilder();
    dfs(map,0,uniqueChar,sb, list);
    return list;
  }
  private void dfs(Map<Character, Integer> map, int index, List<Character> uniqueChar, StringBuilder sb, List<String> list) {
    if(index == uniqueChar.size()) {
      list.add(sb.toString()); // T: O（n）
      return;
    }
    // add nothing
    dfs(map,index+1, uniqueChar, sb, list);
    //add char
    char cur = uniqueChar.get(index);
    for(int i =0; i < map.get(cur);i++) {
      sb.append(cur);
      dfs(map, index+1,uniqueChar, sb, list);
      //写在这里是等于把sb又退回去
      //但是这里的要求是return回来sb要继续往后append
      //所以只能在for loop外面减
      //sb.deleteCharAt(sb.length()-1);
    }
    for(int i = 0; i < map.get(cur); i++) {
      sb.deleteCharAt(sb.length() - 1);
    }
  }
  private Map<Character, Integer> build(String set) { // T: O(n) S: O(n)
    Map<Character, Integer> map = new HashMap<>();
    for(char s: set.toCharArray()) {
      if(!map.containsKey(s)){
          map.put(s,1);
      }else {
        map.put(s, map.get(s)+1);
      }
    }
    return map;
  }
}
