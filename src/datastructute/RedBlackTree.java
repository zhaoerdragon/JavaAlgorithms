package datastructute;

/**
 * 数据结构，红黑树
 */
public class RedBlackTree {

    /**
     * 对红黑二叉树的某一个节点进行左旋
     * 简化来看旋转改变了三条链，所以有三次的双向重指定
     * 左旋将根节点旋转到了左边
     * @param rootNode
     * @param xNode
     */
    public static void leftRotate(RedBlackNode rootNode, RedBlackNode xNode) {
        RedBlackNode y = xNode.right;

        xNode.right = y.left;                                   //指向是双向的，父节点指定子节点后，子节点需指定前驱节点
        if (y.left != null) {
            y.left.previous = xNode;
        }

        y.previous = xNode.previous;
        if (xNode.previous == null) {                           //设置xNode的前驱是左节点还是右节点
            rootNode = y;
        } else if (xNode == xNode.previous.left) {
            xNode.previous.left = y;
        }else {
            xNode.previous.right = y;
        }

        y.left = xNode;
        xNode.previous = y;
    }

    /**
     * 对红黑二叉树进行右旋
     * 右旋将根节点旋转到了右边
     * @param rootNode
     * @param yNode
     */
    public static void rightRotate(RedBlackNode rootNode, RedBlackNode yNode) {
        RedBlackNode x = yNode.left;

        yNode.left = x.right;
        if (x.right != null) {
            x.right.previous = yNode;
        }

        x.previous = yNode.previous;
        if (yNode.previous == null) {
            rootNode = x;
        } else if (yNode == yNode.previous.left) {
            yNode.previous.left = x;
        }else {
            yNode.previous.right = x;
        }

        x.right = yNode;
        yNode.previous = x;
    }

    /**
     * 红黑二叉树进行插入操作
     * @param rootNode
     * @param insertNode
     */
    public static void rbInsert(RedBlackNode rootNode, RedBlackNode insertNode) {

    }

    /**
     * 红黑二叉树的插入修复
     * @param rootNode
     * @param insertNode
     */
    public static void rbInsertFixUp(RedBlackNode rootNode, RedBlackNode insertNode) {

    }
    /**
     * 对红黑二叉树进行删除某个节点的操作
     * @param rootNode
     * @param deleteNode
     */
    public static void delete(RedBlackNode rootNode, RedBlackNode deleteNode) {

    }
}
