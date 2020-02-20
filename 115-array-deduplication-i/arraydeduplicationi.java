public int[] dedup(int[] array) {
    // T: O(n) S: O(1)
    if(array == null) {
      return array;
    }
    if(array.length <= 1) {
      return array;
    }
    int slow = 1;
    for(int fast = 1; fast < array.length; fast++) {
        if(array[fast] != array[slow - 1]) {
          array[slow] = array[fast];
          slow++;
        }
  }
  return Arrays.copyOf(array,slow);
}
}
