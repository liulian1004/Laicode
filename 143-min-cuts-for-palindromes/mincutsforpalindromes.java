public int minCuts(String input) {
    // m[i] : min cut for palindrome from [0,i] of string
    // base m[0] = 0; result: m[i-1]
    // i  = length, j presents the index of cut, start from index 1;
    // induction rule:
    // case 1 [0,i] is palindrome, m[i] = 0
    // case 2 [j,i] is palindrome, m[i] = min(m[j-1]) + 1
    // T: O(n^3) + O(n) S: O(2n)
    if(input == null || input.length() <= 1) {
      return 0;
    }
    char[] array = input.toCharArray();
    int[] m = new int[array.length];
    m[0]= 0;
    for(int i = 1; i < array.length; i++) {
      if(isValid(array, 0, i)) {
        m[i] = 0;
        continue;
      }
      //求最小值，需要先把m初始化成最大posibility
      //m[i]最多切 array.length -1刀
      m[i] = array.length - 1;
      for(int j = 1; j <=i; j++) {
        if(isValid(array, j, i)){
          m[i]= Math.min(m[i], (m[j-1] + 1));
        }
      }
    }
    return m[array.length - 1];
  }
  private boolean isValid(char[] array, int beg, int end) {
    while(beg <= end) {
      if(array[beg] != array[end]) {
        return false;
      }
      beg++;
      end--;
    }
    return true;
  }

}
