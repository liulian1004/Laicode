public class Solution {
   static class Event{
    int delta;
    int x;
    int h;
    Event(int delta, int x, int h) {
      this.delta = delta;
      this.x = x;
      this.h = h;
    }
  }
 static class Line{
    TreeMap<Integer, Integer>  map = new TreeMap<>();
    private void add(int h) {
      map.put(h, map.getOrDefault(h,0) + 1);
    }
    //must be add first, so count is at least 1
    private void remove(int h){
      int count = map.getOrDefault(h,0) - 1;
      if(count == 0) {
        map.remove(h);
      } else{
        map.put(h, count);
      }
    }
    private int max() {
      if(map.isEmpty()) {
        return 0;
      }
      return map.lastKey();
    }
  }
  public int[][] getSkyline(int[][] buildings) {
    //T： O（logn + n): S: O(n)
    if(buildings == null || buildings.length == 0 || buildings[0].length == 0) {
      return null;
    }
    List<Event> list = new ArrayList<>();
    for(int[] build: buildings) {
      list.add(new Event(1, build[0], build[2]));
      list.add(new Event(-1, build[1], build[2]));
    }
    list.sort(new MyComparator());
    List<List<Integer>> res = new ArrayList<>();
    Line line = new Line();
    for(Event e: list){
      //进入skyline加入map
      if(e.delta == 1 ) {
          line.add(e.h);
      //离开就remove
      } else {
        line.remove(e.h);
      }
      //如果加入的x坐标一样，移除之前的坐标
      //因为这里需要重新判断新加入的h是否是最高的
      //如果是最高的，需要更新(x,h)坐标中h的坐标
      //如果不是最高， 原h值不变，还是插入原来的(x,h)
      if(!res.isEmpty() && e.x == res.get(res.size()-1).get(0)) {
        res.remove(res.size()-1);
      }
      //目前最高的楼
      int h = line.max();
      //最高楼和之前的最高的楼不一样
      //可能会比之前最高的楼矮
      //加入到答案中
      if(res.isEmpty() || h != res.get(res.size()-1).get(1)) {
        res.add(Arrays.asList(e.x, h));
      }
    }
    int size = res.size();
    int[][] result = new int[size][2];
    for(int i = 0; i < size; i++) {
        result[i][0] = res.get(i).get(0);
        result[i][1] = res.get(i).get(1);
    }
    return result;
  }

  static class MyComparator implements Comparator<Event> {
    @Override
    public int compare(Event e1, Event e2){
      if(e1.x == e2.x) {
        return 0;
      }
      return e1.x <e2.x? -1 : 1;
    }
  }

}
