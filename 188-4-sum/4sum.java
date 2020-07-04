public class Solution {
  public boolean exist(int[] array, int target) {
    if(array == null | array.length <= 3) {
      return false
    }
    // my solution T: O(n^2) S: O(n)
    // the qualified pair.right < next pair.left
   if(array == null || array.length < 4) {
     return false;
   }
   Map<Integer, Pair> map = new HashMap<>();
   for(int i = 1; i < array.length; i++) {
     for(int j = 0; j < i; j++) {
       int temp = array[i] + array[j];
       if(map.containsKey(target - temp) && map.get(target - temp).right < j) {
         return true;
       }
       if(!map.containsKey(temp)) {
          map.put(temp, new Pair(j,i));
       }
     }
   }
   return false;
 }
 static class Pair{
     int left;
     int right;
     Pair(int left, int right) {
       this.left = left;
       this.right = right;
     }
 }
    //Solution 1: 2 for loop + 2 sum
    //T: O(n^3); S: O(1)
    Arrays.sort(array);
    for(int i = 0; i < array.length - 3; i++) {
      for(int j = i+1; j < array.length - 2; j++) {
        int left = j + 1;
        int right = array.length - 1;
        int sum = array[i] + array[j];
        while(left < right) {
          int tmp = array[left] + array[right];
          if(sum + tmp == target) {
            return true;
          } else if(sum + tmp < target) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
    return false;
  }
  //follow up：如果要返回组合情况，如{1, 1, 1, 1, 6, 1, 1, 1, 2, 4}， target 4
  //返回{1,1,1,1}
  //代码如下
  private List<List<Integer>> sum(int[] array, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (array == null || array.length < 3) {
            return list;
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            if (i > 0 && array[i] == array[i + 1]) {
                continue;
            }
            for (int j = i+1; j < array.length - 2; j++) {
                if (j > i+1 && array[j] == array[j + 1]) {
                    continue;
                }

                int left = j + 1;
                int right = array.length - 1;
                int tmp = target - array[i] - array[j];
                while (left < right) {
                    int sum = array[left] + array[right];
                    if (sum == tmp) {
                        list.add(Arrays.asList(array[i], array[j], array[left], array[right]));
                        left++;
                        right--;
                        while (left < right && array[left] == array[left + 1]) {
                            left++;
                        }
                    } else if (sum < tmp) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

        }
        return list;
    }
  //Solution 2: 2 for loop + 2 sum
  //T: O(n^2 * logn); S: O(1)
// step one : sort Arrayfor loop and create a new array with ELement class
//step two： 2 sum

  public boolean exist(int[] array, int target) {

    if(array == null || array.length < 3) {
  	return false;
    }

  Arrays.sort(array);
  Element[] pairSum = sumUp(array);
  Arrays.sort(pairSum);
  int left = 0;
  int right = pairSum.length - 1;
  while(left < right) {
  	int tmp = pairSum[left].sum + pairSum[right].sum;
    //pairSum(left).right < pairSum(right).left
    // 这个方法用于去重，确保结果不是三个元素加在一起
    // element(sum, a, b) && elememt(sum, b, c) 这种情况就是重复情况
    	if(tmp == target && pairSum[left].right <  pairSum[right].left) {
    	return true;
      }else if(tmp < target) {
        	left++;
      }else{
        	right--;
      }
    }
  	return false;
  }

  private Element[] sumUp(int[] array) {
    //如果sum相等，index只保留小的那一对pair
    // pariSum 的长度等于一共有多少对pair
    // number of pair = array.length(i) * (array.length - 1) / 2 (j)
   //j 这么算因为后面有一半元素是重复的
    int n = array.length;
  	Element[] pairSum= new Element[n * (n-1) / 2];
  	int cur = 0;
  	for(int i = 0 ; i < array.length - 1; i++) {
      for(int j = i + 1; j < array.length; j++) {
      pairSum[cur++] = new Element(array[i]+array[j], i, j);
    }
  }
  return pairSum;
  }

  private static class Element implements Comparable<Element> {
  	int sum;
  	int left;
  	int right;
    Element(int sum, int left, int right) {
  	this.sum = sum;
  	this.left = left;
  	this.right = right;
  }
  @Override
  //比较传入的另一个元素的大小
  // 最后只保留index靠前的那一组index
  public int compareTo(Element another) {
  	if(this.sum != another.sum) {
    	return this.sum < another.sum? -1 : 1;
    } else if(this.right != another.right) {
    	return this.right < another.right? -1 : 1;
    } else if(this.left != another.left) {
    	return this.left < another.left? -1 : 1;
    }
  return 0;
  }
}
