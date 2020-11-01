public class Solution {
  public boolean isOneBit(int[] bits) {
    // check whether the last pair is 0 or 10
    // ie 0,1,1,0 ==> 0, 11, 0 ==> return false
    //ie 1,1,1,0 ==> 11, 10==>return true
    if(bits.length == 1){
      return true;
    }
    int i = 0;
    while(i < bits.length -2){
        if(bits[i] == 1){
          i = i+2;
        }else{
          i++;
        }
    }
    if(i == bits.length -2 && bits[i] == 1){
      return false;
    }
    return true;
  }
}
