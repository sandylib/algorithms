class Solution {
  public int[] plusOne(int[] digits) {
      //flag is used to judge whether we need a longer array
    int length=digits.length,flag=0;
      int [] result=new int[length+1];
      for(int j=0;j<length;++j){
          if(digits[j]!=9) flag=1;
      }
      if(flag==0) {
          result[0]=1;
          return result;
      }
      //the key process to plus one
      digits[length-1]++;
      for(int i=length-1;i>=0;--i){
          if(digits[i]==10){
              digits[i]=0;
              digits[i-1]++;
          }
      }
      return digits;
  }


  public int[] plusOne2(int[] digits) {
    //judge each in turn
       for(int i = digits.length - 1; i >= 0; i--) {  
           if(digits[i] != 9) {
               digits[i]++;
               return digits;
           } else {
               digits[i] = 0;
           }
       }
       // we need to apply a new array to make length++
       int[] result = new int[digits.length + 1];
       result[0] = 1;
       return result;
   }
}