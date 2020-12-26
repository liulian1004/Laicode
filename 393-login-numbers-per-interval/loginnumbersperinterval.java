public class Solution {
  public int[][] sessionNum(int[][] logins) {
    // T: o(n) S: o(n)
    List<int[]> list = buildList(logins);
    List<int[]> res = new ArrayList<>();
    Collections.sort(list, new MyCompare());
    int[] prev = list.get(0); // new int[2];
    int count = 1;
    for(int i = 1; i < list.size(); i++){
      int[] cur = list.get(i);
      //坐标值不一样，且count ！=0,j
      if(cur[0] != prev[0] && count != 0){
          res.add(new int[]{prev[0], cur[0],count});
      }
      count += cur[1];
      prev = cur;
    }
    //post-processing
    prev = res.get(0);
    List<int[]> result = new ArrayList<>();
    result.add(prev);
    for(int i = 1; i < res.size(); i++){
          int[] cur = res.get(i);
          //这里需要重新检查一样，确保没有1，2，1 和 2，4，1的情况出现
          //如果有，需要删除前一次，重新update
          if(cur[2] == prev[2] && prev[1] == cur[0]){
            result.remove(result.size()-1);
            prev = new int[]{prev[0],cur[1], prev[2]};
            result.add(prev);
          }else{
            result.add(cur);
            prev = cur;
          }
        }
        //result.add(prev);
        int[][] fina = new int[result.size()][];
        fina = result.toArray(fina);
        return fina;

  }
  private List<int[]> buildList(int[][] array){
    List<int[]> list = new ArrayList<>();
    for(int[] i: array){
      list.add(new int[]{i[0],1});
      list.add(new int[]{i[1],-1});
    }
    return list;
  }
  private class MyCompare implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b){
      if(a[0] == b[0] && a[1] == b[1]){
        return 0;
      }
      if(a[0] < b[0] || a[0] == b[0] && a[1]<b[1]){
        return -1;
      }
      return 1;
    }
  }
}
