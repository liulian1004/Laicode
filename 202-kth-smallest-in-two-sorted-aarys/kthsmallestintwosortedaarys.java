public class Solution {
  public int kth(int[] a, int[] b, int k) {
    //也会问find media value of two sort array
    //naive way: two pointers to linear scan two array k times
     //binary reaserch
     //谁小删谁，k越界直接删另一边开删
     // compare a[2/k -1] and b[2/k-1], delete the smaller one
     // proof by contradiction
     //如果 target a[i] < a[2/k -1]<b[2/k-1], a[i] is the kth smallest elemment
     // then i + 2/k - 1 must == k -2, but it's wrong, actually it's smaller than k -2
     //T: logk S: logK(层数和k相关)
     //tree的结构是logk层，每层时间复杂度是1
     //tree是直上直下一条线，没有分支，因为这里是or的选择
     //这里只是只要看左边的bound,因为都是从左边减
    return helper(a, 0, b, 0, k);
  }
  private int helper(int[] a, int leftA, int[] b,int leftB, int k) {
    //三个base case
    //nothing left for a; nothing left for b; k == 1
    if(leftA >= a.length) {
      return b[leftB+ k-1];
    }
    if(leftB >= b.length) {
      return a[leftA + k -1];
    }
    if(k == 1) {
      return Math.min(a[leftA], b[leftB]);
    }
    //折半的index
    int aMid = leftA + (k/ 2 - 1);
    int bMid = leftB + (k /2 - 1);
    //如果超界，直接赋最大值，用于标记这一轮直接删另一半
    int aVal = aMid >= a.length ? Integer.MAX_VALUE: a[aMid];
    int bVal = bMid >= b.length? Integer.MAX_VALUE: b[bMid];
    //谁小移谁
    //这里的 k - k/2 等同于 k/2 因为要考虑到奇偶性
    if(aVal <= bVal){
      return helper(a, aMid+1, b, leftB, k - k/2);
    } else{
      return helper(a, leftA, b, bMid+1, k - k/2);
    }
  }
}
