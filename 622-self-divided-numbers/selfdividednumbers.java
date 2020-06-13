public class Solution {
  public List<Integer> selfDivideNumbers(int low, int high) {
    // T: O(n) S: O(1)
    List<Integer> list = new ArrayList<>();
    for(int i = low; i <= high; i++) {
      if(valid(i)) {
        list.add(i);
      }
    }
    return list;
  }
  private boolean valid(int input) {
    int num = input;
    if(num == 0) {
      return false;
    }
    while(num > 0) {
      int digit = num % 10;
      if(digit == 0 || input % digit != 0) {
        return false;
      }
      num /= 10;
    }
    return true;
  }
}
