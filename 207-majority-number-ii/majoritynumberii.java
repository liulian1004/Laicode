public class Solution {
  public List<Integer> majority(int[] array) {
    // find 2 winers
  // go through again to check the count of 2 winers
  // export the qualified one
    // 1 vs 2
    // pick up the first two candidiate, start to compare
    // the third candidate appear, both candidate--
    // after literation find the two candidate, one of it must be the answer
    // liner scan again, count and find the winner
    //T: O(n) S: O(1)
    int n = array.length;
      List<Integer> list = new ArrayList<>();
      int[] can1 = new int[2];
      int[] can2 = new int[2];
      // 一定要先差是否相等，在查是否出现过
      //corner case: 1122 ==> 如果顺序错误，m1 = 1 && m2 = 1
      for(int i = 0; i < array.length; i++){
        if(can1[0] == array[i]){
          can1[1] += 1;
          continue;
        }
        if(can2[0] == array[i]){
          can2[1] += 1;
          continue;
        }
        if(can1[1] == 0 ) {
          can1[0] = array[i];
          can1[1] = 1;
          continue;
        }
        if(can2[1] == 0) {
          can2[0] = array[i];
          can2[1] = 1;
          continue;
        }
        can1[1] -= 1;
        can2[1] -= 1;
      }

      int count1 = 0;
      int count2 = 0;
      for(int i = 0; i < array.length; i++) {
          if(array[i] == can1[0]) {
            count1 ++;
          }
          if(array[i] == can2[0]) {
            count2 ++;
          }
      }
      //must be bigger than 1/3
      if(count1 > n/3) {
        list.add(can1[0]);
      }
      if(count2 > n/3) {
        list.add(can2[0]);
      }
      return list;
    }
}
