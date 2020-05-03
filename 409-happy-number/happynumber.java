public class Solution {
  public boolean isHappy(int n) {
    // fast/slow + linkedlist ==》loop查重
    //T: O(n) --> the length of linkedlist
    if(n <= 0){
        return false;
    }
    if(n == 1){
      return true;
    }
    // fast go two steps, slow go one step
    int slow = getNum(n);
    int fast = getNum(getNum(n));
    while(slow != fast){
      slow = getNum(slow);
      fast = getNum(getNum(fast));
    }
    //case 1 : infinital loop, fast != 1
    // case 2: fast == slow == 1
    return fast == 1;
  }
  private int getNum(int n){
        int res = 0;
        while(n > 0){
            int temp = n % 10;
            res += temp*temp;
            n = n /10;
        }
        return res;
  }
}
// naive Solution

public boolean isHappy(int n) {
   //set查loop
   //T: O(n) --> the number of recusiver
   //S: O(n) --> the number of recusiver
   if(n <= 0){
       return false;
   }
   if(n == 1){
     return true;
   }
   Set<Integer> set = new HashSet<>();
   int cur = getNum(n);
   while(cur != 1) {
     cur = getNum(cur);
     if(set.contains(cur)) {
       return false;
     }
     set.add(cur);
   }
   return true;
 }
