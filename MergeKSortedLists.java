import java.util.PriorityQueue;

public class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int len = lists.length-1; // last head index
    while(len>=0) {
        for(int i=0; i<=len; i++) {
        	if(lists[i]!=null) {
        		pq.add(lists[i].val); // add current head into the priority queue
        		lists[i] = lists[i].next; // move current head to head's next node
        	}
        	else {
        		lists[i] = lists[len--]; // switch null head with the last non-null head
        	}
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