public class Solution {
  public String compress(String input) {
   // 1. 先从左到右，除出现一次的字母外，都变成字母+数字,count出现一个字母的次数
    //2. 更加count的数量扩容
    //3.从右到左扫描，碰到数字加字母直接copy，然后放1和字母
    char[] array = input.toCharArray();
    int slow = 0;
    int fast = 0;
    int newLength = 0;
    while(fast < array.length){
      int begin = fast;
      // move fast until point to the new letter
      while(fast < array.length && array[fast] == array[begin]) {
        fast++;
      }
      //copy the letter to slow from begin and move slow
      array[slow] = array[begin];
      slow++;
      //check whether it's duplicated
      //not duplicated
      if(fast - begin == 1) {
        //need 2 spaces for new array
        newLength = newLength + 2;
      } else{ // duplicated happend, calculated how many digitals need to insert
      //and insert the number
        int len = copyDigits(array, slow, fast - begin);
        // slow point move to the next element and wait for the next iteration
        slow = slow + len;
        // need len + 1(letter) space for new array
        newLength = newLength + len + 1;
      }
    }
    //step 2, traversel from right to left
    char[] res = new char[newLength];
    //fast point to the last element and ready to copy
    fast = slow - 1;
    // slow point to the end of array and ready to copy
    //slow = res.length - 1;
    slow = newLength - 1;
    while(fast >= 0) {
      // the fast pointer is digital(API)
      if(Character.isDigit(array[fast])) {
        while(fast >= 0 && Character.isDigit(array[fast])) {
        char a = array[fast];
        res[slow] = a;
        slow--;
        fast--;
        }
      } else {// non digitals
          res[slow] = '1';
          slow--;
      }
      //contiune copy, no matter the pre is number or letter
      res[slow] = array[fast];
      slow--;
      fast--;
    }
    return new String(res);
  }
  private int copyDigits(char[] array, int index, int count) {
    int len = 0;
    //index--;
    for(int i = count; i > 0 ; i = i /10) {
      //check how many digtal will have and leave the space
      len++;
      index++;
    }
    for(int i = count; i > 0; i = i / 10) {
        // calculate the digital and add
        int digit = i % 10;
        index--;
        // transfer the number to char and copy to array
        array[index] = (char)('0' + digit);
    }
    return len;
  }
}
