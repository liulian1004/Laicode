public class Solution {
  public int[] longest(int[] array) {
    // Write your solution here
    //m[i] presents the longest ascending subsequence ends at a[i];
    // pre[i] present the index of predecessor to acheive m[i]
    //T: O(n^2); S: O(1)
    if(array == null || array.length == 0) {
      return new int[]{};
    }
    int[] m = new int[array.length];
    int[] prev = new int[array.length];
    for(int i = 0; i < array.length; i++) {
      m[i] = 1;
      prev[i] = -1;
      for(int j = 0; j < i; j++) {
        if(array[j] < array[i] && m[i] < m[j] + 1 ) {
          m[i] = m[j] + 1;
          prev[i] = j;
        }
      }
    }
    //find the maxIndex
    int maxIndex = 0;
    for(int i = 0; i < array.length;i++) {
      if(m[i] > m[maxIndex]) {
        maxIndex = i;
      }
    }
    // track back to print list
    List<Integer> list = new ArrayList<>();
    list.add(array[maxIndex]);
    while(prev[maxIndex] != -1) {
        list.add(array[prev[maxIndex]]);
        maxIndex = prev[maxIndex];
    }
    //traversal list to int[]
    int size = list.size();
    int[] result = new int[size];
    for(int i = 0; i < size ;i++) {
      result[i] = list.get(size - 1 - i);
    }
    return result;
  }
}
