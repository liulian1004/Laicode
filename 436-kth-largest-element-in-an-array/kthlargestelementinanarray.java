public class Solution {
  public int findKthLargest(int[] nums, int k) {
    // S： O(height) T worse: T:O(n^2) average T: O
    //partion and swap
    if(nums == null || nums.length == 0 || k<= 0 || k > nums.length) {
      return -1;
    }
    return helper(nums,k, 0, nums.length - 1);
  }

  private int helper(int[] nums, int k, int left, int right) {
    if(k == 1) {
      int max = nums[left];
      for(int index = left+1; index <= right; index++) {
          max = Math.max(nums[index], max);
      }
      return max;
    }
    int pivot = left + (int)(Math.random()*(right - left + 1));
    swap(nums, pivot, right);
    //int pivot = right; 也可
    int i = left;
    int j = right - 1;
    while(i <= j) {
      if(nums[i] >= nums[right]) {
        i++;
      }else{
        swap(nums, i, j);
        j--;
      }
    }
    swap(nums, right, i);
    //ba care index start from 0, add "1" back
    if(i-left + 1 == k) {
      return nums[i];
    } else if(i - left + 1 < k) {
      k = k - (i-left+1);
      //left/right bound必须减小，否则会overflow
      return helper(nums,k, i+1, right);
    }
    return helper(nums,k,left, i-1);
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
//follow up
public List<Integer> findKthLargest(int[] nums, int k, int target) {
        // S： O(height) T:(n * height * k)
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        helper(nums,k,0,nums.length-1,target,list);
        return list;
    }

    private void helper(int[] nums, int k, int left, int right, int target, List<Integer> list) {
        if (k == 1) {
            int res = nums[left];
            int diff = Math.abs(res - target);
            for (int index = left + 1; index <= right; index++) {
                if(diff > Math.abs(nums[index] - target)) {
                    diff = Math.abs(nums[index] - target);
                    res = nums[index];
                }
            }
            list.add(res);
            System.out.println("list "+list);
            return;
        }

        // the diff of target and pivot
        int pivot = Math.abs(nums[right] - target);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (Math.abs(nums[i] - target) <= pivot) {
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, right, i);
        if (i - left + 1 == k) {
            for (int p = left; p <= i; p++) {
                list.add(nums[p]);
            }
            return;
        } else if (i - left + 1 < k) {
            for (int p = left; p <= i; p++) {
                list.add(nums[p]);
            }
            k -= (i-left+1);
            helper(nums, k, i + 1, right,target,list);
            return;
        }
        helper(nums, k, left, i - 1,target,list);
        return;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
