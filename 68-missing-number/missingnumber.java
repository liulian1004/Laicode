public class Solution {
  public int missing(int[] array) {
    //my Solution
    //T: O(n)
    int sum = 0;
    for(int i = 1; i <= array.length + 1; i++){
      sum += i;
    }
    for(int i :array){
      sum -= i;
    }

    return sum;
    //希望寻找到n的范围
    int n = array.length + 1;
    //Solution 1 T: O^2, S: O(n)
    HashSet<Integer> set = new HashSet<>();
    for(int i: array) {
      set.add(i);
    }

  //寻找的数字从1开始,set的长度最多到n-1，所有最后一个N没有包括进去
    for(int i = 1; i < n; i++) {
      if(!set.contains(i)) {
        return i;
      }
    }
    //如果前面没有找到满足要的数字，一定是最后一个N没有包括进去
    return n;
  }
  //Solution 2: T: O(n)
    //注意overflow, 先把s1, s2转化成long (0l)
    long s1 = 0l;
    for(int i: array) {
      s1 += i;
    }
    //等差公式
    long s2 =  (n+0l)* (n + 1) / 2;
    return (int)(s2 - s1);
   }
   //solution 3
   //boolean的0位是空着的，所以要n+1
  boolean[] existed = new boolean[n + 1];
  for(int number : array) {
    existed[number] = true;
  }
  for(int i = 1; i < n  ; i++) {
    if (existed[i] == false) {
      return i;
    }
  }
  //这里满足一定要在结尾处有个返回值，上面的循环的时候提早结束一位
  return n;
 }
 //Solution 4: xor T: O(n)
//异或性质：
// 0^任何数 = 任何数，此方法用于初始化一个xor
// a^b^c == c^a^b
 int xor = 0;
 for(int number : array) {
   xor ^= number;
 }
 for(int i = 1; i <= n; i++) {
   xor ^= i;
 }
 return xor;
}
}
