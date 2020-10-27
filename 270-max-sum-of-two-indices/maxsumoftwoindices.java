public class Solution {
  public int[] maxSum(int[] array) {
    //T：O(n)
    //divide and conquer
    // Max(A[i]+A[j]+ (j - i)) = Max(A[i] - i) + max(A[j] + j)
    //linear scan找到max for (A[i] - i and max for A[j] + j
    //如果要更新A[j] + j，需要同时更新i，j,确保j >= i
    int cur = array[0]-0 + (array[0]+0);
    int[] res = new int[]{0,0};
    int i = 0;
    int j = 0;
    for(int k = 1; k < array.length ; k++){
      //this is for part of j ,only need to update the index j
      if(array[k]+k > array[j]+j){
          j = k;
      }
      //this is for the part of i, need to update both index
      if(array[k]-k > array[i]-i){
        i = k;
        j = k;
      }
      if(array[i]-i + (array[j]+j) > cur){
        res[0] = i;
        res[1] = j;
        cur = array[i]-i + (array[j]+j);
      }
    }
    return res;
  }
}
