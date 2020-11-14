public class Solution {
  public int smallerPairs(int[] A, int K) {
    // Write your solution here
        int count = 0;
        Arrays.sort(A);
        int i = 0;
        int j = A.length-1;
        while(i < j){
            int cur = A[i]+A[j];
            if(cur < K){
                count += (j-i);
                i++;
            }else{
                j--;
            }
        }
        return count;
  }
}
