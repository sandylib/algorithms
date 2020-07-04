class Solution {
  public String validIPAddress(String IP) {
    if(isValidIPv4(IP)) 
          return "IPv4";        
    else if(isValidIPv6(IP)) 
          return "IPv6";        
    else 
          return "Neither";
  }

  private boolean isValidIPv4(String ip) {
    if(ip.length() < 7) 
          return false;
      
    if(ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') 
          return false;
      
    String[] tokens = ip.split("\\.");
    if(tokens.length != 4) 
          return false;
      
    for(String token:tokens) {
      if(!isValidIPv4Token(token)) 
              return false;
    }
      
    return true;
  }
  
  private boolean isValidIPv4Token(String token) {
    if(token.startsWith("0") && token.length() > 1) 
          return false;
      
    try {
      int parsedInt = Integer.parseInt(token);
      if(parsedInt < 0 || parsedInt > 255) 
              return false;
      if(parsedInt == 0 && token.charAt(0) != '0') 
              return false;
    } catch(NumberFormatException nfe) {
      return false;
    }
  
    return true;
  }

  private boolean isValidIPv6(String ip) {
    if(ip.length() < 15) 
          return false;
    if(ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') 
          return false;
  
    String[] tokens = ip.split(":");
    if(tokens.length != 8) 
          return false;
  
    for(String token: tokens) {
      if(!isValidIPv6Token(token)) 
              return false;
    }
  
    return true;
  }
  
  private boolean isValidIPv6Token(String token) {
    if(token.length() > 4 || token.length() == 0) 
          return false;
  
    char[] chars = token.toCharArray();
    for(char c:chars) {
      boolean isDigit = (c >= '0') && (c <= '9');
      boolean isUppercaseAF = (c >= 'A') && (c <= 'F');
      boolean isLowerCaseAF = (c >= 'a') && (c <= 'f');
          
      if(!(isDigit || isUppercaseAF || isLowerCaseAF)) 
        return false;
    }
  
    return true;
  }
}

class Solution {
      public String validateIPv4(String IP) {
        String[] nums = IP.split("\\.", -1);
        for (String x : nums) {
          // Validate integer in range (0, 255):
          // 1. length of chunk is between 1 and 3
          if (x.length() == 0 || x.length() > 3) return "Neither";
          // 2. no extra leading zeros
          if (x.charAt(0) == '0' && x.length() != 1) return "Neither";
          // 3. only digits are allowed
          for (char ch : x.toCharArray()) {
            if (! Character.isDigit(ch)) return "Neither";
          }
          // 4. less than 255
          if (Integer.parseInt(x) > 255) return "Neither";
        }
        return "IPv4";
      }
    
      public String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
          // Validate hexadecimal in range (0, 2**16):
          // 1. at least one and not more than 4 hexdigits in one chunk
          if (x.length() == 0 || x.length() > 4) return "Neither";
          // 2. only hexdigits are allowed: 0-9, a-f, A-F
          for (Character ch : x.toCharArray()) {
            if (hexdigits.indexOf(ch) == -1) return "Neither";
          }
        }
        return "IPv6";
      }
    
      public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
          return validateIPv4(IP);
        }
        else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
          return validateIPv6(IP);
        }
        else return "Neither";
      }
    }


import java.util.regex.Pattern;
class Solution {
  String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
  Pattern pattenIPv4 =
          Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

  String chunkIPv6 = "([0-9a-fA-F]{1,4})";
  Pattern pattenIPv6 =
          Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

  public String validIPAddress(String IP) {
    if (pattenIPv4.matcher(IP).matches()) return "IPv4";
    return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
  }
}