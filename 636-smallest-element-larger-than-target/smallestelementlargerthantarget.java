public class Solution {
  public int smallestElementLargerThanTarget(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        //similar to the first occurance
        while (left < right -1) {
            int midIndex = left + (right - left) / 2;
            if (array[midIndex] <= target) {
                left = midIndex + 1;
                //leftsub = midIndex ==》都可以
            } else {
              //这里不能right = midIndex - 1
              //因为midIndex可能是最小的大于target的数，所以不能排除
                right = midIndex;
            }
        }
        // return left, right，-1三种情况
        if(array[left] > target) {
          return left;
        }
        if(array[right] > target) {
          return right;
        }
        return -1;
  }
}
//follow up:
// the largest unumber smaller than target
while(left < right - 1) {
 int m = left + (right-left)/2;
 if(target <= array[m]) {
     right = m -1;
  }else{
   left = m;
  }
}

if(array[right] < target) {
    return right;
 }
if(array[left] < target) {
     return left;
}
return -1;
