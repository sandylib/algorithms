import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.AbstractMap;

public class SolutionOne {

  public String intToRoman(int num) {  // 1<=num<=3999
    char[][] map = new char[][] {{'I', 'V', 'X'}, {'X', 'L', 'C'}, {'C', 'D', 'M'}, {'M'}};
    StringBuilder sb = new StringBuilder();
    for (int p=0; num>0; ++p, num/=10) {  // p points to weight of 1, 10, 100, 1000
         int d = num % 10;
         if (d>0 && d<4) { for (int i=0; i<d; ++i) { sb.append(map[p][0]); } }
         else if (d == 4) { sb.append(map[p][1]).append(map[p][0]); }
         else if (d>4 && d<9) {
             for (int i=0; i<d-5; ++i) { sb.append(map[p][0]); }
             sb.append(map[p][1]);
         } else if (d == 9) { sb.append(map[p][2]).append(map[p][0]); }
    }
    return sb.reverse().toString();
  }

}

public class SolutionTwo{

  public String intToRoman(int num){
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds = 
      {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens = 
      {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] units = 
      {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    return thousands[num / 1000] + 
         hundreds[(num % 1000) / 100] + 
         tens[(num % 100) / 10] + 
         units[num % 10];
  }

}

public class SolutionThree{
  public String intToRoman(int num) {
    
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10,9, 5, 4, 1};
    String[] chars =  {"M", "CM", "D","CD", "C", "XC" ,"L", "XL", "X","IX", "V", "IV", "I"};
     
     StringBuilder sb = new StringBuilder();
     
     for(int i = 0; i< values.length; i++){
       while(num >= values[i]){
           num -= values[i];
           sb.append(chars[i]);
       }
     }
     
     return sb.toString();
   }

}

  

