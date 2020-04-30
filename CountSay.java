
public class CountSay {
  public String countAndSay(int n) {

    String finalString = "1";

    if (n == 1) {
      return finalString;
    }

  int characterPointer = 0;
  int countPointer = 0;
  String stringInProgress = "";

  while (n > 1) {

    while (countPointer < finalString.length()) {
      while (countPointer < finalString.length() && finalString.charAt(characterPointer) == finalString.charAt(countPointer)) {
        countPointer++;
      }
      
      stringInProgress += (countPointer - characterPointer);
      stringInProgress += finalString.charAt(characterPointer);
      characterPointer = countPointer;
    }

    finalString = stringInProgress;
    stringInProgress = "";

    ///
    n--;
    characterPointer = 0;
    countPointer = 0;
  }

  return finalString;



}


//1122

public String countAndSay2(int n) {
  if(n == 1) return "1";
  
  StringBuilder sb = new StringBuilder("11");
  for(int i = 2; i < n; i++){
      
      int freq = 1;
      
      char[] letters = sb.toString().toCharArray();            
      StringBuilder curr = new StringBuilder();
      char value = letters[0];
      
      for(int j = 1; j < letters.length; j++){
          if(letters[j] == letters[j - 1]){
              freq++;
          } else {
              curr.append(freq).append(value);
              value = letters[j];
              freq = 1;
          }
      }
      curr.append(freq).append(value);
      sb = new StringBuilder(curr);
  }
  
  return sb.toString();
  
}

public String countAndSay3(int n) {
	String last = "1";

	for (int i = 1; i < n; i++) {
		String build = "";
		int count = 0;
		char lastChar = 'a';
		for (int j = 0; j < last.length(); j++) {
			if (lastChar == 'a') {
				lastChar = last.charAt(j);
			} else if (last.charAt(j) != lastChar) {
				build += Integer.toString(count) + lastChar;
				count = 0;
				lastChar = last.charAt(j);
			}

			count++;
		}

		build += Integer.toString(count) + lastChar;
		last = build;
	}

	return last;
}

}