package datastructute;

/**
 * 数据结构，红黑树
 */
public class RedBlackTree {

    public static boolean RED = true;
    public static boolean BLACK = false;

    /**
     * 对红黑二叉树的某一个节点进行左旋
     * 简化来看旋转改变了三条链，所以有三次的双向重指定
     * 讲x的右孩子设为x的父亲节点，将x变成了一个左节点
     * 左旋示意图(对节点x进行左旋)：
     *      px                             px
     *     /                              /
     *    x                              y
     *   /  \      --(左旋)--           /  \
     *  lx   y                         x   ry
     *     /   \                      /  \
     *    ly   ry                    lx  ly
     * @param rootNode
     * @param xNode
     */
    public static void leftRotate(RedBlackTreeNode rootNode, RedBlackTreeNode xNode) {
        RedBlackTreeNode y = xNode.right;

        xNode.right = y.left;                                   //指向是双向的，父节点指定子节点后，子节点需指定前驱节点
        if (y.left != null) {
            y.left.parent = xNode;
        }

        y.parent = xNode.parent;
        if (xNode.parent == null) {                           //设置xNode的前驱是左节点还是右节点
            rootNode = y;
        } else if (xNode == xNode.parent.left) {
            xNode.parent.left = y;
        }else {
            xNode.parent.right = y;
        }

        y.left = xNode;
        xNode.parent = y;
    }

    /**
     * 对红黑二叉树进行右旋
     * 右旋将根节点旋转到了右边
     * 将y的左孩子设为y的父亲，即y变成右节点
     * 右旋示意图(对节点y进行左旋)：
     *            py                              py
     *           /                               /
     *          y                               x
     *         /  \      --(右旋)--            /  \
     *        x   ry                         lx   y
     *       / \                                 / \
     *      lx  rx                              rx  ry
     * @param rootNode
     * @param yNode
     */
    public static void rightRotate(RedBlackTreeNode rootNode, RedBlackTreeNode yNode) {
        RedBlackTreeNode x = yNode.left;

        yNode.left = x.right;
        if (x.right != null) {
            x.right.parent = yNode;
        }

        x.parent = yNode.parent;
        if (yNode.parent == null) {
            rootNode = x;
        } else if (yNode == yNode.parent.left) {
            yNode.parent.left = x;
        }else {
            yNode.parent.right = x;
        }

        x.right = yNode;
        yNode.parent = x;
    }

    /**
     * 红黑二叉树进行插入操作
     * 将插入的节点着色为红色，可以少违背一条特性，即让算法更加简单
     * @param rootNode
     * @param insertNode
     */
    public static void rbInsert(RedBlackTreeNode rootNode, RedBlackTreeNode insertNode) {
        RedBlackTreeNode x = rootNode;
        RedBlackTreeNode y = null;
        while (x != null) {
            y = x;
            if (insertNode.key < rootNode.key) {
                x = x.left;
            }else {
                x = x.right;
            }
        }
        insertNode.parent = y;
        if (y == null) {
            rootNode = insertNode;
        } else if (insertNode.key < y.key) {
            y.left = insertNode;
        }else {
            y.right = insertNode;
        }
        insertNode.left = null;
        insertNode.right = null;
        insertNode.color = RED;
        rbInsertFixUp(rootNode, insertNode);
    }

    /**
     * 红黑二叉树的插入修复
     * @param rootNode
     * @param insertNode
     */
    public static void rbInsertFixUp(RedBlackTreeNode rootNode, RedBlackTreeNode insertNode) {
        while (insertNode.parent.color == RED) {
            if (insertNode.parent == insertNode.parent.parent.left) {               //父节点是祖父节点的左节点
                RedBlackTreeNode uncle = insertNode.parent.parent.right;
                if (uncle.color == RED) {                                           //第一种情况
                    insertNode.parent.color = BLACK;
                    uncle.color = BLACK;
                    insertNode.parent.parent.color = RED;
                    insertNode = insertNode.parent.parent;
                }else {
                    if (insertNode == insertNode.parent.right) {                    //第二种情况
                        insertNode = insertNode.parent;
                        leftRotate(rootNode, insertNode);
                    }
                    insertNode.parent.color = BLACK;
                    insertNode.parent.parent.color = RED;
                    rightRotate(rootNode, insertNode.parent.parent);
                }
            }else {                                                                 //父节点是祖父节点的右节点
                RedBlackTreeNode uncle = insertNode.parent.parent.left;
                if (uncle.color == RED) {
                    insertNode.parent.color = BLACK;
                    uncle.color = BLACK;
                    insertNode.parent.parent.color = RED;
                    insertNode = insertNode.parent.parent;
                }else {
                    if (insertNode == insertNode.parent.left) {
                        insertNode = insertNode.parent;
                        rightRotate(rootNode, insertNode);
                    }
                    insertNode.parent.color = BLACK;
                    insertNode.parent.parent.color = RED;
                    leftRotate(rootNode, insertNode.parent.parent);
                }
            }
        }
        rootNode.color = BLACK;
    }
    /**
     * 对红黑二叉树进行删除某个节点的操作
     * @param rootNode
     * @param deleteNode
     */
    public static void delete(RedBlackTreeNode rootNode, RedBlackTreeNode deleteNode) {

    }
}
