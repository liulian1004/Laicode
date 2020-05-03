public final static int R = 2;
   public final static int C = 4;

   public static void main(String[] args) {
       BFS result = new BFS();
       int[] values = new int[]{1,0,5,2,4,3,6,7};
       System.out.println(result.numOfSteps(values));

   }

   private int numOfSteps(int[] values) {
       if (values == null || values.length < R * C) {
           return -1;
       }
       Board initial = new Board(values);
       int[] target = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
       Board goal = new Board(target);
       Deque<Board> queue = new ArrayDeque<>();
       queue.offer(initial);
       Set<Board> visited  = new HashSet<>();
       int level = 0;
       while (!queue.isEmpty()) {
           int size = queue.size();
           for (int i = 0; i < size; i++) {
               Board cur = queue.poll();
               if(cur.equals(goal)) {
                   return level;
               }
               Board b;
               if (cur.canSwapDown()) {
                   b = swapDown(cur);
                   if(visited.add(b)) {
                       queue.offer(b);
                   }
               }
               if (cur.canSwapUp()) {
                   b = swapUp(cur);
                   if(visited.add(b)) {
                       queue.offer(b);
                   }
               }
               if (cur.canSwapLeft()) {
                   b = swapLeft(cur);
                   if(visited.add(b)) {
                       queue.offer(b);
                   }
               }
               if (cur.canSwapRight()) {
                   b = swapRight(cur);
                   if (visited.add(b)) {
                       queue.offer(b);
                   }
               }
           }
           level++;
       }
       return -1;
   }

   public static class Board {
       int[][] layout;
       int x; // row of 0
       int y; // column of 0
       //constructor board
       // copy layout and initialize x, and y
       Board(Board board) {
           this.x = board.x;
           this.y = board.y;
           this.layout = new int[R][C];
           for (int i=0; i<R; i++) {
               for (int j=0; j<C; j++) {
                   this.layout[i][j] = board.layout[i][j];
                   if (this.layout[i][j] == 0) {
                       x = i;
                       y = j;
                   }
               }
           }
       }

       Board(int[] values) {
           // Implement init
           layout = new int[R][C];
           int k = 0;
           for(int i = 0;  i < R; i++){
               for(int j = 0; j < C; j++) {
                  layout[i][j] = values[k];
                  k++;
                  if (this.layout[i][j] == 0) {
                       x = i;
                       y = j;
                   }
               }
           }
       }

       boolean canSwapUp() {
           return x>0;
       }

       boolean canSwapDown() {
           return x+1 < R;
       }

       boolean canSwapLeft() {
           return y > 0;
       }

       boolean canSwapRight() {
           return y+1 < C;
       }

       @Override
       public int hashCode() {
           int sum = 0;
           for (int i = 0; i < R; i++) {
               for (int j = 0; j < C; j++) {
                   sum = sum * 10 + layout[i][j];
               }
           }
           return sum;
       }

       @Override
       public boolean equals(Object o) {
           //先判断object可否转化成board
           if (!(o instanceof Board)) {
               return false; // Important!
           }
           Board board = (Board)o;
           for (int i = 0; i < R; i++) {
               for (int j = 0; j < C; j++) {
                   if (board.layout[i][j] != this.layout[i][j]) {
                       return false;
                   }
               }
           }
           return true;
       }
   }


   private static void swap(int[][] layout, int x, int y, int i, int j) {
       // implement swapping layout[x][y] and layout[i][j]
       int temp = layout[x][y];
       layout[x][y] =layout[i][j];
       layout[i][j] = temp;
   }
   /**
    * 1. Init a new Board instance based on cur.
    * 2. Change '0' pos based on cur.x and cur.y.
    * 3. Change the layout.
    * 4. Return the new instance.
    * */
   private Board swapDown(Board cur) {
       Board board = new Board(cur);
       swap(board.layout, board.x, board.y, board.x+1, board.y);
       board.x +=1;
       return board;
   }

   private Board swapUp(Board cur) {
       Board board = new Board(cur);
       swap(board.layout, board.x, board.y, board.x-1, board.y);
       board.x -=1;
       return board;
   }

   private Board swapLeft(Board cur) {
       Board board = new Board(cur);
       swap(board.layout, board.x, board.y, board.x, board.y-1);
       board.y -=1;
       return board;
   }

   private Board swapRight(Board cur) {
       Board board = new Board(cur);
       swap(board.layout, board.x, board.y, board.x, board.y+1);
       board.y +=1;
       return board;
   }
