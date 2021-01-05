public class Solution {
  public List<String> getCommonInterest(String[] array1, String[] array2) {
    // T: O(n*m*wordLength) //S: O(n) ==> map size
    List<String> list = new ArrayList<>();
    if(array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
      return list;
    }
    if(array1.length >= array2.length) {
      helper(array2, array1, list);
    }else {
      helper(array1, array2, list);
    }
    Collections.sort(list);
    return list;
  }
  private void helper(String[] a1, String[] a2, List<String> list) {
    int sum = Integer.MAX_VALUE;
    Map<Integer, List<Integer>> map = new HashMap<>();
    map.put(sum, new ArrayList<>());
    for(int i = 0; i <a1.length; i++){
      for(int j = 0; j<a2.length; j++){
        if(a1[i].length() == a2[j].length() && a1[i] == a2[j]) {
            if(sum > (i+j)){
              map.remove(sum);
              sum = i+j;
              map.put((i+j), new ArrayList<>());
              map.get(i+j).add(i);
            }else if(sum == i+j){
              map.get(i+j).add(i);
            }
        }
    }
  }
  List<Integer> index = map.get(sum);
  for(int i: index){
    list.add(a1[i]);
  }
}
//my Solution
public List<String> getCommonInterest(String[] array1, String[] array2) {
    // T: O(n)orO(m) //S: O(n) ==> map size
    List<String> list = new ArrayList<>();
    if(array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
      return list;
    }
    Map<String, Integer> map = new HashMap<>();
    for(int i = 0; i< array1.length; i++){
      map.put(array1[i],i);
    }
    int sum = Integer.MAX_VALUE;
    for(int i = 0;i < array2.length;i++){
      String cur = array2[i];
       if(map.containsKey(cur)){
         int temp = map.get(cur)+i;
         if(sum > temp){
           list.clear();
           list.add(cur);
           sum = temp;
         }else if(sum == temp){
           list.add(cur);
         }
       }
    }
    Collections.sort(list);
    return list;
  }
