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
    // int[][] ret = new int[res.size()][3];
    List<int[]> ret = new ArrayList<>();
    prev = res.get(0);
    int[] cur = prev;
    for(int j = 1; j < res.size(); j++){
      cur = res.get(j);
      if (prev[2] == cur[2] && prev[1] == cur[0]) {
        prev = new int[]{prev[0], cur[1], prev[2]};
        cur = prev;
        continue;
      }
      if (prev[2]!=0) {
        ret.add(prev);
      }
      prev = cur;
    }
    if (cur[2]!=0) {
      ret.add(cur);
    }
    int[][] result = new int[ret.size()][];
    result = ret.toArray(result);
    return result;
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
