public class Solution {
  public int minDifference(int[] array) {
    // Write your solution here
    if(array.length <= 1) {
      return array[0];
    }
    int[] diff = new int[]{Integer.MAX_VALUE};
    List<Integer> cur = new ArrayList<>();
    int sum = getSum1(array);
    helper(array, cur, diff, sum, 0);
    return diff[0];
  }
  private void helper(int[] array, List<Integer> cur, int[] diff, int sum, int index) {
    if(index == array.length) {
        if(cur.size() == array.length / 2) {
                //计算出subset的sum
                int subSetSum = getSum2(cur);
                //计算出剩余subset的sum
                int another = sum - subSetSum;
                //取绝对值更新diff
                diff[0]= Math.min(diff[0], Math.abs(another - subSetSum));
            }
        return;
    }
    cur.add(array[index]);
    helper(array, cur, diff, sum, index + 1);
    cur.remove(cur.size() - 1);
    helper(array, cur, diff, sum, index + 1);
  }
  private int getSum1(int[] array) {
    int sum = array[0];
    for(int i = 1; i < array.length; i++) {
      sum += array[i];
    }
    return sum;
  }
  private int getSum2(List<Integer> cur) {
    int sum = cur.get(0);
    for(int i = 1; i < cur.size(); i++) {
      sum += cur.get(i);
    }
    return sum;
  }
}
