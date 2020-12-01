public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    //if it's a tie, prefer the smaller one
    if(array.length == null || array.length == 0 || k >= array.length) {
    return array;
  }
  //这里后面for loop会考虑到
  // if(k <= 0) {
  //   return new int[0];
  // }
  int[] result = new int[k];
  int left = 0;
  int right = array.length - 1;
  while (left < right - 1) {
    int midIndex = left + (right - left) / 2;
    if (array[midIndex] >= target) {
        right = midIndex;
    } else {
       left = midIndex;
    }
  }
  for ( int i = 0; i < k; i++) {
    //1. right out of bound
    //2.|array[left] - target| > |array[right] - target|
  if(right >= array.length || left >= 0 && Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
    result[i] = array[left];
    left--;
    }else {
    result[i] = array[right];
    right++;
    }
  }
  return result;
  }

}
//follow up how to do it in the unsorted array
private int[] kCloest(int[] array, int target, int k){
        int[] res = new int[k];
        quickSelect(array, target,k, 0, array.length-1, res);
        Arrays.sort(res);
        return res;
   }
   private void quickSelect(int[] array, int target, int k, int left, int right, int[] res){
        //t: nlogk s:logk
        int p = left + (int)(Math.random()*(right-left+1));
        int diff = Math.abs(target - array[p]);
        swap(array, p, right);
        int i = left;
        int j = right-1;
        while(i <= j){
            int curDiff = Math.abs(target - array[i]);
            if(curDiff <= diff){
                i++;
            }else{
                swap(array, i, j);
                j--;
            }
        }
        swap(array, i, right);
        if(i-left+1 == k){
            copy(array,left, i, res);
            return;
        }else if(i - left + 1 > k){
            right = i;
            quickSelect(array, target, k, left, right, res);
        }else{
            copy(array, left, i, res);
            left = i+1;
            k = (k - (i+1));
            quickSelect(array, target, k, left, right, res);
        }
   }
   private void copy(int[] array, int left, int right, int[] res){
        for(int i = left; i <= right; i++){
            res[i] = array[i];
       }
   }
   private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
   }
