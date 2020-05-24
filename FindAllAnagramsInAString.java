import java.util.ArrayList;
import java.util.List;

public class Solution {
  
  public List<Integer> findAnagrams(String s, String p) {
    int m = s.length(), n = p.length();
    if(n > m) return new ArrayList<>();
    
    int[] char_count = new int[26];

    //first window
    for(int i = 0; i < n; i++){
        char_count[s.charAt(i) - 'a']++;
        char_count[p.charAt(i) - 'a']--;
    }
    
    List<Integer> list = new ArrayList<>();
    for(int i = n; i < m; i++){
        if(areAllZeroes(char_count)){
            list.add(i - n);
        }
        char_count[s.charAt(i) - 'a']++;
        char_count[s.charAt(i - n) - 'a']--;
    }
    if(areAllZeroes(char_count)){
        list.add(m - n);
    }
    
    return list;
}

boolean areAllZeroes(int[] char_count){
    for(int i = 0; i < char_count.length; i++){
        if(char_count[i] != 0) return false;
    }
    return true;
}


public List<Integer> findAnagrams2(String s, String p) {
  int[] letters = new int[26];
  for(int i = 0; i < p.length(); i++) {
      letters[p.charAt(i) - 'a']++;
  }
  int j = 0;
  int rem = p.length();
  List<Integer> result = new ArrayList();
  for(int i = 0; i < s.length(); i++) {
     // this is the slide window
      while(j < s.length() && j - i < p.length()) {
         // i is the left point 
         // j is the right point
         // if character at j position is greater then 0,  then j++ also rem--
          if(letters[s.charAt(j++) - 'a']-- > 0) {
              rem--;
          }
      }
      if(rem == 0 && j - i == p.length()) result.add(i);
      if(letters[s.charAt(i) - 'a']++ >= 0) rem++; // add 
  }
  return result;
 }
  
}