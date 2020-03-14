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
    //Assumption： Point is not null and it the length is at least two
    //slope k : y1-y2 / x1 - x2
    //T：
    int result = 0;
    for(int i = 0; i < points.length; i++) {
      //已point[i]做为benchmarking的点
      //因为需要与其他点比较，自己不算进去，所以这里需要起始值为1
      int same = 1;
      //record the special case that all the same line
      int sameX = 0;
      Point benchmark = points[i];
      //max是每一次for loop都要跟新的值
      // 跟新slope的值，更新每次for loop的值
      int max = 0;
      //Map<scope, how many times the scope is the same>
      Map<Double, Integer> map = new HashMap<>();
      for(int j = 0; j < points.length; j++) {
        //no need to compare the same point
        if(i == j) {
          continue;
        }
        Point tmp = points[j];
        // different point, but the value is the same
        if(tmp.x == benchmark.x && tmp.y == benchmark.y) {
          same++;
          // on the same line
        } else if(tmp.x == benchmark.x) {
          sameX++;
        } else {
          double slope = (tmp.y - benchmark.y - 0.0) / (tmp.x - benchmark.x);
          if(!map.containsKey(slope)) {
            map.put(slope, 1);
          } else {
            map.put(slope, map.get(slope) + 1);
          }
          max = Math.max(max, map.get(slope));
        }
      }
      //一轮j循环结束
      //需要跟新max,并且加上point[i]本身或者和它一样的点数
      max = Math.max(max, sameX) + same;
      // result 每次靠max跟新值
      result = Math.max(result, max);
    }
    return result;
  }
}
