class Solution{
  public String removeKdigits(String num, int k){
    if(k == num.length()) return "0";

    int temp = num.length() -k;

    String s ="";
    int counter = 0, alreadypicked = temp;

    for(int i=0; i<temp; i++){
       char min = '9';
       for(int j = counter; j <= num.length() - alreadypicked; j++){
          if(num.charAt(j) < min) {
            min = num.charAt(j);
            counter = j+1;
          }
       }
       alreadypicked--;

       s+=min;
    }
    String sprime = "";
    boolean trailing = true;

    for(int i=0; i<s.length(); i++){
      if(s.charAt(i)!= '0') trailing = false;
      if(!trailing) sprime +=s.charAt(i);
    }

    if(sprime == "") return "0";
    return  sprime;

  }
}


