public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // T:O(n +logn*n) S: O(1)
    // sort + i, j scanning
    //i++,if array[i] = array[i-1]
    List<List<Integer>> list = new ArrayList<>();
    if(array == null) {
      return list;
    }
    Arrays.sort(array);  //T: O(logn.n)
    int i = 0;
    int j = array.length -1;
    while(i < j) {
     if(array[i] + array[j] == target) {
        list.add(Arrays.asList(array[i],array[j])); //T: O(1)
        i++;
        j--;
        //去重
        //如果i这边有碰到重复的数，往下走
        //j这边就需要了，i，j两边走一边就行
        while(i<j && array[i] == array[i-1]) {
        i++;
      }
      } else if(array[i] + array[j] < target) {
        i++;
      } else {
        j--;
      }
    }
    return list;
  }
  //solution 2
  //T: O(n); S: O(n)
    // Map<array[i], count>
    // count用于几率重复了多少次，用于去重用
    Map<Integer, Integer> map = new HashMap<>();
    for(int num: array) {
      Integer count = map.get(num);
      // 去重
      //case1 :num * 2 == target, map中之前已经出现且只出现过一次
      //没有和之前的重复，可以加
      //case2: num1 + num2 = target

      //num 已经在map中出现过一次
      if(num * 2 == target && count != null && count == 1) {
          list.add(Arrays.asList(num, num));
      //target - num 已经在map中出现过，且num没有在map中出现过(count == null)
      } else if (map.containsKey(target - num) && count == null) {
        list.add(Arrays.asList(target-num, num));
      }
      //把这一组pair加入map中
      if(count == null) {
        map.put(num, 1);
      } else {
        map.put(num, count + 1);
      }
    }
    return list;
  }
