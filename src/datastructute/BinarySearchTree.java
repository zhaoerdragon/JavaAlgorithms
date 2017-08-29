package datastructute;

/**
 * 数据结构，二叉搜索树
 */
public class BinarySearchTree {

    /**
     * 前序遍历，讲根结点放在最前面处理
     * @param binarySearchTreeNode
     */
    public static void preorderPrint(BinarySearchTreeNode binarySearchTreeNode) {
        System.out.println(binarySearchTreeNode.data);
        if (binarySearchTreeNode.leftNdoe != null) {
            preorderPrint(binarySearchTreeNode.leftNdoe);
        }
        if (binarySearchTreeNode.rightNode != null) {
            preorderPrint(binarySearchTreeNode.rightNode);
        }
    }

    /**
     * 中序遍历，也就是将根节点放在左子树和右子树之间处理
     */
    public static void inorderPrint(BinarySearchTreeNode binarySearchTreeNode){
        if(binarySearchTreeNode.leftNdoe != null){
            inorderPrint(binarySearchTreeNode.leftNdoe);
        }
        System.out.println(binarySearchTreeNode.data);
        if(binarySearchTreeNode.rightNode != null){
            inorderPrint(binarySearchTreeNode.rightNode);
        }
    }

    /**
     * 后序遍历，将根节点的处理放在最后
     */
    public static void postorderPrint(BinarySearchTreeNode binarySearchTreeNode) {
        if (binarySearchTreeNode.leftNdoe != null) {
            postorderPrint(binarySearchTreeNode.leftNdoe);
        }
        if (binarySearchTreeNode.rightNode != null) {
            postorderPrint(binarySearchTreeNode.rightNode);
        }
        System.out.println(binarySearchTreeNode.data);
    }

    /**
     * 二叉搜索树查找
     * @param binarySearchTreeNode
     * @param sign
     * @return
     */
    public static BinarySearchTreeNode treeSearch(BinarySearchTreeNode binarySearchTreeNode, int sign) {
        if ((binarySearchTreeNode == null) || (binarySearchTreeNode.data == sign)) {
            return binarySearchTreeNode;
        }
        if (sign < binarySearchTreeNode.data) {
            return treeSearch(binarySearchTreeNode.leftNdoe, sign);
        }else {
            return treeSearch(binarySearchTreeNode.rightNode, sign);
        }
    }

    /**
     * 二叉搜索树查找的while循环实现
     * @param binarySearchTreeNode
     * @param sign
     * @return
     */
    public static BinarySearchTreeNode treeSearchWhile(BinarySearchTreeNode binarySearchTreeNode, int sign) {
        while (binarySearchTreeNode != null && binarySearchTreeNode.data != sign) {
            if (sign < binarySearchTreeNode.data) {
                binarySearchTreeNode = binarySearchTreeNode.leftNdoe;
            }else {
                binarySearchTreeNode = binarySearchTreeNode.rightNode;
            }
        }
        return binarySearchTreeNode;
    }

    /**
     * 查找二叉树的最小值
     * @param binarySearchTreeNode
     * @return
     */
    public static BinarySearchTreeNode treeMinimum(BinarySearchTreeNode binarySearchTreeNode) {
        while (binarySearchTreeNode.leftNdoe != null) {
            binarySearchTreeNode = binarySearchTreeNode.leftNdoe;
        }
        return binarySearchTreeNode;
    }

    /**
     * 查找二叉树的最大值
     * @param binarySearchTreeNode
     * @return
     */
    public static BinarySearchTreeNode treeMaximum(BinarySearchTreeNode binarySearchTreeNode) {
        while (binarySearchTreeNode.rightNode != null) {
            binarySearchTreeNode = binarySearchTreeNode.rightNode;
        }
        return binarySearchTreeNode;
    }

    /**
     * 查找二叉树的前继和后驱
     * @param binarySearchTreeNode
     * @return
     */
    public static BinarySearchTreeNode treeSuccessor(BinarySearchTreeNode binarySearchTreeNode) {

        return null;
    }

    /**
     * 给二叉树插入一个数据
     * @param rootTree
     * @param binarySearchTreeNode
     */
    public static void treeInsert(BinarySearchTreeNode rootTree, BinarySearchTreeNode binarySearchTreeNode) {
        BinarySearchTreeNode y = null;
        BinarySearchTreeNode x = rootTree;
        while (x != null) {
            y = x;
            if (binarySearchTreeNode.data < x.data) {
                x = y.leftNdoe;
            }else {
                x = y.rightNode;
            }
        }
        binarySearchTreeNode.previous = y;
        if (y == null) {
            rootTree = binarySearchTreeNode;
        }else if(binarySearchTreeNode.data < y.data){
            y.leftNdoe = binarySearchTreeNode;
        }else {
            y.rightNode = binarySearchTreeNode;
        }
    }

    /**
     * 在二叉搜索树中删除一个结点
     * @param rootTree
     * @param binarySearchTreeNode
     */
    public static void treeDelete(BinarySearchTreeNode rootTree, BinarySearchTreeNode binarySearchTreeNode) {

    }

    /**
     * 已知中序遍历和后序遍历构造二叉树
     * @param inorder 中序遍历
     * @param postorder 后序遍历
     * @return
     */
    public static BinarySearchTreeNode buildTreeMPost(int[] inorder, int[] postorder) {


        return null;
    }

    /**
     * 根据二叉树的中序遍历和前序遍历构造二叉树。
     * @param inorder 中序遍历
     * @param preorder  前序遍历
     * @return
     */
    public static BinarySearchTreeNode buildTreeMPre(int[] inorder, int[] preorder) {

        return reBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private static BinarySearchTreeNode reBuildTree(int[] inorder, int startIn, int endIn, int[] preOrder, int startPre, int endPre) {
        if (startIn > endIn || startPre > endPre) {
            return null;
        }

        BinarySearchTreeNode binarySearchTreeNode = new BinarySearchTreeNode(preOrder[startPre]);

        for (int i = 0; i < inorder.length; i++) {
            if (preOrder[startPre] == inorder[i]) {
                binarySearchTreeNode.leftNdoe = reBuildTree(inorder, startIn, i - 1, preOrder, startPre + 1, i+startPre-startIn);
                binarySearchTreeNode.rightNode = reBuildTree(inorder, i + 1, endIn, preOrder, i - startIn + startPre + 1, endPre);
                break;
            }
        }

        return binarySearchTreeNode;
    }

    /**
     * 操作给定的二叉树，将其变换为原二叉树的镜像。返回的类型是二叉树不是二叉搜索树。
     * @param root
     */
    public static void mirrorTree(BinarySearchTreeNode root) {
        if (root == null) {
            return;
        }
        BinarySearchTreeNode temp = root.leftNdoe;
        root.leftNdoe = root.rightNode;
        root.rightNode = temp;
        mirrorTree(root.leftNdoe);
        mirrorTree(root.rightNode);
    }

}
