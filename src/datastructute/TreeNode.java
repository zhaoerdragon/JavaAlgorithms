package datastructute;

/**
 * 二叉搜索树的结点类
 */
public class TreeNode {

    public int data;                        //数据
    public TreeNode leftNdoe;               //左结点
    public TreeNode rightNode;              //右结点
    public TreeNode previous;               //前驱结点

    public TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
    }
}
