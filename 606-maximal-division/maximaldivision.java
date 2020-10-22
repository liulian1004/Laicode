public class Solution {
  public String maxDivision(int[] nums) {
    //a/b ==> a part is max, b part is min
    // a是第一个数， b是后面相除的结果集
    //因为a需要是最大的值，所以a不能除于任何【2，1000】的数，否则都小于a
    //所以唯一的情况是 a是第一个数，b是后面数相除
    //1000,100,10,2 ==> 1000/(100/10/2)
    if(nums.length == 1){
      return nums[0]+"";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(nums[0]);
    sb.append('/');
    if(nums.length == 2){
      sb.append(nums[1]);
      return sb.toString();
    }
    sb.append('(');
    for(int i = 1 ; i< nums.length;i++) {
      sb.append(nums[i]);
      sb.append('/');
    }
    sb.deleteCharAt(sb.length()-1);
    sb.append(')');
    return sb.toString();

  }

}
