public class Solution {
  public boolean exist(int[] a, int[] b, int[] c, int target) {
    //T = a*Math.max(b, c); S: O(b)
    for(int i: a){
      int temp = target - i;
      Set<Integer> set = new HashSet<>();
      for(int j:b){
        set.add(temp - j);
      }
      for(int j: c){
        if(set.contains(j)){
          return true;
        }
      }
    }
    return false;
  }
}
