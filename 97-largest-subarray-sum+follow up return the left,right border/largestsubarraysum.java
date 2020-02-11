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

private List<Integer> borderOfLargestSubArray(int[] array) {
        List<Integer> res = new ArrayList<>();
        //base case: array[0];
        int left = 0;
        int curLeft = 0;
        int right = 0;
        int curLargest = 0;
        int largest = 0;
        for(int i = 1; i < array.length; i++) {
            //calculate from beginning
            if(curLargest < 0) {
                curLargest = array[i];
                curLeft = i;
                // pre + cur
            } else {
                curLargest = array[i] + curLargest;
            }
            // update globalleft, globalright, largest
            if(curLargest > largest) {
                largest = curLargest;
                left = curLeft;
                // right index always the end index based on the m[i] semantic
                right = i;
            }

        }
        res.add(left);
        res.add(right);
        return res;

    }
