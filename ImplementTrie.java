import java.util.Map;
class Trie{



class Node {
  Character c;
  Map<Character, Node> map;
  boolean b;
  
  Node(Character c){
      this.c = c;
      this.map = new HashMap<>();
  }
}

Node root;

public Trie() {
  this.root = new Node('$');
}

/** Inserts a word into the trie. */    
public void insert(String word) {
  Node node = root;
  for(char c : word.toCharArray()){
      Node temp = node.map.get(c);;
      if(temp == null){
          temp = new Node(c);
          node.map.put(c, temp);
      }
      node = temp;
  }
  node.b = true;
}

/** Returns if the word is in the trie. */
public boolean search(String word) {
  Node node = root;
  for(char c : word.toCharArray()){
      node = node.map.get(c);
      if(node == null){
          return false;
      }
  }
  return node.b;
}

/** Returns if there is any word in the trie that starts with the given prefix. */
public boolean startsWith(String prefix) {
  Node node = root;
  for(char c : prefix.toCharArray()){
      node = node.map.get(c);
      if(node == null){
          return false;
      }
  }
  return true;
}
}