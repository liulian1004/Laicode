public class Solution {
  public int maxTrapped(int[] array) {
    //这个solution是greedy，要证明
    //T: O(n); S: O(1)
    //蓄水能力 = Math.min(leftBound, rightBound) - 柱子的高度 或 0(如果之前的值是负数)
    //最旁边的两边柱子都蓄不了水
    if(array == null || array.length <= 2) {
      return 0;
    }
    int left = 0;
    int right = array.length - 1;
    int lmax = array[left];
    int rmax = array[right];
    int result = 0;
    while(left < right) {
      if(array[left] <= array[right]) {
        //result += Math.max(0, lmax-array[left]);
        lmax = Math.max(array[left], lmax);
        left++;
      }
      //lmax < rmax
      if(array[right] < array[left]) {
        result += Math.max(0, rmax-array[right]);
        rmax = Math.max(array[right], rmax);
        right--;
      }
    }
    return result;
  }
}
//my Solution DP
public int maxTrapped(int[] array) {
    //T: O(n); S: O(n)
    //蓄水能力 = Math.min(leftBound, rightBound) - 柱子的高度 或 0(如果之前的值是负数)

    if(array == null || array.length <= 2) {
      return 0;
    }
    int left = 0;
    int right = array.length - 1;
    int[] lmax = new int[array.length];
    int[] rmax = new int[array.length];
    int leftMax = array[0];
    int rightMax = array[array.length - 1];
    // calcuate the lmax, (excluding leftbound & rightbound)
    //lmax[i] = the highest pillar from 0 to i -1
    for(int i = 1; i < array.length - 1; i++) {
      lmax[i] = Math.max(leftMax, array[i-1]);
      leftMax = lmax[i];
    }
    //rmax[i] = the highest pillar from array.length -1 to i +1
    for(int i = array.length -2; i > 0; i--) {
      rmax[i] = Math.max(rightMax, array[i+1]);
      rightMax = rmax[i];
    }
    int result = 0;
    // calcuate the water trap for each column(excluding leftbound & rightbound)
    for(int i = 1; i <array.length -1;i++) {
      result += Math.max(0, Math.min(rmax[i],lmax[i]) - array[i]);
    }

    return result;
  }
}
