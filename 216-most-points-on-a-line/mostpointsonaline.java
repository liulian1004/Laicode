/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
  public int most(Point[] points) {
    //T： O(n^2) S: O(n)
    // for loop i, j
    //把i 和除他以外的其他点比较
    //case1: 和i点重复 same++
    //case2 和i点在同一个 x axle
    //case 3: 同一个斜率, 用map<double scope, integer, count>
    // 每一轮 max(case2, case3) + case1
    // update global max
    if(points.length == 1) {
      return 1;
    }
    int res = 0;
    for(int i = 0; i < points.length; i++) {
      int cur = 0;
      int same = 0;
      int xAxle = 0;
      int scope = 0;
      Map<Double, Integer> map = new HashMap<>();
      for(int j = 0; j < points.length; j++) {
        if(i == j || (points[i].x == points[j].x && points[i].y == points[j].y)) {
          same++;
        }else if(points[i].x == points[j].x) {
          xAxle++;
        }else {
          //这里要手动减去一个0.0,in case 这里的结果是整数
          double rate = (points[i].y - points[j].y- 0.0) / (points[i].x - points[j].x) ;
          map.put(rate, map.getOrDefault(rate,0)+1);
          scope = Math.max(scope, map.get(rate));
        }
      }
      cur = Math.max(xAxle, scope) + same;
      res = Math.max(res, cur);
    }
    return res;
  }
}
