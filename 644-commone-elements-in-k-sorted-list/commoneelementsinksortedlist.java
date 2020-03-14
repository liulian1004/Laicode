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

}
