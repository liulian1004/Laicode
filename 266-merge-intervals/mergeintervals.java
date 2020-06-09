/**
 * class Interval {
 *   public int start;
 *   public int end;
 *   public Interval(int start, int end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */
class Solution {
  public int length(List<Interval> intervals) {
    //T: O(nlogn) s: O(1)
    //meger:一个个拿出来比较
    if(intervals == null|| intervals.isEmpty()) {
      return 0;
    }
    int length = 0;
    int end = 0;
    intervals.sort(new MyCompare());
    for(int i = 0; i < intervals.size(); i++) {
      // not overlap
      if(end == 0 || end < intervals.get(i).start) {
        length += (intervals.get(i).end - intervals.get(i).start);
        end = intervals.get(i).end;
        // overlap
      }else if(intervals.get(i).start<= end && intervals.get(i).end > end){
        length += (intervals.get(i).end - end);
        end = intervals.get(i).end;
      }
    }
      return length;
  }
  static  class MyCompare implements Comparator<Interval> {
    @Override
    public int compare(Interval i1, Interval i2) {
      if(i1.start == i2.start) {
        return 0;
      }
      return i1.start < i2.start? -1: 1;
    }
  }
}
