public class Solution {
  //charify:
  // return 类型： boolean
  // sorted or not, depuplicated element? ： unorted, no duplicated
  // array null or empty? array could be empty
  // input size? 内存存的下吗？内存可以存的下
  // input type是整数吗？ input type是整数
  //set: keepall elements that alreay scanned
  // algorithm： taget - array[i] in the set, return true
  public boolean existSum(int[] array, int target) {
    //T: O(n); S: O(n)
    if(array.length == 0) {
      return false;
    }
    Set<Integer> set = new HashSet<>();
    //根据物理意义，set要初始化成第一个放入array[0]
    set.add(array[0]);
    for(int i = 1; i < array.length; i++) {
      int result = target - array[i];
      if(set.contains(result)) {
        return true;
      }
      set.add(array[i]);
    }
    return false;
  }

  //solution 2:
  //T: O(n) + nlogn; S: O(n)
  // sorted array first
  // a[i..j] is the range of possiblity that i + j = taget
  // i + j > target -> j--
  // i + j < target  -> i++

  Arrays.sort(array);
  int i = 0;
  int j = array.length - 1;
  while(i < j) {
    if(array[i] + array[j] == target) {
      return true;
      //< target,需要往大的值找
    } else if(array[i] + array[j] < target) {
      i++;
      // > taget, 需要往小的值找
    } else if(array[i] + array[j] > target) {
      j--;
    }
  }
  return false;
  }

}
