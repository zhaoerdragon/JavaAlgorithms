package com.xupt.willscorpio.cowguest;

import com.xupt.willscorpio.datastructute.ListNode;

import java.util.HashSet;

public class OfferAlgorithm {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root.left = root1;
        root1.left = root2;
        root2.left = root3;

        /*root.right = root4;
        root4.left = root5;
        root4.right = root6;*/

        OfferAlgorithm offerAlgorithm = new OfferAlgorithm();
        boolean answer = offerAlgorithm.IsBalanced_Solution(root);
        System.out.println(answer);
    }

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if(root == null) return 0;
        int left = getDepth(root.left);
        System.out.println("The left is: " + left);
        if(left == -1) return -1;
        int right = getDepth(root.right);
        System.out.println("The right is: " + right);
        if(right == -1) return -1;
        int value = Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
        System.out.println("The Value is: " + value);
        return value;
    }

    /**
     * 输入两个链表，找出它们的第一个公共结点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> nodeHashSet = new HashSet<>();
        while (pHead1 != null || pHead2 != null) {
            if (nodeHashSet.contains(pHead1)) {
                return pHead1;
            }
            if (pHead1 != null) {
                nodeHashSet.add(pHead1);
                pHead1 = pHead1.next;
            }
            if (nodeHashSet.contains(pHead2)) {
                return pHead2;
            }
            if (pHead2 != null) {
                nodeHashSet.add(pHead2);
                pHead2 = pHead2.next;
            }
        }
        return null;
    }

    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     *
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        getValue(pRoot);
    }

    private int getValue(TreeNode root) {
        if(root == null) return 0;

    }
}
