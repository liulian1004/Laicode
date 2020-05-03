public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    // Optimize for time
    // data size is small enough to fit into memory
    //one for loop + two sum(array, i + 1, n -1, target)
    // sorted array
    //array[i] + array[j]+arry[k] == target i < j <k
    //ignore all duplicated i
    //T: nlogn + n^2 = n^2
    //S: O(1)
    //比用map的方法好，因为时间复杂度一样，空间复杂度更好
    List<List<Integer>> list = new ArrayList<>();
    if(array == null|| array.length <= 2) {
      return list;
    }
    Arrays.sort(array);  // n.lgon
    //i最多到最后第三位
    for(int i = 0; i < array.length -2; i++) {
      if(i > 0 && array[i] == array[i-1]) {
        continue;
      }
      int left = i+1;
      int right = array.length - 1;
      int sum = target - array[i];
      while(left < right) {
        int tmp = array[left] + array[right];
        if(tmp == sum) {
            list.add(Arrays.asList(array[i], array[left], array[right])); //O(1)
            left++;
            right--;
            //在相等的情况下去重
            while(left < right && array[left] == array[left-1]) {
              left++;
            }
        }
        else if(tmp < sum) {
          left++;
        } else {
          right--;
        }
      }
  }
   return list;
  }

}
