public class Solution {
  public int[] countArray(int[] array) {

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

//T： nlogn
// merge sort + 维护每个element的count
// counter: 在排序过程中，有多少本来比我小且在右边的数被移到了左边
// ex:
// left: 1 4
// right: 2 3
// merge的时候更新每一个元素有多少个比他小的元素
// 把right的元素copy到solution集合的时候不需要更新count
//把left元素copy到solution集合的时候需要count。count是count + index of j
//case 1: left[i] < right[j] i's count += j           i++
//case 2: left[j] > right[j]  y's count doesn't chang j++


public int[] countArray(int[] array) {
    // check how many elements that are smaller than me on my right side
    // merge sort
    //在merge是记录有多少个element swap到我的左边，即比我小
    //这里要记录他们的index
    //case 1: left[i] < right[j] i's count += j           i++
    //case 2: left[j] >= right[j]  y's count doesn't chang j++
    //T：nlogn S: O(n)
    int[] count = new int[array.length]; //记录结果
    int[] helper = new int[array.length]; //存放temp
    int[] index = copyIndex(array);
    mergeSort(array, count, helper, 0, array.length-1, index);
    return count;
  }
  private void mergeSort(int[] array, int[] count, int[] helper, int left, int right, int[] index) {
    if(left >= right){
      return;
    }
    int mid = left + (right-left)/ 2;
    mergeSort(array, count, helper, left, mid, index);
    mergeSort(array, count, helper, mid+1,right,index);
    merge(array,count, helper, left, mid, right, index);
  }
  private void merge(int[] array, int[] count, int[] helper, int left, int mid, int right, int[] index) {
    // 和标准merge不同的是这里存的是index，不是value
    for(int i = left;i <= right; i++){
      helper[i] = index[i];
    }
    int i = left;
    int j = mid+1;
    int cur = left;
    while(i <= mid){
      // j出界 或者 array[index] < array[index]
      //index: helper[i]
      // must include "==",只要右边没有小于我的数，我就要查下之前有多少数已经比我小，并且更新
      if(j > right || array[helper[i]] <= array[helper[j]]) {
        //跟新右边的j已经挪动来多少位(从mid+1开始)，即这一轮有多少位数< element at index
        count[helper[i]] += (j - (mid+1));
        //copyback the index of sorted elements
        index[cur++] = helper[i++];
      }else {
        index[cur++] = helper[j++];
      }
    }
  }
  private int[] copyIndex(int[] array){
    int[] res = new int[array.length];
    for(int i = 0; i < array.length; i++){
      res[i] = i;
    }
    return res;
  }

  // follow up
  // new interview question , see noon class - 2
  // there are two rows of nests, in the morning, birds fly to one side of nests randomly
  // in the evening, birds fly back to the nest of anohter sides, based on the order
  // how many intersections can birds trajectories generate when they back to nest at nigth
  // input: 4, 5, 1, 3,2 ==> output :3, 3, 0, 1, 0 ==> sum is 7
