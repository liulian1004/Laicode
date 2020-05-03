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
  public int largest(Point[] points) {
     // linear scan and look back
    //满足条件的一定是y随着x的增加，单调递增
    // 1. 排序
    //2. 题目转换成找y的longest subsequence
    //m[i] presents the largest set of point that end at m[i]
    int result = 0;
    if(points == null || points.length <= 1) {
      return result;
    }
    Arrays.sort(points, new MyComparator());
    int[] m = new int[points.length];
    for(int i = 0; i < points.length; i++) {
      m[i] = 1;
      for(int j = 0; j < i; j++) {
        if(points[j]. y < points[i].y) {
          m[i] = Math.max(m[i], m[j] + 1);
        }
      }
      result = Math.max(result, m[i]);
    }
    return result == 1? 0: result;
  }
  static class MyComparator implements Comparator<Point> {
    @Override
    public int compare(Point a, Point b) {
      // a - b ==> ascending
      // b - a ==> decending
      // x 相等时，y decending排序
      //ie (3,7), (3,5), (3,3）
      //这样排序就避免里了把垂直的点放也纳入positive slope中
     return a.x != b.x? a.x - b.x : b.y - a.y;
    }

  }
}
