import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
/**
 * The given problem can be solved as explained below -

Construct a map to count the frequency of characters in the given string
Create a list to hold characters based on the frequencies.
For instance - [{}, {a} , {b,c} , {e,g}] implies a occurs one time, b and c occurs two times, e and g occurs three times.
Now, iterate through the list from last and append the characters in the result string according to specified frequencies.
 */

class Solution {
  public String frequencySort(String s) {
      
      //initialising res
      StringBuilder res = new StringBuilder();
      if(s==null || s.length()==0){
          return res.toString();
      }
      
      //initialise hashmap and add all the char from string s in the map with freq
      HashMap<Character,Integer> map = new HashMap<>();
      for(char c: s.toCharArray()){
          map.put(c, map.getOrDefault(c,0)+1);
      }
      
      //initialise a list 
       List<Character> [] bucketlist = new List[s.length() + 1]; 
      for (char key : map.keySet()) {
          // build a frequency list of each char in map
          int freq = map.get(key);
          if (bucketlist[freq] == null) {
              bucketlist[freq] = new ArrayList<Character>();
          }
          bucketlist[freq].add(key);
      }
      
      //iterate through bucketlist and append the character in result string frequency times.
      for (int i = bucketlist.length-1; i >= 0; i--) {
          if (bucketlist[i] != null) {
              for (char c : bucketlist[i]) {
                  // append 'frequnecy' times
                  for (int j = 0; j < i; j++) {
                      res.append(c);    
                  }
              }     
          }
      }
      //return result
      return res.toString();
  }

  public String frequencySort2(String s) {
      
    //initialising res
    StringBuilder res = new StringBuilder();
    if(s==null || s.length()==0){
        return res.toString();
    }
    
    //initialise hashmap and add all the char from string s in the map with freq
    HashMap<Character,Integer> map = new HashMap<>();
    for(char c: s.toCharArray()){
        map.put(c, map.getOrDefault(c,0)+1);
    }

    PriorityQueue<Character> pq = new PriorityQueue<>( (a,b) -> map.get(b) - map.get(a));
    pq.addAll(map.keySet());

    while(!pq.isEmpty()){
      char curr = pq.remove();
      for(int i = 0; i< map.get(curr); i++){
        res.append(curr);
      }
    }
    
    //return result
    return res.toString();
}
}