public class Solution {
  public void shuffle(int[] array) {
    // Math.random --> [0, 1) 区间内的double
    //double = 0.9, (int) double = 0;
    //Date Structure: nu-shuffle || shuffled
    for(int i = array.length-1; i >= 0; i--){
      //这里必须要i+1，随机数的范围需要是【1，n）incase 随机数出来位0.2 => 取int之后会变成0
        int index = (int)(Math.random()*(i+1));
        int temp = array[index];
        array[index] = array[i];
        array[i] = temp;
    }
  }
}
