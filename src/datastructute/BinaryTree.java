package datastructute;

/**
 * 数据结构，二叉搜索树
 */
public class BinaryTree {

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
     * @param inorder 中序遍历
     * @param postorder 后序遍历
     * @return
     */
    public static TreeNode buildTreeMPost(int[] inorder, int[] postorder) {


        return null;
    }

    /**
     * 根据二叉树的中序遍历和前序遍历构造二叉树
     * @param inorder 中序遍历
     * @param preorder  前序遍历
     * @return
     */
    public static TreeNode buildTreeMPre(int[] inorder, int[] preorder) {

        return reBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private static TreeNode reBuildTree(int[] inorder, int startIn, int endIn, int[] preOrder, int startPre, int endPre) {
        if (startIn > endIn || startPre > endPre) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preOrder[startPre]);

        for (int i = 0; i < inorder.length; i++) {
            if (preOrder[startPre] == inorder[i]) {
                treeNode.leftNdoe = reBuildTree(inorder, startIn, i - 1, preOrder, startPre + 1, i+startPre-startIn);
                treeNode.rightNode = reBuildTree(inorder, i + 1, endIn, preOrder, i - startIn + startPre + 1, endPre);
                break;
            }
        }

        return treeNode;
    }

    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     *
     * @param root
     */
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.leftNdoe;
        root.leftNdoe = root.rightNode;
        root.rightNode = temp;
        Mirror(root.leftNdoe);
        Mirror(root.rightNode);
    }
}
