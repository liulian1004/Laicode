public class Solution {
  public int kth(int k) {
    // T: k*logk S: O(k)
    PriorityQueue<Node> min = new PriorityQueue<>(new MyCompare());
    min.offer(new Node(0,0, multi(0,0)));
    Node node = null;
    Set<Integer> set = new HashSet<>();
    set.add(multi(0,0));
    while(k >0){
        node = min.poll();
        if(set.add(multi(node.x+1,node.y))) {
           min.offer(new Node(node.x+1, node.y, multi(node.x+1,node.y)));
        }
        if(set.add(multi(node.x,node.y+1))){
          min.offer(new Node(node.x, node.y+1, multi(node.x,node.y+1)));
        }
        k--;
    }
    return node.value;
  }
  static class Node{
    int x;
    int y;
    int value;
    Node(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }
  private int multi(int x, int y){
    return (int)(Math.pow(2.00, x*1.00) * Math.pow(3.00, y*1.00));
  }
  static class MyCompare implements Comparator<Node>{
    @Override
    public int compare(Node n1, Node n2) {
      if(n1.value == n2.value) {
        return 0;
      }
      return n1.value < n2.value? -1: 1;
    }
  }
}
