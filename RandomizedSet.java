import java.util.*;

class RandomizedSet {

  private Map<Integer, Integer> valPosMap;
  private List<Integer> lst;
  private Random rand;

 /** Initialize your data structure here. */
 public RandomizedSet() {
     valPosMap = new HashMap<>();
     lst = new ArrayList<>();
     rand = new Random();
 }
 
 /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
 public boolean insert(int val) {
     if ( ! valPosMap.containsKey(val)) {
         lst.add(val);
         valPosMap.put(val, lst.size() - 1);
         return true;
     }
     return false;
 }
 
 /** Removes a value from the set. Returns true if the set contained the specified element. */
 public boolean remove(int val) {
     if ( ! valPosMap.containsKey(val) )
         return false;
   
     int posToRemove = valPosMap.get(val);
     int lastElement = lst.get(lst.size() - 1);
    
     lst.set(posToRemove, lastElement);
     valPosMap.put(lastElement, posToRemove);

     valPosMap.remove(val);
     lst.remove(lst.size() - 1);
    
  return true;
 }
 
 /** Get a random element from the set. */
 public int getRandom() {
     return lst.get(rand.nextInt(lst.size()));
 }
}