public class Solution {
  public List<Integer> closest(int[] array, int target) {
    // T:(array.length * 2) + nlogn;
    // sorted array -- > sorted m[i][j](Yang's matrix)
    List<Integer> list = new ArrayList<>();
    if(array == null || array.length <= 1) {
      return list;
    }
    Arrays.sort(array); // nlogn
    int l = 0;
    int r = array.length - 1;
    int indexA = array[l];
    int indexB = array[r];
    int sum = array[r] + array[l];
    //从最小值和最大值开始循环找
    //termination condtion: i,j都越界 ==> already liner scan the all possibility
    while(l < array.length && r >= 0) {
      int temp = array[r] + array[l];
      //找到target直接退出循环
      if(temp == target && r != l) {
        indexA = array[l];
        indexB = array[r];
        break;
      }
      //update the sum
      if((Math.abs(target - temp) < Math.abs(target - sum)) && r != l) {
        sum = temp;
        indexA = array[l];
        indexB = array[r];
      }
      if(temp > target) {
        r--;
      } else{
        l++;
      }
     }
     list.add(indexA);
     list.add(indexB);
     return list;
  }
}
//follow up
// give you two sorted array and target, find the closest target sum from two array sperately
