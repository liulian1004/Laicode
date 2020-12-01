public class Solution {
  public int totalOccurrence(int[] array, int target) {
    // two point for the binary search, shrink only two elements, and expand from two sides
    //T:O(logn)-worse O(n) S: O(1)
    int res = 0;
    if(array == null || array.length == 0){
      return res;
    }
    //corner case; only one element
    if(array.length == 1){
       if(array[0] == target){
         res++;
         return res;
       }
       return res;
    }
    int left = 0;
    int right = array.length-1;
    while(left < right-1){
      int mid = left + (right-left)/2;
      if(array[mid] <= target){
        left = mid;
      }else{
        right = mid;
      }
    }
    while(left >= 0 && right <= array.length -1){
      if(array[left] == target){
        res++;
        left--;
      }else if(array[right] == target){
        res++; right++;
      } else{
       break;
      }
    }
    while(left >= 0 && array[left] == target){
      left--;
      res++;
    }
    while(right <= array.length -1 && array[right] == target){
      right++;
      res++;
    }
    return res;
  }
}
