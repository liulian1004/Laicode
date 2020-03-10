public class Solution {
  public List<String> allPermutationsOfSubsets(String set) {
    // permutation T: O(n! * n); S: O(n)
    //每一个node都打印，打印完成array [0,index)
    List<String> list = new ArrayList<>();
    if(set == null) {
      return list;
    } if(set.length() == 0) {
      list.add("");
      return list;
    }
    char[] array = set.toCharArray(); // T: O(n)
    helper(array, 0, list);
    return list;
  }
  private void helper(char[] array, int index, List<String> list) {
    //base case 是整个for loop走完
    //一进入helper就打印上一层的node
    list.add(new String(array,0, index));
    if(level == array.length) {
      return;
    }
    for(int i = index; i < array.length; i++) {
      swap(array, index, i);
      helper(array, index+1, list);
      swap(array, index, i);
    }
  }
  private void swap(char[] array, int i, int j) {
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
