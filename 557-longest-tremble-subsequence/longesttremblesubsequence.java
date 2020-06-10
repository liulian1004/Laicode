public class Solution {
  public int longestTrembleSubsequence(int[] nums) {
    //T: O(n^2); S: O(n)
    if(nums == null || nums.length <= 1) {
      return 0;
    }
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    for(int i : nums) {
      if(!map.containsKey(i)) {
        map.put(i, 0);
        list.add(i);
      }
      map.put(i, map.get(i) + 1);
    }
    int length = 0;
    for(int i = 0; i < list.size(); i++) {
        for(int j = 0; j < i; j++) {
          if(Math.abs(list.get(i) -list.get(j)) == 1) {
            int a = list.get(i);
            int b = list.get(j);
            length = Math.max(length, map.get(a) + map.get(b));
          }
        }
    }
    return length;
  }
}
