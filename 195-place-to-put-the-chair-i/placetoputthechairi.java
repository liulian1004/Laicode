public class Solution {

    // BFS2, 从equement出发找chair
    //返回某一点到各个健身器材的最短距离
    //碰到ob不能过去，但是碰到eq可以过去
    //the cost to any of its neighbor is 1

    //需要全局调用的变量
    private static final char Eq = 'E';
    private static final char Ob = 'O';

    //create a pair class to keep i and j
    private static class Pair {
        int i;
        int j;
        Pair(int i, int j) {
          this.i = i;
          this.j = j;
        }
    }

    //从equipment出发，看下到各个cell的最短距离
    public List<Integer> putChair(char[][] gym) {
    final int row = gym.length;
    final int col = gym[0].length;
      List<Integer> list = new ArrayList<>();
      list.add(-1);
      list.add(-1);
      int[][] cost = new int[row][col];
      for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
          if(gym[i][j] == Eq) {
            if(!addCost(cost, gym,i, j)) {
              return list;
            }
          }
        }
      }
        //如果每一个cell都有可能放椅子，找最短距离
        //即cost值最小
        for(int i = 0; i < row; i++){
          for(int j = 0; j < col; j++) {
            if(gym[i][j] != Eq && gym[i][j] != Ob) {
              //list还没有跟新过
              if(list.get(0) == -1 && list.get(1) == -1) {
                list.set(0,i);
                list.set(1,j);
              } else if(cost[i][j] < cost[list.get(0)][list.get(1)]) {
                list.set(0,i);
                list.set(1,j);
              }
            }
          }
        }
        return list;
      }

    //确认某一个点是否可以放chair，以及从这个点出发chair到equipment的距离
    //T: O(m *n) ;S O(m*n)
    private boolean addCost(int[][] cost, char[][] gym, int i, int j) {
      final int row = gym.length;
      final int col = gym[0].length;
      boolean[][] visited = new boolean[row][col];
      int pathCost = 1;
      Queue<Pair> queue = new ArrayDeque<>();
      visited[i][j] = true;
      queue.offer(new Pair(i,j));
      while(!queue.isEmpty()) {
        int size = queue.size();
        for(int m = 0; m < size; m++) {
          Pair cur = queue.poll();
          List<Pair> nei = getNei(gym, cur);
          for(Pair neighbor: nei) {
            int x = neighbor.i;
            int y = neighbor.j;
            if(!visited[x][y]) {
              visited[x][y] = true;
              //每一个cost[][] 起始值为1
              //所以之前的pathcost起始值为1
              cost[x][y] += pathCost;
              queue.offer(neighbor);
            }
          }
        }
        //每一轮加1
        //因为每遍历一轮，扩展到i，j的邻居的邻居
        //cost到i,j的距离加1
        pathCost++;
      }
      //检查是否每一个E都能被达到
      for(int m = 0; m < row; m++) {
        for(int n = 0; n < col; n++) {
          if(!visited[m][n] && gym[m][n] == Eq) {
            return false;
          }
        }
      }
      return true;
    }
    // bfs2,从某一点出发，遍历整个邻居
    private List<Pair> getNei(char[][] gym, Pair cur) { //O(1)
      final int row = gym.length;
      final int col = gym[0].length;
      List<Pair> nei = new ArrayList<>();
      int x = cur.i;
      int y = cur.j;
      //expand 4 个方向，注意不要越界以及碰到ob不能跨越
      if(x + 1 < row && gym[x+1][y] != Ob ) {
        nei.add(new Pair(x+1, y));
      }
      if(y+1 < col && gym[x][y+1] != Ob) {
        nei.add(new Pair(x, y+1));
      }
      if(x-1 >= 0 && gym[x-1][y] != Ob){
        nei.add(new Pair(x-1, y));
      }
      if(y - 1 >= 0 && gym[x][y-1] != Ob) {
        nei.add(new Pair(x, y-1));
      }
      return nei;
    }
}
