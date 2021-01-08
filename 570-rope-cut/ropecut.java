public class Solution {
  //求如果存在一根线，能垂直穿越这一堆横排的绳子，这一根线，最少能穿越的绳子的数量
  // 即这一根线能绳子总数-正好碰到多个绳子的切点
  public int leastRopeSegments(List<List<Integer>> ropes) {
    Map<Integer, Integer> map = new HashMap<>();
    int part = ropes.size();
    int max = 0;
    for(List<Integer> list: ropes){
      int cur = 0;
      for(int i = 0; i < list.size()-1;i++){
        //每一根绳子的切点
        cur += list.get(i);
        map.put(cur, map.getOrDefault(cur,0)+1);
        if(map.get(cur) > max){
          //找到重复最多的切点数
          //即绳子从这个切点数穿越过去，碰到的segment最少
          max = map.get(cur);
        }
      }
    }
    return part-max;
  }
}
