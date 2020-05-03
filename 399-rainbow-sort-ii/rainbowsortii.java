public class Solution {
  public int[] rainbowSortII(int[] array) {
    // T：O(n); S: O(1)
    //[0,i) red/0; [i,j) green/1; [j,k) blue/3; [k,p] to be confirmed; (p,end] black/3
    if(array == null || array.length == 0) {
      return array;
    }
    int i = 0;
    int j = 0;
    int k = 0;
    int p = array.length - 1;
    while(k <= p) {
      if(array[k] == 0){
        swap(array, j, k);
        swap(array, i, j);
        i++;
        j++;
        k++;
      } else if(array[k] == 1) {
        swap(array, j, k);
        j++;
        k++;
      }else if(array[k] == 2) {
        k++;
      }else{
        swap(array, k, p);
        p--;
      }
    }
    return array;
  }
  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
