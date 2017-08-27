package datastructute;

/**
 * 红黑树的结点
 */
public class RedBlackTreeNode {

    int key;                             //结点的值
    boolean color;                     //结点的颜色
    RedBlackTreeNode left;             //结点的左结点
    RedBlackTreeNode right;            //结点的右结点
    RedBlackTreeNode parent;         //结点的前驱结点

    public RedBlackTreeNode(int key, boolean color, RedBlackTreeNode left, RedBlackTreeNode right, RedBlackTreeNode parent) {
        this.key = key;
        this.color = color;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
