public class Solution {
  //S：O(n)
  // T: O(n^2) = n^2 + 1/2 n * 1/2 n ....
  //create the additional class keep the element and elements which are compared with this element
  class Element{
      int value;
      List<Integer> list;
      public Element(int value){
        this.value = value;
        this.list = new ArrayList<>();
      }
    }
  public int[] largestAndSecond(int[] array) {
    // 前后两两比较和折半前进查找

    if(array == null || array.length <= 1) {
      return new int[]{};
    }
    int n = array.length;
    Element[] newArray = convert(array);
    //每次比较的长度
    //长度最少为2
    for(int i = n ; i > 1; i = (i+1)/2) {
      compare(newArray, i);
    }
    return new int[]{newArray[0].value, largest(newArray[0].list)};
  }

  //把array内的元素换到Elment里
  private Element[] convert(int[] array) {
    Element[] newArray = new Element[array.length];
    for(int i = 0; i < array.length; i++) {
      newArray[i] = new Element(array[i]);
    }
    return newArray;
  }

  //两指针相向而行，互相比大小
  //小的那一个元素放在list里面
  private void compare(Element[] newArray, int length){
    //单数位不需要比较，所以这里是 length / 2
    for(int i = 0; i < length / 2; i++) {
      if(newArray[i].value < newArray[length - 1 -i].value) {
        //连着value和list一起swap
        swap(newArray, i, length-1-i);
      }
      //无论是否swap,都需要把loser放入list中
      newArray[i].list.add(newArray[length-1-i].value);
    }
  }

  private void swap(Element[] newArray, int a, int b){
    Element temp = newArray[a];
    newArray[a]= newArray[b];
    newArray[b] = temp;
  }

  //找到list里最大的元素，即第二大元素
  private int largest(List<Integer> list) {
    int second = Integer.MIN_VALUE;
  	for(int i: newArray[0].list) {
  		second = Math.max(second, i);
    }
    return sceond;
  }
}
