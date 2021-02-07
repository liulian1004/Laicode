public class Solution {
  public double median(int[] a, int[] b) {
    // find the kth in the two sorted array
    int l1 = a.length;
    int l2 = b.length;
    if((l1+l2)%2 == 1) {
      // odd case
      int k = (l1+l2+1)/2;
      return helper(a,b,0,0,k)*1.0;
    }else{
      //even case
      int k1 = (l1+l2)/2;
      int k2 = k1+1;
      return (helper(a,b,0,0,k1) + helper(a,b,0,0,k2))/2.0;
    }
  }
  private int helper(int[] a, int[] b, int i, int j, int k){
    //out of bound, check the other size
    if(i >= a.length){
      return b[j+k-1];
    }
    if(j >= b.length){
      return a[i+k-1];
    }
    if(k == 1){
      return Math.min(a[i],b[j]);
    }
    //each array, find the k/2 th element, and compare
    // because of index, k/2 shall minus 1
    int m1 = i+ (k/2-1);
    int m2 = j + (k/2-1);
    int a1 = m1 >= a.length? Integer.MAX_VALUE: a[m1];
    int b1 = m2 >= b.length? Integer.MAX_VALUE: b[m2];
    // remove the smaller side or not out of bound side
    if(a1 >= b1){
        return helper(a,b,i,m2+1,k-(k/2));
    }
    return helper(a,b,m1+1,j,k-(k/2));
  }
}
