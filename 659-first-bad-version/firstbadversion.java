class Solution extends VersionControl {
  public int findFirstBadVersion(int n) {
    // T: logn
    //corner case:
   if(isBadVersion(1)) {
     return 1;
   }
   //binary search find the first non-bad version
    int i = n;
    while(i >= 1) {
      if(!isBadVersion(i)) {
        break;
      }
      i = i / 2;
    }
    // find the first bad version from (i,2i)
    int k = i;
    while(k < i * 2) {
      if(isBadVersion(k)){
        break;
      }
      k++;
    }
    //return the first bad version
    return k;
  }
}
