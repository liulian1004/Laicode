public class Solution {
  public int largestSum(int[] array) {
    // T: O(n); S: O(1)
    // cur = cur largest subArray sum;
    // res: overall largest subArray sum
    //subarray must contain one elementl the largest subarray can consider the first one
    int cur = array[0];
    int res = array[0];
    for(int i = 1; i < array.length; i++) {
      //subArray is continouse
      // the largest Sum for the current subArray is pre + cur value || cur value(pre is negative)
      cur = Math.max(cur+array[i], array[i]);
      res = Math.max(cur, res);
    }
    return res;
  }
}
//follow up
//Given a red/green array, eg[r,r,r,g], find a subArray to make the max value of r- g
//T : O(n^2); S: O(n)
    //create R[i] , G[j]
    // max = Math.max(max, subarray[i, j]);
    private int difference(char[] array) {
        int[] R = new int[array.length + 1];
        int[] G = new int[array.length + 1];
        for(int i = 0; i < array.length ;i ++) {
            if(array[i] == 'R') {
                R[i+1] = R[i] + 1;
            } else {
                R[i+1] = R[i];
            }
            if(array[i] == 'G') {
                G[i+1] = G[i] + 1;
            } else {
                G[i+1] = G[i];
            }
        }
        //linear scan array
        int max = 0;
        for(int i = 0; i < array.length;i++) {
            for(int j = 0; j <array.length; j++) {
                //subarray [ i, j]
                max = Math.max(max, Math.abs((R[i+1] - R[j]) - (G[i+1] - G[j])));
            }
        }
        return max;
    }
//老师的solution
// for subArray[i,j]
// r-g =（jR - iR) - (jG-iG) = jR - JG + (iG-iR)
// 如果固定j jR - jG即为常数，只需要找到max（iG-iR）， 即maxSeen
//T： O(n) ;S O(1)
int solve(char[] a) {
  int res = 0;
  int maxSeen = 0;
  int iG = 0;
  int iR =0;
  for(int i = 0; i < array.length ; i++) {
    if(a[i] == 'G') {
      iG++;
    }else {
      iR++;
    }
    res = Math.max(res,iR-iG + maxSeen);
    maxSeen = Math.max(maxSeen, iG-iR);
  }
}
