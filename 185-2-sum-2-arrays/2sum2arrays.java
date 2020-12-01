public class Solution {
  public boolean existSum(int[] a, int[] b, int target) {
    //T:O(n) S:O(n)
    Set<Integer> set = new HashSet<>();
    for(int i: a){
      set.add(target - i);
    }
    for(int i : b){
      if(set.contains(i)){
        return true;
      }
    }
    return false;
  }
}
