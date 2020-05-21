public class Solution {
  public List<String> permutations(String input) {
    // T: n!*n (the same as non-duplicated permutation)
    // S: n *n = n^2
    char[] array = input.toCharArray();
    List<String> res = new ArrayList<>();
    if(input == null) {
      return res;
    }
    helper(array,0, res);
    return res;
  }

  private void helper(char[] array, int index, List<String> res) {
    if(index == array.length) {
      res.add(new String(array));
      return;
    }
    //set up the new set in each recursion
    Set<Character> used = new HashSet<>();
    // i is the element need to be check and swap
    for(int i = index; i < array.length; i++) {
      // if it is the repeated element, no need to swap ,just ignore
      //重复的元素即使是在这个一层看上去没有重复，往后走也会重复的
      if(used.add(array[i])) {
        //add the element before swap
        swap(array, index, i);
        helper(array, index + 1, res);
        swap(array, index, i);
      }
    }
  }

  private void swap(char[] array, int i, int j){
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
