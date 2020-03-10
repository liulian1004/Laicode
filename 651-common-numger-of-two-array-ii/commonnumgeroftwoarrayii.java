public class Solution {
  public List<Integer> common(int[] A, int[] B) {
    // duplicated HashMap
    //no need to sort
    //here the answer need to be sorted
    //T: m + n + l.logl
    // S: O(m)
    List<Integer> list = new ArrayList<>();
    // Arrays.sort(A); //nlogn
    // Arrays.sort(B); //mlogm
    Map<Integer, Integer> map = new HashMap<>(); //S : m
    for(int i = 0; i < A.length;i++) {    //T: O(m)
      if(!map.containsKey(A[i])) {
        map.put(A[i],1);
      } else {
        map.put(A[i], map.get(A[i]) + 1);
      }
    }
    int i = 0;
    while(i < B.length) {
      if (map.containsKey(B[i])) {
                int count = map.get(B[i]);
                list.add(B[i]);
                count--;
                if (count > 0) {
                    map.put(B[i], count);
                }
            }
            i++;
    }
    Collections.sort(list);
    return list;
  }
}
