public class Solution {
  public int threeSumClosest(int[] num, int target) {
    // Write your solution here
    int diff = Integer.MAX_VALUE;
    Arrays.sort(num);
    if(num.length <= 2){
      return -1;
    }
    for(int i = 0; i < num.length - 2; i++){
      int k = i+1;
      int p = num.length -1;
      while(k < p){
        int sum = num[i]+num[k]+num[p];
        diff = Math.min(diff, Math.abs(sum - target));
        if(sum < target){
          k++;
        }else if(sum == target){
          return 0;
        }else{
          p--;
        }
      }
    }
    return diff;
  }
}
