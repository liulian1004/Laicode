public class Solution {
  public int[][] diff(int[] a, int[] b) {
    // Write your solution here
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    int i = 0;
    int j = 0;
    while(i < a.length && j < b.length){
      int a1 = a[i];
      int b1 = b[j];
      if(a1 < b1){
          l1.add(a1);
          i++;
      }else if(a1 > b1){
        l2.add(b1);
        j++;
      }else{
        i++;j++;
      }
    }
    while(i < a.length){
      l1.add(a[i++]);
    }
    while(j < b.length){
      l2.add(b[j++]);
    }
    int[][] res = new int[2][];
    res[0] = new int[l1.size()];
    for(int k = 0; k < l1.size(); k++){
        res[0][k] = l1.get(k);
    }
   res[1] = new int[l2.size()];
    for(int k = 0;  k< l2.size() ;k++){
        res[1][k] = l2.get(k);
    }
    return res;
  }
}
