public class Solution {
  //读进steam中第N个element，以1/n的概率将sample替换新进入的element
  //count: 读了多少次数
  private int count;
  private Integer sample;
  // constructor
  public Solution() {
    count = 0;
    sample = null;
  }

  public void read(int value) {
    // 从stream中读取到一个数“value”
    count++;
    //等概率的情况
    //只有1/n的情况下sample = value
    //只能==0,因为in case count = 1 的情况下， random的结果是0；
    if((int)(Math.random() * count) == 0) {
        sample = value;
    }

  }

  public Integer sample() {
    // 要么是null 或者是之前已经赋值好的sample
        return sample;

  }
}
//my solution with extra space
public class Solution {
  List<Integer> list;
  int count;
  public Solution() {
    // Write your constructor code here if necessary.
    list = new ArrayList<>();
    count = 0;
  }

  public void read(int value) {
    // Write your implementation here.
    list.add(value);
  }

  public Integer sample() {
    // Write your implementation here.
    if(list.size() == 0){
      return null;
    }
    int index = (int)(Math.random()*(list.size()-count));
    int res = list.get(index);
    int temp = list.get(count);
    list.add(count, res);
    list.add(index, temp);
    count++;
    return (Integer)res;
  }
}
// follow up , return a random largest number if there have the duplicated elements in streams
//这里的虽然largest number的值是一样的，但是他们的地址，或者附带的其他内容是不一样
//所以还需要等概率的返回不同的largest number
//所以严格意义上说，这些class不一定一样
public class Solution {
  private int max;
  private int maxSample;
  //计算有多少个重复的largest number
  private int count;
    class Solution {
          max = Integer.MIN_VALUE;
          maxSample = Integer.MIN_VALUE;
          count = 0;
    }
    public void read(int value) {
        // 发现一个最新的max值
        if(value > max) {
          //重置count
          count = 1;
          max = value;
          maxSample = value;
        } else if(value == max) {
          count++;
          // 将新的最大值替换成目前最大值的可能性
          if((int)(Math.random() * count) == 0) {
            maxSample = value;
          }
        }

    }
    public int sample {
        return maxSample;
    }

}
