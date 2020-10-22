public class Solution {
  public int getSingleElement(int[] array) {
    // T: O(n); S: O(1)
   if(array.length  == 1) {
     return array[0];
   }
   for(int i = 0; i < array.length - 1; i = i+2) {
     if(array[i] != array[i+1]) {
       return array[i];
     }
   }
   return array[array.length - 1];
}
}
//binary search
//if no missing number, the first letter appears in the even
   int i = 0;
   int j = array.length- 1;
   while(i < j){
     int mid = i+(j-i)/2;
     if(mid%2 == 0){
       if(array[mid] == array[mid+1]){
         i = mid+2;
       }else{
         j = mid;
       }
       continue;
     }
     if(array[mid-1] == array[mid]){
       i = mid+1;
     }else{
       j = mid;
     }
   }
   return array[i];

}
//follow up
//how to find the single element in the unsorted subArray
// T: O(n) S: O(1)
public int singleNumber(int[] array) {
      int x =0;
      for (int i : array) {
          x ^= i;
      }
      return x;

  }
