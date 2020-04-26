class Solution {

  public ListNode swapPairs(ListNode head) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode curr = dummy;
    
     while(curr.next !=null && curr.next.next !=null){
       swap(curr);
       curr = curr.next.next;
     }
    
     return dummy.next;
  }


  public void swap(ListNode curr){
    ListNode temp = curr.next;
    curr.next = temp.next;
    temp.next = temp.next.next;
    curr.next.next = temp;
  }

}