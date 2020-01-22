public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    // S:O(k)
    //T:  nlogk+n+klogk =(n+k)logk + n =(n+k)logk
    if(combo == null) {
      return new String[0];
    }
    HashMap<String, Integer> freqMap = getFreqMap(combo);
    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new EqualComparator());
    for(Map.Entry<String, Integer> entry: freqMap.entrySet()) {
      // k.logk + (n-k).logk = nlogk
      if(minHeap.size() < k) {
        minHeap.offer(entry);
      } else if(entry.getValue() > minHeap.peek().getValue()) {
        minHeap.poll();
        minHeap.offer(entry);
      }
    }
    return freqArray(minHeap);
  }

  private static class EqualComparator implements Comparator<Map.Entry<String, Integer>> {
      @Override
        public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
            return m1.getValue().compareTo(m2.getValue());
      }
  }

  private HashMap<String, Integer> getFreqMap(String[] combo) {
    //O(n)
    HashMap<String, Integer> res = new HashMap<>();
    for(String s: combo) {
      Integer freq = res.get(s);
      if(freq == null) {
        res.put(s, 1);
      } else {
        res.put(s, freq + 1);
      }
    }
    return res;
  }

  private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
    String[] res = new String[minHeap.size()];
    //poll出来顺序是反的，是从大到小，题目要从小到大
    //T:O(k.logk)
    //这里可能minHeap的size比k小，如果K比length大，所以要用size，不能用k
    // String[] res = new String[k];
    // for(int i = k - 1 ; i >= 0; i--) {
    for(int i = minHeap.size() - 1; i >= 0; i--) {
      res[i] = minHeap.poll().getKey();
    }
    return res;
  }
}
