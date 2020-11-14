public class Solution {
   //sort by start time by ascending if start time is the same , the end by by ascending
    // for loop each element
    // if the prev end time > the cur start time => return false
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0){
            return true;
        }
        Arrays.sort(intervals, new MyCompare());
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(end > intervals[i][0]){
                return false;
            }
            end = intervals[i][1];
        }
        return true;
    }
    private static class MyCompare implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b){
            if(a[0] == b[0] && a[1] == b[1]){
                return 0;
            }
            if(a[0]<b[0] || a[0] == b[0] && a[1] < b[1]) {
                return -1;
            }
            return 1;
        }
    }
}
