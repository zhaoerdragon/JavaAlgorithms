package datastructute;

/**
 * 数据结构，二叉搜索树
 */
public class BinarySearchTree {

    /**
     * 前序遍历，所谓“前序”，指的是先从根节点开始遍历，处理的优先级高于它的两棵子树。
     */
    public static void preorderPrint(TreeNode treeNode) {
        System.out.println(treeNode.data);

        if (treeNode.leftNdoe != null) {
            preorderPrint(treeNode);
        }
        if (treeNode.rightNode != null) {
            preorderPrint(treeNode.rightNode);
        }
    }

    /**
     * 中序遍历，也就是将根节点放在左子树和右子树之间处理
     */
    public static void inorderPrint(TreeNode treeNode){
        if(treeNode.leftNdoe != null){
            inorderPrint(treeNode.leftNdoe);
        }

        System.out.println(treeNode.data);

        if(treeNode.rightNode != null){
            inorderPrint(treeNode.rightNode);
        }
    }

    /**
     * 后序遍历，将根节点的处理放在最后
     */
    public static void postorderPrint(TreeNode treeNode) {
        if (treeNode.leftNdoe != null) {
            postorderPrint(treeNode.leftNdoe);
        }
        if (treeNode.rightNode != null) {
            postorderPrint(treeNode.rightNode);
        }

        System.out.println(treeNode.data);
    }

    /**
     * 二叉搜索树的查找
     * @param treeNode
     * @param sign
     * @return
     */
    public static TreeNode treeSearch(TreeNode treeNode, int sign) {
        if ((treeNode == null) || (treeNode.data == sign)) {
            return treeNode;
        }
        if (sign < treeNode.data) {
            return treeSearch(treeNode.leftNdoe, sign);
        }else {
            return treeSearch(treeNode.rightNode, sign);
        }
    }

    /**
     * 递归二叉搜索树的查找
     * @param treeNode
     * @param sign
     * @return
     */
    public static TreeNode treeSearchWhile(TreeNode treeNode, int sign) {
        while (treeNode != null && treeNode.data != sign) {
            if (sign < treeNode.data) {
                treeNode = treeNode.leftNdoe;
            }else {
                treeNode = treeNode.rightNode;
            }
        }
        return treeNode;
    }

    /**
     * 查找二叉树的最小值
     * @param treeNode
     * @return
     */
    public static TreeNode treeMinimum(TreeNode treeNode) {
        while (treeNode.leftNdoe != null) {
            treeNode = treeNode.leftNdoe;
        }
        return treeNode;
    }

    /**
     * 查找二叉树的最大值
     * @param treeNode
     * @return
     */
    public static TreeNode treeMaximum(TreeNode treeNode) {
        while (treeNode.rightNode != null) {
            treeNode = treeNode.rightNode;
        }
        return treeNode;
    }

    /**
     * 查找二叉树的前继和后驱
     * @param treeNode
     * @return
     */
    public static TreeNode treeSuccessor(TreeNode treeNode) {

        return null;
    }

    /**
     * 给二叉树插入一个数据
     * @param rootTree
     * @param treeNode
     */
    public static void treeInsert(TreeNode rootTree, TreeNode treeNode) {
        TreeNode y = null;
        TreeNode x = rootTree;
        while (x != null) {
            y = x;
            if (treeNode.data < x.data) {
                x = y.leftNdoe;
            }else {
                x = y.rightNode;
            }
        }
        treeNode.previous = y;
        if (y == null) {
            rootTree = treeNode;
        }else if(treeNode.data < y.data){
            y.leftNdoe = treeNode;
        }else {
            y.rightNode = treeNode;
        }
    }

    /**
     * 在二叉树树中删除一个结点
     * @param rootTree
     * @param treeNode
     */
    public static void treeDelete(TreeNode rootTree, TreeNode treeNode) {

    }

    /**
     * 已知中序遍历和后序遍历构造二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return null;
    }
}
