package com.xupt.willscorpio.algorithm;

import com.xupt.willscorpio.cowguest.TreeNode;

public class AgainAndAgainAlgorithm {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        TreeNode ceng10 = new TreeNode(1);
        TreeNode ceng11 = new TreeNode(2);

        TreeNode ceng20 = new TreeNode(3);
        TreeNode ceng21 = new TreeNode(4);
        TreeNode ceng22 = new TreeNode(5);
        TreeNode ceng23 = new TreeNode(6);

        root.left = ceng10;
        root.right = ceng11;

        ceng10.left = ceng20;
        ceng10.right = ceng21;
        ceng11.left = ceng22;
        ceng11.right = ceng23;

        afterTraversing(root);
    }

    /**
     * 前序遍历，递归
     * @param treeNode
     */
    public static void firstTraversing(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        firstTraversing(treeNode.left);
        firstTraversing(treeNode.right);
    }

    /**
     * 中序遍历，递归
     * @param treeNode
     */
    public static void middleTraversing(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        middleTraversing(treeNode.left);
        System.out.println(treeNode.val);
        middleTraversing(treeNode.right);
    }

    /**
     * 后序遍历，递归
     * @param treeNode
     */
    public static void afterTraversing(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        afterTraversing(treeNode.left);
        afterTraversing(treeNode.right);
        System.out.println(treeNode.val);
    }

    /**
     * 前序遍历，非递归实现
     * @param treeNode
     */
    public static void firstTraversing_1(TreeNode treeNode) {
    }
}
