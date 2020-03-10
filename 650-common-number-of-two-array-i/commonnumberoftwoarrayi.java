public class Solution {
  public List<Integer> common(int[] a, int[] b) {
    //no duplicated , two pointer, space good, time worse
    //this is the best solution if array is sorted
    // T: nlogn + mlogm + n + m
    //S : O(1)
    List<Integer> list = new ArrayList<>();
    if(a.length == 0 && b.length == 0) {
      return list;
    }
    Arrays.sort(a); //nlogn
    Arrays.sort(b);
    int i = 0;
    int j = 0;
    while( i < a.length && j < b.length) {
      if(a[i] == b[j]) {
        list.add(a[i]);
        i++;
        j++;
      } else if(a[i] < b[j]) {
        i++;
      }else {
        j++;
      }

    }
    return list;
  }
}
//solution 2: hashset, the best solution to unsorted array
//s : O(n)
//T: O(n + m + llogl)
//similare to solution 651

//soluton 3 if n<<<<<<<< m
// binary search
//  n *logm + mlogm + n*logm

private List<Integer> com(int[] A, int[] B) {
        List<Integer> res = new ArrayList<>();
        if (A.length == 0 || B.length == 0) {
            return res;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        int left = 0;
        while (i < A.length && left < B.length) {
          //用于查重
          //元素相同 直接加入list
            if (A[i] == B[left]) {
                res.add(A[i]);
                i++;
                left++;
                continue;
            }
            // A[1] != B[left]
            int index = bs(B, left, B.length - 1, A[i]);
            if (index == -1) {
                i++;
                continue;
            }
            // index != -1
            res.add(B[index]); // res.add(A[i]);
            i++;
            left = index + 1;
        }
        return res;
    }

    /**
     * return the smallest index in B if multiple matches are found, otherwise return -1.
     */
    private int bs(int[] B, int left, int right, int target) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (B[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (B[left] == target) {
            return left;
        }
        //left 可能会== right ，在bs这里传入的时候就没有走到while loop里面
        // if(B[left + 1] == target) {
        //     return left+1;
        // }
        if (B[right] == target) {
            return right;
        }

        return -1;

    }

}
