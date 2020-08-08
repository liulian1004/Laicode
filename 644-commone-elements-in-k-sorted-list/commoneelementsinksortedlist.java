public class Solution {
  public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
    // two pointer, binary and heap三个方法，two pointer时空间复杂度最好
    //T: O(kn) n = the length of list;
    //S: O(1)
    List<Integer> list = new ArrayList<>();
    if(input == null) {
      return list;
    }
    //把第一个list放进去
    list =input.get(0);
    for(int i = 1; i <input.size(); i++) {
      list = helper(list, input.get(i));
    }
    return list;
  }
  private List<Integer> helper(List<Integer>l1, List<Integer>l2) {
    List<Integer> list = new ArrayList<>();
    //两两比较
    int i = 0;
    int j = 0;
    while(i < l1.size() && j <l2.size()) {
      int result = l1.get(i).compareTo(l2.get(j));
      if(result == 0) {
        list.add(l1.get(i));
        i++;
        j++;
      } else if(result < 0) {
        i++;
      } else {
        j++;
      }
    }
    return list;
  }
  //HashMap
  if(input.size()== 1) {
    	return input.get(0);
    }
    int short = 0;
    int shortLength = input.get(0).size();
    for(int i = 1; i < input.size(); i++) {
    	if(input.get(i).size() < shortLength) {
    	short = i;
    	shortLength = input.get(i).size();
    }
    }
    Map<Integer, Integer> map = new HashMap<>();
    for(int temp : input.get(short)) {
    	map.put(temp, map.getOrDefault(temp,0) + 1);
    }
    for(int i = 0; i < input.size(); i++) {
    	if(i == short) {
    	continue;
    }
    	Map<Integer, Integer> temp = new HashMap<>();
    	for(int cur: input.get(i)) {
    		if (map.getOrDefault(cur,0) > 0  ) {
    	temp.put(cur, temp.getOrDefault(cur, 0) + 1);
    	map.put(cur, map.get(cur)-1);
    }
    }
    map = temp;
    }
    List<Integer> list = new ArrayList<>();
    for(Map.Entry<Integer, Integer> pair: map.getEntry()) {
    	int value = pair.getValue();
    	int key = pair.getKey();
    	for(int i = value; i > 0; i--){
    	list.add(key);
    }
    }
    Collections.sort(list);//return的结果要有序
	return  list;

}
