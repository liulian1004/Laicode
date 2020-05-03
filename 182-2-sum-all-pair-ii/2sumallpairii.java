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
    for(int i = 0; i < array.length; i++) {
      int tmp = target - array[i];
    	//去重
    	Integer counter = map.get(tmp);
      //两个数相同，且只添加了一次
      if(tmp * 2 == target && counter != null && counter == 1) {
        list.add(Arrays.asList(tmp,tmp));
      //counter ！= null 且 新的array[i]没有在map中出现，所以可以配对
      } else if(!map.containsKey(array[i])&& counter != null) {
        list.add(Arrays.asList(tmp, array[i]));
      }
      //第二步判断如何把array[i]加入map中
      if(count == null) {
        map.put(num, 1);
      } else {
        map.put(num, count + 1);
      }
    }
    return list;
  }
