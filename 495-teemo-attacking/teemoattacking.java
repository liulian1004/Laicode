class Solution {
    //end: the longest time scope
    //case 1 array[i] >= end; end = 0; sum + duration
    //case 2 array[i] < end; sum + (duration - (end - array[i]))
    // remember to update the end scope every time
     public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        int end = 0;
        for(int i: timeSeries){
            if(i >= end){
                end = 0;
            }
            if(end == 0){
                sum +=duration;
            }else{
                sum +=duration -(end-i);
            }
            end = i+duration;
        }
        return sum;
    }
}
