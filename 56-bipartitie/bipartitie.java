/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    // T: O(n) -> the number of graph
    //S: O(n) -> the max number of the neighor of graph
    HashMap<GraphNode, Integer> visited = new HashMap<>();
    for(GraphNode node : graph) {
      if(!BFS(node, visited)) {
        return false;
      }
    }
   return true;
  }
  private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
    if(visited.containsKey(node)) {
      return true;
    }
    Queue<GraphNode> queue = new ArrayDeque<>();
    queue.offer(node);
    visited.put(node, 0);
    while(!queue. isEmpty()) {
      GraphNode cur = queue.poll();
      int curGroup = visited.get(cur);
      int neiGroup = 1- curGroup;
      //一个节点可以能有多个邻居
      for(GraphNode nei : cur. neighbors) {
      if(!visited.containsKey(nei)) {
        visited.put(nei, neiGroup);
        queue.offer(nei);
      } else if (neiGroup != visited.get(nei)) {
        return false;
        }
      }
    }
    return true;
  }

}
