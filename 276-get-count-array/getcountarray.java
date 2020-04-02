public class Solution {
  public int[] countArray(int[] array) {
    //T： nlogn
    // merge sort + 维护每个element的count
    // counter: 在排序过程中，有多少本来比我小且在右边的数被移到了左边
    //case 1: left[i] < right[j] i's count += j           i++
    //case 2: left[j] > right[j]  y's count doesn't chang j++

    //T: O(n^2); S O(1)
    int[] res = new int[array.length];
    if(array == null || array.length <= 1) {
        return res;
    }
    for(int i = 0; i < array.length - 1; i++) {
      for(int j = i+1; j < array.length; j++) {
          if(array[i] > array[j]) {
            res[i] += 1;
          }
      }
    }
    return res;
  }
}
// follow up
// new interview question , see noon class - 2
// there are two rows of nests, in the morning, birds fly to one side of nests randomly
// in the evening, birds fly back to the nest of anohter sides, based on the order
// how many intersections can birds trajectories generate when they back to nest at nigth
// input: 4, 5, 1, 3,2 ==> output :3, 3, 0, 1, 0 ==> sum is 7
