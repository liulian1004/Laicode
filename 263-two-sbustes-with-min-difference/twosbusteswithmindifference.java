public class Solution {
  public int minDifference(int[] array) {
    List<Integer> list = new ArrayList<>();
    int[] res = new int[]{Integer.MAX_VALUE};
    int sum =0;
    for(int i: array){
      sum += i;
    }
    helper(array,0,list,res, sum);
    return res[0];
  }
  private void helper(int[] array, int index, List<Integer> list, int[] res, int sum){
    if(list.size() == array.length/2){
      //计算出subset的sum
      int s1 = 0;
      for(int i: list){
        s1 += i;
      }
            //计算出剩余subset的sum & 取绝对值更新diff
      res[0] = Math.min(res[0], Math.abs(s1-(sum-s1)));
      return;
    }
    if(index == array.length){
      return;
    }
    helper(array, index+1,list, res, sum);
    list.add(array[index]);
    helper(array, index+1,list,res, sum);
    list.remove(list.size()-1);
  }
}
