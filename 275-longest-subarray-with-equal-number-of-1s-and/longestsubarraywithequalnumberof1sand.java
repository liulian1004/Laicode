public class Solution {
  public int longest(int[] nums) {
     //Assume : only contains 1 and 0
     //T: O(n); S:O(n)
     // use map<sum, index(before the valided pair)
      int sum = 0;
      int res = 0;
      if(nums == null || nums.length <= 1) {
          return res;
        }
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0,-1);
      for(int i = 0; i < nums.length;i++) {
        //sum++；sum-- ==> 回归到sum的本来的起始值
          if(nums[i] == 1) {
              sum++;
          }else{
              sum--;
          }
          if(map.containsKey(sum)) {
              res = Math.max(res, i - map.get(sum));
          //ex: 1,1,1,0,0 ==》 有效的pair并不在index 0开始
          //这个例子里有效的pair的sum的起始值是1，
          //有效的pair的之前的index是1
          } else {
              map.put(sum, i);
          }
        }
        return res;
  }
}
