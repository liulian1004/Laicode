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
    //Map两个作用： 查重 + set group
    Map<GraphNode, Integer> visited = new HashMap<>();
    //把list中的每一个节点拿出了
    for(GraphNode node : graph) {
      if(!BFS(node, visited)) {
        return false;
      }
    }
   return true;
  }
  private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
    //if this node has been traversed, no need to do BFS again
    if(visited.containsKey(node)) {
      return true;
    }
    Queue<GraphNode> queue = new ArrayDeque<>();
    queue.offer(node);
    //group 0 或者 1
    visited.put(node, 0);
    while(!queue. isEmpty()) {
      GraphNode cur = queue.poll();
      int curGroup = visited.get(cur);
      // for the node of his neighors, make the oposite number
      int neiGroup = 1- curGroup;
      //traversal 每一个node的nei
      for(GraphNode nei : cur. neighbors) {
        //要先查不在map的情况下
        //否则会有NPE
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
