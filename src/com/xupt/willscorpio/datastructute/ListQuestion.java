package com.xupt.willscorpio.datastructute;

/**
 * 链表类的算法
 */
public class ListQuestion {

    /**
     * 请编写一个函数，检查链表是否为回文。
     * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
     */
    public static boolean isPalindrome(ListNode pHead) {
        int length = 1;
        ListNode backNode = pHead;
        while (backNode.next != null) {
            backNode = backNode.next;
            length++;
        }
        int[] intarray = new int[length];
        backNode = pHead;
        for (int k = 0; k < length; k++) {
            intarray[k] = backNode.val;
            if (k == length - 1) break;
            backNode = backNode.next;
        }
        for (int j = 0; j < length / 2; j++) {
            if (intarray[j] == intarray[length - 1 - j]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int key = 1;
        while (temp.next != null) {
            temp = temp.next;
            key++;
        }
        if (k > key) {
            return null;
        }
        for (int i = 0; i < key - k; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 输入一个链表，反转链表后，输出链表的所有元素。
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
        ListNode pre = null;
        ListNode next = null;
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点
        //1->2->3->4->5
        //1<-2<-3 4->5
        while (head != null) {
            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            //如此就可以做到反转链表的效果
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.next;
            //保存完next，就可以让head从指向next变成指向pre了，代码如下
            head.next = pre;
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = head;
            head = next;
        }
        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        //直接输出pre就是我们想要得到的反转后的链表
        return pre;
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    /**
     * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，
     * 并用链表形式返回结果。
     * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
     *
     * @param a
     * @param b
     * @return
     */
    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode start = new ListNode(Integer.MAX_VALUE);
        ListNode temp = start;
        while (a != null || b != null) {
            ListNode listNode = null;
            if (a == null) {
                listNode = new ListNode(b.val);
                b = b.next;
            } else if (b == null) {
                listNode = new ListNode(a.val);
                a = a.next;
            } else {
                int key = a.val + b.val;
                if (key >= 10) {
                    listNode = new ListNode(key % 10);
                    if (a.next != null) {
                        a.next.val = a.next.val + key / 10;
                    } else if (b.next != null) {
                        b.next.val = b.next.val + key / 10;
                    } else {
                        ListNode okList = new ListNode(key / 10);
                        a.next = okList;
                    }
                } else {
                    listNode = new ListNode(key);
                }
                a = a.next;
                b = b.next;
            }
            temp.next = listNode;
            temp = temp.next;
        }
        return start.next;
    }

    /**
     * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
     * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
     * @param pHead
     * @param x
     * @return
     */
    public ListNode partition(ListNode pHead, int x) {
        ListNode low = new ListNode(Integer.MIN_VALUE);
        ListNode tempLow = low;
        ListNode high = new ListNode(Integer.MAX_VALUE);
        ListNode tempHigh = high;
        while (pHead != null) {
            if (pHead.val < x) {
                ListNode listNode = new ListNode(pHead.val);
                tempLow.next = listNode;
                tempLow = tempLow.next;
            } else {
                ListNode listNode = new ListNode(pHead.val);
                tempHigh.next = listNode;
                tempHigh = tempHigh.next;
            }
            pHead = pHead.next;
        }
        high = high.next;
        tempLow.next = high;
        return low.next;
    }
}
