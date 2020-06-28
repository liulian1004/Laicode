public class Solution {
  public boolean checkSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    //T: O(n) S: O(n)
   //valid square:
   //两点的距离不能为0
   //4各点有6各组合关系
   //其中4 条边相等，2条对角线相等
    Map<Integer, Integer> map = new HashMap<>();
    int l12 = getDistance(p1,p2);
    int l13 = getDistance(p1,p3);
    int l14 = getDistance(p1,p4);
    int l23 = getDistance(p2,p3);
    int l24 = getDistance(p2,p4);
    int l34 = getDistance(p3,p4);
    if(l12 == 0 || l13 == 0 || l14 == 0 || l23 == 0 || l24 == 0 || l34 == 0) {
      return false;
    }
    map.put(l12, map.getOrDefault(l12,0)+1);
    map.put(l13, map.getOrDefault(l13,0)+1);
    map.put(l14, map.getOrDefault(l14,0)+1);
    map.put(l23, map.getOrDefault(l23,0)+1);
    map.put(l24, map.getOrDefault(l24,0)+1);
    map.put(l34, map.getOrDefault(l34,0)+1);
    return (map.size() == 2 && (map.get(l12) == 2 || map.get(l12) == 4));
  }

    private int getDistance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

}
