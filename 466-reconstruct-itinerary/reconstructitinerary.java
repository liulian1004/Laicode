public class Solution {
  public List<String> findItinerary(String[][] tickets) {
    // T: O(n!) + O(nlogn) + O(n)
    //S: O(n)
    List<String> list = new ArrayList<>();
    if(tickets == null || tickets.length == 0 || tickets[0].length == 0) {
      return list;
    }
    Map<String, List<String>> map = new HashMap<>();
    for(String[] cur: tickets) {
      String start = cur[0];
      if(!map.containsKey(start)) {
        map.put(start, new ArrayList<>());
      }
      map.get(start).add(cur[1]);
    }
    for(List<String> cur: map.values()) {
      Collections.sort(cur);
    }
    list.add("JFK");
    if(helper(map, "JFK",list,tickets.length + 1)) {
      return list;
    }
    return null;
  }
  private boolean helper( Map<String, List<String>> map, String start, List<String> list, int length) {
    if(list.size() == length) {
      return true;
    }
    if(!map.containsKey(start)) {
      return false;
    }
    List<String> cur = map.get(start);
    for(int i = 0; i < cur.size(); i++) {
       String next = cur.get(i);
       cur.remove(next);
       list.add(next);
       if(helper(map, next, list, length)) {
         return true;
        }
        list.remove(list.size()-1);
        cur.add(i,next);
      }
    return false;
  }
}
