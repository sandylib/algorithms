class solution{
public class PalinDromeListNode {
  private ListNode getRightHalf(ListNode head) {
    if (head == null) return null;
    ListNode slow = head;
    ListNode fast = head;  
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow.next; 
  }

}

public ListNode reverse(ListNode head) {
  if(head == null || head.next ==null) return head;
   
   ListNode re = reverse(head.next);
   head.next.next = head;
   head.next = null;
   
   return re;  
 }

 public boolean isPalindrome(ListNode head) {
  ListNode p1 = head;
  ListNode p2 = reverse(getRightHalf(head));
  while (p2 != null) {
    if (p1.val != p2.val) return false;
    p1 = p1.next;
    p2 = p2.next;
  }
  return true;

}

}