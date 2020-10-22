public class Solution {
  public int[] removeElement(int[] input, int value) {
    // Write your solution here
    int i = 0;
    int j = 0;
    while(j < input.length){
      if(input[j] != value){
        input[i] = input[j];
        i++;
      }
      j++;
    }
    return Arrays.copyOfRange(input,0,i);
  }
}
