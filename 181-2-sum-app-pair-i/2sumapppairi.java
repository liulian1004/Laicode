public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // T: O(n). S: O(n^2)
    //Map<array[i], List<i>>: contains 的data has scanned
    // key是给的数据，value是对应要找的数据
    //这里知道target-array[i], 要找到对应的i
    //可能会有重复，一个target-array[i],对应不同的i，所以要存一个list在value
    List<List<Integer>> list = new ArrayList<>();
    if(array == null) {
      return list;
    }
    //s: (s(key) + s(value)) * number of enerty
    // s = (1+array.length)*array.length = n^2
    Map<Integer, List<Integer>> map = new HashMap<>();
    for(int i = 0; i < array.length; i++) {
      int tmp = target - array[i];
      //先查这个这个里面值是否在map里
      //如果在，把list里的index都放到结果里
      List<Integer> index = map.get(tmp);
      if(index != null) {
        for(int j: index) {
          list.add(Arrays.asList(j, i)); // T: O(1)
        }
      }
      //把现在在扫的数据放入map中
      //如果之前没有，在map中创建一个List<Integer>
      if(!map.containsKey(array[i])) {
        map.put(array[i], new ArrayList<>());
      }
      //无论之前有无，直接在list上加1
      map.get(array[i]).add(i);
    }
    return list;
  }
}
