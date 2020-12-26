public class Solution {
  public void shuffle(int[] array) {
    // Math.random --> [0, 1) 区间内的double
    //double = 0.9, (int) double = 0;
    //Date Structure: nu-shuffle || shuffled
    for(int i = array.length-1; i >= 0; i--){
      //这里必须要i+1，随机数的范围需要是【1，n+1 ）
      // 最后一位是不包括的，所以要多一位
        int index = (int)(Math.random()*(i+1));
        int temp = array[index];
        array[index] = array[i];
        array[i] = temp;
    }
  }
}
//follow up
/**
     * 随机产生字母，和数字，组成一个n长度的密码
     * 如果密码中必须要有数字和字母
     * 先随机产生一个数字，一个字母，之后在从字母和数字中随机产生字母或数字
     * 然后再对string做pefect shuffle
     * **/
    private String getPw(int n){
        String base = "123...abc..z";
        String num ="12..0";
        String letter ="abc..z";
        StringBuilder sb = new StringBuilder();
        //这里要多一位，因为rendom的范围是【0， n+1）
        int numIndex = (int)(Math.random()*(10));
        sb.append(num.charAt(numIndex));
        int letterIndex = (int)(Math.random()*(27));
        sb.append(letter.charAt(letterIndex));
        for(int i = 2; i < n; i++){
            int index = (int)(Math.random()*(base.length()+1));
            sb.append(base.charAt(index));
        }
        // do the perfect shuffle for result
        char [] array = sb.toString().toCharArray();
        for(int i = sb.length()-1 ; i >= 0;i--){
            int index = (int)(Math.random() *(i+1));
            char temp = array[index];
            array[array.length-1] = array[index];
            array[index] = temp;
        }
        return String.valueOf(array); // new String(array)


    }
