public class Solution {
  public int[] keepDistance(int k) {
    // T: (2n) S: O(n)
    int[] array = new int[2 * k];
    //建立array acending
    for(int i = 0; i < k; i++) {
      array[i*2] = i + 1;
      array[i*2 +1] = i + 1;
    }
    // map < array[i], index]
    //查之前的元素是否进去过和index位置
    boolean[] used = new boolean[k+1];
    return helper(array, used, 0)? array : null;
  }
  private boolean helper(int[] array, boolean[] used, int index) {
    //base case
    if(index == array.length) {
      return true;
    }
    for(int i = index; i < array.length; i++) {
      int cur = array[i];
      //!used[cur]：没有用过，可以随意放第一位
      //第一次已经出现过，就要查是否在相隔的位置也有满足要求的，有的就swap
      if(!used[cur] || (index > cur && array[index-cur-1] == cur) ) {
        //吃
        swap(array,index, i);
        used[cur] = !used[cur];
        //recusrion
        if(helper(array, used, index + 1)){
          return true;
        }
        //吐
      swap(array, index,i);
      used[cur] = !used[cur];
      }
    }
    return false;
  }
  private void swap(int[] array, int i ,int j ) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;

  }
}
