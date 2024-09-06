class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
       Set<Integer> set = new HashSet();
       for(int num : nums)  set.add(num);
    
    
    ListNode temp = head;

    while(temp != null && temp.next != null){
        if(set.contains(temp.val))
        temp = temp.next;
        else
        break;
    }
    head = temp;
    while(temp != null && temp.next != null){
        
        if(set.contains(temp.next.val)){
            temp.next = temp.next.next;   
            continue;
        }
        temp = temp.next;
    }

       return head;
    }
}
