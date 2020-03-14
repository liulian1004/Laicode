public class Solution {
  public int largestProduct(String[] dict) {
    //assumption: dict is not null and the length >= 2
    // sort dict + Bit operation(map) + 2 for loop
    // n个元素，每个元素长度为m
    // T: O(n *m + nlogn + n^2)
    //S: O(n)
    int largest = 0;
    Map<String, Integer> map = buildMap(dict); //T: n * m
    //按length的长度进行排序
    Arrays.sort(dict,new Comparator<String>() { // n.logn
      @Override
      public int compare(String s1, String s2) {
        if(s1.length() == s2.length()) {
          return 0;
        }
        return s1.length() > s2.length() ? -1 : 1;
      }
    });
    for(int i = 0; i < dict.length - 1; i++) { // n^2
      for(int j = 1 + i; j < dict.length; j++) {
        int product = dict[i].length() * dict[j].length();
        if(product <= largest) {
          continue;
        }
        if(((map.get(dict[i]) & (map.get(dict[j])))) == 0) {
          largest = product;
        }
      }
    }
    return largest;
  }

  private Map<String, Integer> buildMap(String[] dict) {
    Map<String, Integer> map = new HashMap<>();
    for(String s: dict) {
      //初始化，用于计算每个string的bit值
      int bit = 0;
      //把String里面的字母一个个拿出来做bit operation
      // a ==> 1<<0 == 1 ==> bit |= 1 ==> 0001
      // b ==> 1<<1 == 0010 ==> bit(a) |= 0010 ==>0011
      // 这里”｜= “有相加的效果
      for(int i = 0; i < s.length(); i++) {
          bit |= 1<<((s.charAt(i) - 'a'));
      }
      map.put(s, bit);
    }
    return map;
  }
}
