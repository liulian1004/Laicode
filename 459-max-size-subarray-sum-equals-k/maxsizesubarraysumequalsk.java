//Slution 1 : dp
public int maxSubArrayLen(int[] nums, int k) {
    // T: O(n^2) S: O(n)
    if(nums == null || nums.length == 0 ) {
      return 0;
    }
    int[] dp = new int[nums.length+ 1];
    for(int i = 0; i < nums.length; i++) {
      dp[i+1] = dp[i] + nums[i];
    }
    int max = 0;
    for(int i = 1; i <= nums.length; i++) {
      for(int j = 0 ; j<= i- 1; j++) {
        if(dp[i] - dp[j] == k) {
          max = Math.max((i-j), max);
        }
      }
    }
    return max;
  }
  public int maxSubArrayLen(int[] nums, int k) {
   // T: O(n) S: O(n)
   //Map<sum(at end i), i>
   if(nums == null || nums.length == 0 ) {
     return 0;
   }
   Map<Integer, Integer> map = new HashMap<>();
   // in case the first element is the valid one
   map.put(0,-1);
   int sum = 0;
   int max = 0;
   for(int i = 0; i < nums.length; i++){
     sum += nums[i];
     if(map.containsKey(sum - k)) {
       int length = i - map.get(sum-k);
       max = Math.max(max, length);
     }
     //only update once because we look for the longest length
     // if(!map.containsKey(sum)){
     //   map.put(sum,i);
     // }
     map.putIfAbsent(sum, i);
   }
   return max;

 }
}
