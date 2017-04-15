package datastructute;

/**
 * 数据结构，二叉树
 */
public class BinaryTree<E> {

    private E data;
    private BinaryTree<E> leftNode;
    private BinaryTree<E> rightNode;

    /**
     * 前序遍历，所谓“前序”，指的是先从根节点开始遍历，处理的优先级高于它的两棵子树。
     */
    public void preorderPrint(){
        System.out.println(data.toString());
        if(leftNode != null){
            leftNode.preorderPrint();
        }
        if(rightNode != null){
            rightNode.preorderPrint();
        }
    }

    /**
     * 中序遍历，也就是将根节点放在左子树和右子树之间处理
     */
    public void inorderPrint(){
        if(leftNode != null){
            leftNode.inorderPrint();
        }
        System.out.println(data.toString());
        if(rightNode != null){
            rightNode.inorderPrint();
        }
    }

    /**
     * 后序遍历，将根节点的处理放在最后
     */
    public void posteriorPrint(){
        if(leftNode != null){
            leftNode.posteriorPrint();
        }
        if(rightNode != null){
            rightNode.preorderPrint();
        }
        System.out.println(data.toString());
    }




}
