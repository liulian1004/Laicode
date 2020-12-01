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
//my Solution
//T：nlogn S: O(n)
private List<List<Integer> getSkyline(int[][] buildings){
       List<int[]> list = buildList(buildings);
       List<List<Integer>> res = new ArrayList<>();
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
       int prev = 0;
       for(int[] pair: list){
           if(pair[0] == 1){
               maxHeap.offer(pair[2]);
           }
           if(pair[0] == -1){
               maxHeap.remove(pair[2]);
           }
           if(maxHeap.isEmpty()){
               List<Integer> l = new ArrayList<>();
               l.add(pair[1]);
               l.add(0);
               res.add(l);
               prev = 0;
           }else if(maxHeap.peek()!= prev){
               List<Integer> l = new ArrayList<>();
               l.add(pair[1]);
               l.add(maxHeap.peek());
               res.add(l);
               prev = maxHeap.peek();
           }
       }
       return res;
   }
   private List<int[]> buildList(int[][] buildings){
       List<int[]> list = new ArrayList<>();
       for(int[] pair: buildings){
           int[] t1 = new int[3];
           t1[0] = 1;
           t1[1] = pair[0];
           t1[2] = pair[2];
           list.add(t1);
           int[] t2 = new int[3];
           t2[0] = -1;
           t2[1] = pair[1];
           t2[2] = pair[2];
           list.add(t2);
       }
       //先按x坐标sort，从小到大
       //按1和-1sort，从1到-1（大到小）
       //如果x坐标相同，且都是1，heigh从大到小排
       //如果x坐标相同，且都是-1，heigh从小到大排
       // case：[[1,2,1],[1,2,2],[1,2,3]]
       Collections.sort(list, (a,b)->{
                         int com = a[1]-b[1];
                         if(com == 0){
                             com = b[0] - a[0];
                         }
                         if(com == 0){
                             if(a[0] == 1 && b[0] == 1){
                                 com = b[2]-a[2];
                             }else{
                                 com = a[2]-b[2];
                             }
                         }
                        return com;
       });
       return list;
}
