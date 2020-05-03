class MinStack {

  class Node {

      int val;
      int oldMin;
      Node next;

      public Node(int x) {
          this.val = x;
      }
  }

  /**
   * initialize your data structure here.
   */
  private int min = Integer.MAX_VALUE;
  private Node head;

//     public MinStack() {
//     }
  public void push(int x) {
      Node n = new Node(x);

      if (head == null) {
          head = n;
      } else {
          n.next = head;
          head = n;
      }

      if (n.val <= min) {
          n.oldMin = min;
          min = n.val;

      }

  }

  public void pop() {
      if (head == null) {
          throw new NullPointerException();
      }
      Node n = head;
      head = n.next;
      if (min == n.val) {
          min = n.oldMin;
      }
  }

  public int top() {
      if (head == null) {
          throw new NullPointerException();
      }
      return head.val;
  }

  public int getMin() {
      if (min == Integer.MAX_VALUE) {
          return Integer.MAX_VALUE;
      }

      return min;
  }
}