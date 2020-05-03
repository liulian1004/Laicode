public class Solution {
  public int minMeetingRooms(int[][] intervals) {
    // T: O(n) S: O(2n) --> O(n)
    if(intervals == null || intervals.length == 0 || intervals[0].length == 0) {
      return 0;
    }
    List<Event> event = new ArrayList<>();
    //create event(end is -1, start is 1)
    for(int[] meet: intervals) {
      event.add(new Event(1,meet[0]));
      event.add(new Event(-1,meet[1]));
    }
    //sort the event based on time(smaller is first) and start/end meeting(end meeting is first)
    event.sort(new MyComparator());
    int max = 0;
    int cur = 0;
    // find the biggest number of meeting
    for(Event e : event) {
      cur += e.delta;
      max = Math.max(cur, max);
    }
    return max;
  }
  private static class MyComparator implements Comparator<Event> {
    @Override
    public int compare(Event e1, Event e2) {
      if(e1.delta == e2.delta && e1.x == e2.x) {
        return 0;
      } else if(e1.x < e2.x) {
        return -1;
      } else if(e1.x == e2.x && e1.delta < e2.delta) {
        return -1;
      }
      return 1;
    }
  }

  class Event{
    //delta = -1 : end meeting
    //delta = 1 : start meeting
    //x = time
    int delta;
    int x;
    public Event(int delta, int x) {
        this.delta = delta;
        this.x = x;
    }
  }
}
