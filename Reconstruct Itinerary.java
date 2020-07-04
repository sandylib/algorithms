import java.util.*;


class Soltuion {
  Map<String, PriorityQueue<String>> map = new HashMap<>();
  LinkedList<String> list = new LinkedList<>();

  public List<String> findItinerary(List<List<String>> tickets){
    for(List<String> t : tickets) {
      String from = t.get(0), to = t.get(1);
      if(!map.containsKey(from)){
        map.put(from, new PriorityQueue<>());
      }
      map.get(from).add(to);
    }

    helper("JFK");
    return list;

  }

  private void helper(String str){
    PriorityQueue<String> pq = map.get(str);
    while(pq !=null && !pq.isEmpty()){
      helper(pq.poll());
    }
    list.addFirst(str);
  }
}