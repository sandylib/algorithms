import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class  LetterCombinationsofaPhoneNumber {
  public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
     
    if(digits.length() == 0) return ans;

    String[] maps = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    for(int i =0; i<digits.length(); i++){
      int idx = Character.getNumericValue(digits.charAt(i));
      while(ans.peek().length() == i){
          String s = ans.remove();
          for(char c : maps[idx].toCharArray()){
            ans.add(s+c);
          }
      }
    }
    return ans;
  }

}