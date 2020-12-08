package LeetCodeTest;

/**
 * Created by 婷灵 on 2020/8/2.
 * LeetCode第二题，这个解题其实和普通的加减法没有区别，唯一不同的就是这个用的是链表，唯一要注意的点就是
 * 建立两条链表，一个用来跟踪，一个用来推进
 */
public class LeetCode_2 {
    public static void main(String[] args){
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        l1.next.next.next=new ListNode(9);
        l1.next.next.next.next=new ListNode(9);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(6);

        ListNode res=addTwoNumbers(l1,l2);
        while (res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur=new ListNode(0);
        ListNode res=cur;
        if(l1==null||l2==null)
            return null;
        int tempT=0;
        int tempO=0;
        while (l1!=null&&l2!=null){
            int temp=l1.val+l2.val+tempT;
            tempO=temp%10;
             tempT=temp/10;
             cur.next=new ListNode(tempO);
             l1=l1.next;
             l2=l2.next;
             cur=cur.next;
        }
        if(l1==null&&l2!=null){
            while (l2!=null){
                int temp=l2.val+tempT;
                tempO=temp%10;
                tempT=temp/10;
                cur.next=new ListNode(tempO);
                l2=l2.next;
                cur=cur.next;
            }
        }
        if(l2==null&&l1!=null){
            while (l1!=null){
                int temp=l1.val+tempT;
                tempO=temp%10;
                tempT=temp/10;
                cur.next=new ListNode(tempO);
                l1=l1.next;
                cur=cur.next;
            }
        }
        if(tempT==1){
            cur.next=new ListNode(tempT);
        }
        return res.next;
    }

}
