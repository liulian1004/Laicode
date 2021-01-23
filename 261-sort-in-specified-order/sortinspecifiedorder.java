public class Solution {
  public int[] sortSpecial(int[] A1, int[] A2) {
    // T: O(n)+O(k*logk) S: O(n)
    List<Integer> res = new ArrayList<>();
    Map<Integer, Integer> map  = new HashMap<>();
    for(int i: A1){
      map.put(i, map.getOrDefault(i,0)+1);
    }
    for(int i: A2){
      if(map.containsKey(i)){
        int count = map.get(i);
        while(count > 0){
            res.add(i);
            count--;
        }
        map.remove(i);
      }
    }
    List<Integer> temp = new ArrayList<>();
    for(Map.Entry entry: map.entrySet()){
      int count = (int)entry.getValue();
      while(count > 0){
        temp.add((int)entry.getKey());
        count--;
      }
    }
    Collections.sort(temp);
    int[] result = new int[A1.length];
    int index = 0;
    int cur = 0;
    while(cur < res.size()){
      result[index++] = res.get(cur++);
    }
    cur = 0;
    while(cur < temp.size()){
      result[index++] = temp.get(cur++);
    }
    return result;
  }
}
