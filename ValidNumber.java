
class Solution {
  public boolean isDigit(char c){
      return c >= '0' && c <= '9';
  }
  
  public boolean isDot(char c){ return c == '.'; }
  public boolean isE(char c) { return c == 'e' || c == 'E';}
  public boolean isPlusMinus(char c) { return c == '+' || c == '-';}
  
  public boolean isNumber(String s){
      s = s.trim();

      if(s.isEmpty()) return false;

      Set<Character> set = new HashSet<>(Arrays.asList('E', 'e', '.', '+', '-'));
      boolean isNum = false, isExp = false, isDot = false;
      int signCount = 0, n = s.length();

      for(int i = 0; i < n; i++)
      {
          char curr = s.charAt(i);
          if(!Character.isDigit(curr) && !set.contains(curr))
              return false;

          if(Character.isDigit(curr))
             isNum = true;

          switch(curr) {
             case '.':
                if(isDot || isExp || i == n-1 && !isNum) return false;
                isDot = true;
                continue;
             case 'E':
             case 'e': 
                if(isExp || !isNum || i == 0 || i == n - 1) return false;
                isExp = true;
                continue;
            case '+':
            case '-':
              if(signCount > 1 || i == n - 1 || i > 0 && !isExp) return false;
              signCount++;
              continue;
          }
       }

      return true;
     }
  }

  public boolean isNumber1(String s)
  {
      final String PATTERN = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
      return s.trim().matches(PATTERN);
  }
}