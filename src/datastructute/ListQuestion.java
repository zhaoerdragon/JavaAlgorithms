package datastructute;

/**
 * 链表类的算法
 */
public class ListQuestion {

    /**
     * 链表的基本结构
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 请编写一个函数，检查链表是否为回文。
     * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
     */
    public static boolean isPalindrome(ListNode pHead) {
        int length = 1;
        ListNode backNode = pHead;
        while (backNode.next != null){
            backNode = backNode.next;
            length++;
        }
        int[] intarray = new int[length];
        backNode = pHead;
        for(int k = 0; k < length; k++){
            intarray[k] = backNode.val;
            if(k == length-1) break;
            backNode = backNode.next;
        }
        for(int j = 0; j < length/2; j++){
            if(intarray[j] == intarray[length - 1 - j])
                continue;
            else return false;
        }
        return true;
    }



}
