public class Solution {
  public List<Integer> majority(int[] array, int k) {
    // T:O(n) S: O(n)
    List<Integer> list = new ArrayList<>();
    if(array == null || array.length < 0 || k <= 0) {
      return list;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for(int i : array) {
      map.put(i, map.getOrDefault(i, 0)+1);
    }
    int length = array.length / k;
    for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
      if(entry.getValue() > length) {
        list.add(entry.getKey());
      }
    }
    return list;
  }
}
