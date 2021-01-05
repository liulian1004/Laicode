public class Solution {
  public int largest(int[] array) {
    //T： O(n); S:O(n)
    //每一次看最高的柱子能有多大的size
    //linear scan and look back
    //每一node只能进stack一次，出stack一次，时间复杂度是O(n)
    // one for loop + linear scan to find the right bound and look back to find the left bound from stack
    // stack： keep the possible left bound
    //每一次poll出计算的面积是index of stakc.pollFirst() 往left方向的最大rectangle 面积
    //递增就把high放到stack里
    //递减就poll出来stack算面积
    int size = 0;
    //stack里存的是index
    //为了计算左边界
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
  // my code
  int size = 0;
    if(array == null || array.length == 0) {
      return size;
    }
    Deque<Integer> stack = new ArrayDeque<>();
    for(int i = 0; i <= array.length; i++) {
      int rightBoundHeight = i < array.length? array[i] : 0;
      while(!stack.isEmpty() && rightBoundHeight <= array[stack.peekFirst()] ) {
        int height = array[stack.pollFirst()];
        int right = i;
        int left = stack.isEmpty()? 0 :stack.peekFirst() + 1;
        size = Math.max(size, height * (right - left));
      }
      stack.offerFirst(i);
    }
    return size;
  }
  // T： n^2 中心开花
  //每一次看最矮的柱子的最大面积
  //计算每一个i左右两边比他大的柱子
  //然后计算已i为中心的最大面积
  public int largestRectangleArea(int[] heights) {
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            int height = heights[i];
            int count = 1;
            if(i > 0){
                count += goLeft(i-1,0,height,heights);
            }
            if(i < heights.length-1 ){
                count += goRight(i+1, heights.length-1, height,heights);
            }
            res = Math.max(res, height*count);
        }
        return res;
    }
    private int goLeft(int start, int end, int target, int[] array){
        int count = 0;
        for(int i = start; i >= end; i--){
            if(array[i] < target){
                break;
            }
            count++;
        }
        return count;
    }
    private int goRight(int start, int end, int target, int[] array){
        int count = 0;
        for(int i = start; i <= end; i++){
            if(array[i] < target){
                break;
            }
            count++;
        }
        return count;
    }
}
