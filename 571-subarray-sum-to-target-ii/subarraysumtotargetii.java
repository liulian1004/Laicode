public class Solution {
  public int numOfSubarraySumToK(int[] array, int k) {
    //T: O(n^2), S: O(n)
    int ans = 0;
    int[] sum = new int[array.length+1];
    for(int i = 0; i < array.length;i++) {
        sum[i+1] = sum[i] +array[i];
    }
    for(int i = 1; i <sum.length; i++) {
      for(int j = 0; j<i;j++) {
        if(k == (sum[i]-sum[j])) {
          ans++;
        }
      }
    }
    return ans;
  }
  //T：O(n) S: O(n)
        //是2sum array的变体
        int ans = 0;
        if(nums == null || nums.length ==0) {
            return ans;
        }
        //Map<sum, count>
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        //base case: 如果sum 和 k相等，就需要这个case
        map.put(sum,1);
        for(int i = 0; i < nums.length;i++){
            sum += nums[i];
            //前i个index的sum - k ==> subarray sum
            //查一共出现过这个subarray sum的值多少次，放入ans中
            int temp = sum - k;
            if(map.containsKey(temp)){
                ans += map.get(temp);
            }
            //无论如何，记得要更新map,把现在出现的sum的情况更新一下
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return ans;
}
