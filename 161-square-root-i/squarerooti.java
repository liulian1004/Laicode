public class Solution {
  public int sqrt(int x) {
    //binary searach
    // eg: x = 24 => return 4
    // x = 25 => return 5
    //corner case x = Integer.MAX_VALUE , 这里需要righbound需要是ceil，因为square的时候会想下取整，那么这样会漏解
    int left = 1;
    double rightBound = Math.sqrt(Integer.MAX_VALUE);
    int right = (int)Math.ceil(rightBound);
        while(left < right){
            int mid = left + (right-left)/2;
            long sqr = mid*mid;
            long target = x*1l;
            if(sqr == target){
                return mid;
            }
            if(sqr > target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left-1;
  }
}
