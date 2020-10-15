public class Solution {
  public int threeSumSmaller(int[] num, int target) {
    // Write your solution here
    int ans = 0;
    if(num == null ||num.length <= 2){
      return ans;
    }
    Arrays.sort(num);
    for(int i = 0; i < num.length-2;i++){
          int t = target - num[i];
          int k = i+1;
          int p = num.length-1;
          while(k < p){
            //如果k+p < t ==> k和p之间的数能和i组合。
            //由于k+p < t ,移动p，k和p之间的解没有办法算入，所以这里ans +=(p-k);
            if(num[k]+num[p] < t){
              ans +=(p-k);
              k++;
            }else{
              p--;
            }
          }
    }
    return ans;
  }
}
