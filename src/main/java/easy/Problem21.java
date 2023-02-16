package easy;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Problem21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0, null);
        ListNode temp = dummy;
        while (list1!=null && list2!=null) {
            if (list1.val<list2.val) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        if (list1==null) {
            temp.next = list2;
            return dummy.next;
        }
        temp.next = list1;
        return dummy.next;
    }
    public static void main(String[] args) {
//        System.out.println(new Problem21().mergeTwoLists());
    }
}
