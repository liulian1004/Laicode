public class Solution {
  public List<String> permutations(String input) {
    // 3层 3个叉，2个叉，1个叉（remaining unused letters)
    // node:  1+n + n *(n-1) + n*(n-1)*(n-2) + ... n!
    //T:n!*n(n个字母排列是n！可能性，每个可能性遍历打印)
    //S：O(n)
    //如果input 是 空，res 是 n{" "}, 不是null
    List<String> res = new ArrayList<>();
    if(input == null) {
      return res;
    }
    char[] array = input.toCharArray();
    helper(array, 0, res);
    return res;
  }
  private void helper(char[] array, int index, List<String> res) {
    if(index == array.length) {
      res.add(new String(array));  //O(n)
      return;
    }
    //for loop用于多重分支，这里也起到来代替helper，吐了之后进入下一层recursion的作用
    //这里必须走到最后一个位数，即自己和自己swap，也是一种permuation的可能性
    for(int i = index; i< array.length; i++) {
      swap(array, index, i);
      helper(array, index + 1, res);
      swap(array, index, i);
    }
  }
  private void swap(char[] array, int left, int right) {
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
