public class Solution {
  public List<Integer> common(int[] A, int[] B) {
    List<Integer> res = new ArrayList<>();
    //Solution 1: 谁小移谁
    //T: O(n + n) S: O(1)
    int i = 0;
    int j = 0;
    while(i < A.length && j < B.length) {
      if(A[i] == B[j]) {
        res.add(A[i]);
        i++;
        j++;
      } else if(A[i] < B[j]) {
        i++;
      } else {
        j++;
      }
    }
    return res;
  }
  //Solution2: HashMap(无重复数可以用HashSet)
    // T: O(m+n),worse: O(m^2 + n^2) S:O(m+n)
    HashMap<Integer, Integer> mapA = mapBuilder(A);
    HashMap<Integer, Integer> mapB = mapBuilder(B);
    for(Map.Entry<Integer, Integer> entry: mapA.entrySet()) {
      //找到mapb里面相应的key对于的value
      Integer value = mapB.get(entry.getKey());
      if(value != null) {
        int count = Math.min(entry.getValue(), value);
        while(count > 0) {
          res.add(entry.getKey());
          count--;
        }
      }

    }
    return res;
  }
  private HashMap<Integer, Integer> mapBuilder(int[] a) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int number: a) {
      Integer value = map.get(number);
      if(value == null) {
        map.put(number, 1);
      } else {
        map.put(number, value + 1);
      }
    }
    return map;
  }
}
