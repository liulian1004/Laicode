public class Solution {
  public int monotoneIncreasingDigits(int N) {
    //1. 找到第一个不满足要求的index
    //2. 从index-1开始递减1知道又满足要求
    //3.从第一个剪1+1的值开始flip成1
    //ie: 341 ,index是2==> 331，把4变成3==> 339，从第二位3后面的数开始变9
    char[] array = String.valueOf(N).toCharArray();
    //corner case 单数的时候返回其本身
    if(array.length <= 1){
      return N;
    }
    //从第二位开始找不满足条件的index
    int index = 1;
    for(int i = 1; i < array.length; i++){
        if(array[i-1] > array[i]){
          index = i;
          break;
        }
    }
    //从index-1开始对所有不满足条件的数-1
    while(index > 0 && array[index-1] > array[index]){
      index--;
      array[index]--;
    }
    for(int i = index+1; i < array.length;i++ ){
      array[i] = '9';
    }
    return Integer.valueOf(String.valueOf(array));
  }
}
