public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    // T: O(n)-the shortest length
    //S:O(1)
    List<Integer> list = new ArrayList<>();
    if(a.length == 0 || b.length == 0 || c.length == 0) {
      return list;
    }
    int i = 0;
    int j = 0;
    int k  = 0;
    while(i < a.length && j < b.length && k < c.length) {
      if(a[i] == b[j] && b[j] == c[k]) {
        list.add(a[i]);
        i++;
        j++;
        k++;
        //注意在三个都不相等的情况下考虑 其中有两个相等，即要把等于号写上
      } else if(a[i]<= b[j] && b[j] <= c[k]) {
        i++;
      }else if(a[i] >= b[j] && b[j] <= c[k]){
        j++;
      }else{
        k++;
      }
    }
    return list;
  }
}
