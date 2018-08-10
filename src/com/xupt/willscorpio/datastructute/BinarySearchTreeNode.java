package com.xupt.willscorpio.datastructute;

/**
 * 二叉搜索树的结点类
 */
public class BinarySearchTreeNode {

    public int data;                        //数据
    public BinarySearchTreeNode leftNdoe;               //左结点
    public BinarySearchTreeNode rightNode;              //右结点
    public BinarySearchTreeNode previous;               //前驱结点

    public BinarySearchTreeNode() {
    }

    public BinarySearchTreeNode(int data) {
        this.data = data;
    }
}
