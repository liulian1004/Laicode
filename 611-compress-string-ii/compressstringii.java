public class Solution {
  public String compress(String input) {
   // 1. 先从左到右，除出现一次的字母外，都变成字母+数字,计算出现一个字母的次数,并计算出res array的长度。 ie ab2c
    //2. 扩容（或产生新的数组）
    //3.从右到左扫描，碰到数字直接copy，碰到字母先加一，然后copy字母-
    char[] array = input.toCharArray();
    int slow = 0;
    int fast = 0;
    int newLength = 0;
    while(fast < array.length){
      //for mark the range of repeated letter
      int begin = fast;
      // move fast until point to the new letter
      // no matter whatever, fast will move at least one step
      while(fast < array.length && array[fast] == array[begin]) {
        fast++;
      }
      //copy the letter to slow from begin and move slow
      array[slow] = array[begin];
      slow++;
      //check whether it's duplicated
      //not duplicated
      if(fast - begin == 1) {
        //need 2 spaces for new array, letter + number
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
    //fast point to the last element and ready to copy,point to array
    fast = slow - 1;
    // slow point to the res array and ready to copy
    //slow = res.length - 1;
    slow = newLength - 1;
    while(fast >= 0) {
      // the fast pointer is digital(API)
      // 如果碰到字母，i先变1， i++
      // 如果碰到数字，直接copy数字untilend
      if(Character.isDigit(array[fast])) {
        // if it's the number
        while(fast >= 0 && Character.isDigit(array[fast])) {
        res[slow] = array[fast];
        slow--;
        fast--;
        }
      } else {// not number
          res[slow] = '1';
          slow--;
      }
      //contiune copy, no matter the pre is number or letter
      //之后copy 字母
      res[slow] = array[fast];
      slow--;
      fast--;
    }
    return new String(res);
  }
  private int copyDigits(char[] array, int index, int count) {
    int len = 0;
    for(int i = count; i > 0 ; i = i /10) {
      //check how many digtal will have and leave the space
      len++;
      //slow要移动，给添加的数字流位置
      index++;
    }
    for(int i = count; i > 0; i = i / 10) {
        // calculate the digital and add
        int digit = i % 10;
        //slow指针回到之前的位置，装上数字
        index--;
        // transfer the number to char and copy to array
        array[index] = (char)('0' + digit);
    }
    return len;
  }
}
