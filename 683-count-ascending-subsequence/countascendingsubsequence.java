public class Solution {
  public int numIncreasingSubsequences(int[] a) {
    // 单独的一个element算一个
    // m[i] present the number of ascending subsequence ends at a[i]
    // options 1: 自成一派 ==>1
    //option 2: 如果比之前的元素小， ==》 0
    // option 3: 如果比之前的元素大 ==》 + m[j]
    // 跟新result = sum of M[i]
    //T： O(n^2); S: O(n)

    int result = 0;
        if(a == null || a.length == 0) {
            return result;
        }
        int[] m = new int[a.length];
        for(int i = 0; i < a.length; i++) {
          //intializaion是1，因为自己可以算一个subsequet
            m[i] = 1;
            for(int j = 0; j < i; j++) {
                if(a[j]< a[i]) {
                    m[i] += m[j];
                }
            }
            result += m[i];
        }
        //in case overflow
        //%10^9+7范围在integer范围内
        //有些题目结果只关心在有效范围内的数值
        return result %((int)(Math.pow(10.0,9.0) + 7));
  }
}
