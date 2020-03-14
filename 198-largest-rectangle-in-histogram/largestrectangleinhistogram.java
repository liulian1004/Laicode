public class Solution {
  public int largest(int[] array) {
    //T： O(n); S:O(n)
    //每一node只能进stack一次，出stack一次，时间复杂度是O(n)
    // one for loop + linear scan+回头看（stack）
    //每一次poll出计算的面积是index of stakc.pollFirst() 往left方向的最大rectangle 面积
    //递增就把high放到stack里
    //递减就poll出来stack算面积
    int size = 0;
    //stack里存的是index
    //为里计算左边界
    Deque<Integer> stack = new ArrayDeque<>();
    //需要循环到最后一位的多一位
    for(int i = 0; i <= array.length; i++){
      //记录每一位index对应的height
      //最后一次循环已经出边界，height 为 0
      int cur = (i == array.length? 0: array[i]);
      //如果此轮的height比上一轮小或者等于上一轮
      //进入计算 rectangle的算法
      while(!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
        int height = array[stack.pollFirst()];
        //left的边界是stack的新的peek 往右移一位
        //注意如果stack里已经poll完了，说明走到了起始点，为0
        int left = stack.isEmpty() ? 0: stack.peekFirst() + 1;
        //以下方法错误，因为stack中间有些值以及poll出
        //stack.peekFirst() + 1 != stack.peekFirst-->poll之前的index
        //int left = stack.pollFirst();
       //int height = array[left];
        size = Math.max(size, height * (i - left));
      }
      //无论是否之前poll出，都将这一轮index放入stack
      stack.offerFirst(i);
    }
    return size;
  }
}
