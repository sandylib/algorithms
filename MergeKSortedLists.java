import java.util.PriorityQueue;

public class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(ListNode head : lists){
        while(head != null){
            pq.add(head.val);
            head = head.next;
        }
    }
    
	ListNode dummy = new ListNode(-1);
	ListNode curr = dummy;
    while(!pq.isEmpty()) { // convert pq into linked list
        curr.next = new ListNode(pq.poll());
        curr = curr.next;
    }
    return dummy.next;
}

}