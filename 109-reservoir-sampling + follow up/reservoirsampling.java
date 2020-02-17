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
     //只能==0,因为in case counter = 0；
    if((int)(Math.random() * count) == 0) {
        sample = value;
    }

  }

  public Integer sample() {
    // Write your implementation here.
        return sample;

  }
}
// follow up , return a random largest number if there have the duplicated elements in streams
//这里stream中的元素可能是一个class,里面只有value是相等的
//所以严格意义上说，这些class不一定一样
public class Solution {
  private int max;
  private int maxSample;
  private int count;
    class Solution {
          max = Integer.MIN_VALUE;
          maxSample = Integer.MIN_VALUE;
          count = 0;
    }
    public void read(int value) {
        if(value > max) {
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
