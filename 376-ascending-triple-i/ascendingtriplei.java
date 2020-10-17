public class Solution {
  public boolean existIJK(int[] array) {
    // makee sure m1 < m2
    // case 1 :   update m2
    //i < m2 && i > m1
    //case2 : update m1, m2
    // i  < m2 && i < m1
    //case3 : do nothing
    // i > m2 && i > m1
    if(array.length <= 2){
      return false;
    }
    int m1 = Integer.MAX_VALUE;
    int m2 = Integer.MAX_VALUE;
    for(int i: array){
      if(m1 == Integer.MAX_VALUE){
        m1 = i;
        continue;
      }
      if(m2 == Integer.MAX_VALUE && i > m1){
        m2 = i;
        continue;
      }
      if(i > m2 && i < m1 ){
          m1 = m2;
          m2 = i;
          continue;
      }
      if(i < m2 && i > m1){
        m2 = i;
        continue;
      }
      if(i > m2 && m2 > m1){
        return true;
      }
    }
    return false;
  }
}
