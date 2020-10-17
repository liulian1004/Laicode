public class Solution {
  public int minMeetingRooms(int[][] intervals) {
    int[][] array = new int[intervals.length*2][2];
    for(int i = 0; i < intervals.length;i++){
      array[i*2][0] = 1;
      array[i*2][1] = intervals[i][0];
      array[i*2+1][0] = -1;
      array[i*2+1][1] = intervals[i][1];
    }
    Arrays.sort(array, new MyCompare());
    int cur = 0;
    int max = 0;
    for(int[] i: array){
        cur += i[0];
        max = Math.max(cur, max);
    }
    return max;
  }
  private static class MyCompare implements Comparator<int[]>{
    @Override
    public int compare(int[] a, int[] b){
      if(a[0] == b[0] && a[1] == b[1]){
        return 0;
      }
      if(a[1] < b[1] || a[1] == b[1] && a[0]<b[0]){
        return -1;
      }
      return 1;
    }
  }
}
//another solution pq
public int minMeetingRooms(int[][] intervals) {
     //step 1 : sort by the starting time
        //step 2: put into the minHeap,sorted by end
        //case 1: if the cur start time >= minHeap peek's end time; pull out the minHeap.peek + add cur
        // case 2: if the cur start time < minHeap peek's end time=> add cur
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        if(intervals.length == 1){
            return 1;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int[] cur: intervals){
            if(minHeap.isEmpty()){
                minHeap.offer(cur);
                continue;
            }
            int[] end = minHeap.peek();
            if(end[1] <= cur[0]){
                minHeap.poll();
            }
            minHeap.offer(cur);
        }
        return minHeap.size();
    }
