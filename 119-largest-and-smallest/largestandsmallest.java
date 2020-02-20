public class Solution {
  public int[] largestAndSmallest(int[] array) {
    // reorder the array to [larger numbers, small numbers] via swap // T: O(2/n)
    // find the largest number from the large numbers // T: O(2/n)
    // fine the smallest number from the smalle numbers // T: O(2/n)
    //Comprasion: 1.5 n
    //T： O(n); S:O(1)
    int n  = array.length;
    if(array.length <= 1) {
      return new int[]{array[0], array[0]};
    }
    for(int i = 0; i < n/2; i++) {
      if(array[i] < array[n-1-i]) {
        swap(array, i, n-1-i);
      }
    }
    // (n-1) / 2 != n/2 -1
    //这里要用（n-2）/2
    int l = findL(array, 0 , (n-1) / 2);
    int s = findS(array, n/2, n-1);
    return new int[]{l,s};
  }
  private int findL(int[] array, int left, int right) {
      int largest = array[left];
      for(int i = left + 1; i <= right; i++) {
        largest = Math.max(array[i], largest);
      }
      return largest;
  }
  private int findS(int[] array, int left, int right) {
    int smallest = array[left];
    for(int i = left + 1; i <= right; i++) {
      smallest = Math.min(array[i], smallest);
    }
    return smallest;
  }
  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
