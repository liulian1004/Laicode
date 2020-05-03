class Solution extends VersionControl {
  public int findFirstBadVersion(int n) {
    // T: logn S: O(1)
    if(n <= 0) {
        return -1;
      }
      if(n == 1){
              return 1;
          }
          int left = 1;
          int right = n;
          while(left < right - 1) {
              int m = left + (right - left) / 2;
              if(isBadVersion(m)) {
                  right = m;
              }else{
                  left = m + 1;
              }
          }
          if(isBadVersion(left)) {
              return left;
          }
          if(isBadVersion(right)) {
              return right ;
          }
          return -1;
    }
}
