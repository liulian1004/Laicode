public class Solution {
  // 读进来的数大于k, 开始计算新的元素替换sample中任意元素的等概率
  private final int k;
  private int count;
  List<Integer> sample;
  public Solution(int k) {
    // Complete the constructor if necessary.
    this.k = k;
    sample = new ArrayList<>();;
    count = 0;
  }

  public void read(int value) {
    // Write your implementation here.
    count++;
    //随机等概率的踢掉一个element,把新的element加入
    //condition probality: P(B) = P(A) * P(B|A)
    //P(a in the sample) = P(a活到上一轮的概率) * P（没有被踢走的概率）
    //ex: k = 3, 加入了4个元素
    // P(a) = 100% * (1- P(a被踢走的概率)) = 100% * （1- (新元素加入的概率) * （a被踢走的概率）
    // = 100% * （1 -3(k)/4 * 1/3(k)) = 3/4;
    // p: k/count
    if(count > k) {
      //如果count > k
      //计算原元素被替换掉的概率，如果概率在【0，k)之间，替换
      //如果没有，不替换
        int ran = (int)(Math.random() * count);
        if(ran < k) {
          //list数值替换
          sample.set(ran, value);
        }
    } else {
      sample.add(value);
    }
  }

  public List<Integer> sample() {
    // Write your implementation here.
    return sample;
  }
}
