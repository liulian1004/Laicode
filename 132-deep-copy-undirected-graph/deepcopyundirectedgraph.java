/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // T: O(v+e)
     // S: O(v)
    if(graph == null) {
      return null;
    }
    // key all nodes that have traversed
    Map<GraphNode, GraphNode> map = new HashMap<>();
    //遍历给的node的相邻节点
    for(GraphNode node: graph) {
      map.put(node, new GraphNode(node.key));
      helper(node, map);
    }
    // map.values --> return collections view of map's values(copy part)
    return new ArrayList<>(map.values());
  }
  // input一个node，map会把所有input能访问到的节点加如map
  //返回node的copy node
  private void helper(GraphNode node,Map<GraphNode, GraphNode> map) {

    // create 一个 node的copy值
    //为了建立边
     GraphNode copy = map.get(node);
     for(GraphNode nei: node.neighbors) {
       //遍历整个node的邻居，并把他们放进map中
       if(!map.containsKey(nei)) {
         map.put(nei, new GraphNode(nei.key));
         //recursion rule，遍历邻居的邻居，并把他们放入map中
         //base case: traverse until the node with no nei
         helper(nei, map);
       }
       //copy的原graph的边
       //这里需要，因为graphnode里neighbors区域
       //这里的操作是是为了建立边
        copy.neighbors.add(map.get(nei));
      }

  }
  //my solution
  public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Write your solution here.
    Map<GraphNode, GraphNode> map = new HashMap<>();
    List<GraphNode> list = new ArrayList<>();
    for(GraphNode node: graph){
      list.add(helper(node, map));
    }
    return list;
  }
  private GraphNode helper(GraphNode node, Map<GraphNode, GraphNode> map) {
    if(map.containsKey(node)){
      return map.get(node);
    }
    GraphNode copy = new GraphNode(node.key);
    //这里要先node 放入map中，否则对cycles类型的graph会有死循环
    map.put(node, copy);
    List<GraphNode> nei = copy.neighbors;
    for(GraphNode n: node.neighbors){
      nei.add(helper(n, map));
    }

    return copy;
  }
}
