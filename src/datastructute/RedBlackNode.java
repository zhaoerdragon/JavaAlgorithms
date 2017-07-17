package datastructute;

/**
 * 红黑树的结点
 */
public class RedBlackNode {

    public int key;                           //结点的数值
    public RedBlackNode lefeNode;             //结点的左结点
    public RedBlackNode rightNode;            //结点的右结点
    public RedBlackNode previous;             //结点的前驱结点
    public boolean color;                     //结点的颜色
}
