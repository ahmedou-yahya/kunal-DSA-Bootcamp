package linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

class Solution {

    public static void main(String[] args) {


        ListNode node15 = new ListNode(5);
        ListNode node14 = new ListNode(4, node15);
        ListNode node13 = new ListNode(3, node14);
        ListNode node12 = new ListNode(2,node13);
        ListNode node11 = new ListNode(1,node12);
//        System.out.println(cycleLength(node11));
//        ListNode head = sortList(node11);
//        display(head);
        display(node11);
        ListNode head = removeNthFromEnd(node11, 4);
        display(head);
//        display(node11);
//        ListNode head = reverseList(node1);
//        display(head);

//        ListNode node24 = new ListNode(9);
//        ListNode node23 = new ListNode(9, node24);
//        ListNode node22 = new ListNode(9,node23);
//        ListNode node21 = new ListNode(9,node22);
//
//        ListNode ans = addTwoNumbers(node11, node21);
//        display(ans);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head==null)
            return null;
        ListNode curr = head;
        int len = 0;

        while(curr!=null){
            len++;
            curr = curr.next;
        }

        int c = len-n;
        if (c==0)
            return head.next;

        curr=head;
        while (c>1){
            c--;
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
    }

    public static void display(ListNode head){
        ListNode current = head;
        while (current!=null){
            System.out.print(current.val + "--> ");
            current = current.next;
        }
        System.out.println("END");
    }

    public static ListNode reverseList(ListNode head) {

        if(head==null || head.next==null)
            return head;

        ListNode current = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = current;
            current = head;
            head=next;
        }

        return current;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        int sum = l1.val+l2.val;
        int remain = sum/10;
        int val = sum%10;
        ListNode res = new ListNode(val);
        ListNode ans = res;
        l1 = l1.next;
        l2 = l2.next;
        while (l1!=null && l2!=null){
            sum = l1.val+ l2.val+remain;
            remain=sum/10;
            val = sum%10;
            ListNode curr = new ListNode(val);
            res.next=curr;
            res = curr;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1!=null){
            while (l1!=null){
                sum = l1.val+remain;
                remain=sum/10;
                val = sum%10;
                ListNode curr = new ListNode(val);
                res.next=curr;
                res = curr;
                l1 = l1.next;
            }
        }
        if (l2!=null){
            while (l2!=null){
                System.out.println(val);
                sum = l2.val+remain;
                remain=sum/10;
                val = sum%10;
                ListNode curr = new ListNode(val);
                res.next=curr;
                res = curr;
                l2 = l2.next;
            }
        }
        if (remain!=0){
            ListNode node = new ListNode(remain);
            res.next = node;
        }
        return ans;
    }

    public static int cycleLength(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast){
                int length=0;
                do {
                    length++;
                    slow=slow.next;
                }while (slow!=fast);
                return length;
            }
        }

        return 0;
    }

    public static ListNode sortList(ListNode head) {

        if(head==null || head.next==null)
            return head;

        ListNode middle = middleNode(head);

        ListNode left = sortList(head);
        ListNode right = sortList(middle);

        return mergeTwoLists(left, right);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slowPrev = null;
        while(fast!=null && fast.next!=null){
            slowPrev = (slowPrev==null)? head : slowPrev.next;
            fast = fast.next.next;
        }
        ListNode mid = slowPrev.next;
        slowPrev.next = null;

        return mid;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null)
            return list2;
        if(list2==null)
            return list1;

        int value = 0;
        if(list1.val>list2.val){
            value = list2.val;
            list2 = list2.next;
        }
        else{
            value = list1.val;
            list1 = list1.next;
        }

        ListNode node = new ListNode(value);
        ListNode ans = node;

        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                ListNode temp = new ListNode(list1.val);
                node.next = temp;
                node = temp;
                list1 = list1.next;
            }
            else{
                ListNode temp = new ListNode(list2.val);
                node.next = temp;
                node = temp;
                list2 = list2.next;
            }

        }

        if(list1!=null){
            while(list1!=null){
                ListNode temp = new ListNode(list1.val);
                node.next = temp;
                node = temp;
                list1=list1.next;
            }
        }
        if(list2!=null){
            while(list2!=null){
                ListNode temp = new ListNode(list2.val);
                node.next = temp;
                node = temp;
                list2=list2.next;
            }
        }
        return ans;
    }

    public static void reorderList(ListNode head) {

        ListNode mid = findMiddle(head);
        ListNode hs = reverseList(mid);
        ListNode hf = head;

        while (hf!=null && hs!=null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
    }


    public static ListNode findMiddle(ListNode head){

        ListNode slowPrev = null;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slowPrev = (slowPrev==null? head: slowPrev.next);
            fast = fast.next.next;
        }

        ListNode mid = slowPrev.next;
        slowPrev.next = null;

        return mid;
    }
}
