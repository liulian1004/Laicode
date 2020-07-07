public class Solution {
  public int nthSuperUglyNumber(int n, int[] primes) {
    // T：O(n) S:O(n)
    //从1开始genera 一个min数，然后乘于所有prime里的数
    //不重复，就继续放到minHeap等待被generate出来
    if(n <= 0 || primes == null | primes.length == 0) {
      return 0;
    }
    PriorityQueue<Long> minHeap = new PriorityQueue<>();
    minHeap.offer(1l);
    long res = 1l;
    Set<Long> set = new HashSet<>();
    while(n > 0) {
      n--;
      res = minHeap.poll();
      for(int i =0; i < primes.length; i++) {
        long temp = res * primes[i];
        if(set.add(temp)) {
          minHeap.offer(res * primes[i]);
        }
      }
    }
    return (int)res;
  }
}
