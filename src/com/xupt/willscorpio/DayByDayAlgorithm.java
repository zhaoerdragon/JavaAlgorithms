package com.xupt.willscorpio;

import com.xupt.willscorpio.cowguest.TreeNode;
import com.xupt.willscorpio.datastructute.ListNode;

import javax.annotation.processing.AbstractProcessor;
import java.util.ArrayList;
import java.util.Stack;

public class DayByDayAlgorithm {

    public static void main(String[] args) {
        DayByDayAlgorithm dayByDayAlgorithm = new DayByDayAlgorithm();
        System.out.println(dayByDayAlgorithm.replaceSpace(new StringBuffer("Hello World")));
    }

    /* 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0 || target < array[0][0] || target > array[array.length - 1][array[0].length - 1]) {
            return false;
        }
        int row = array.length;
        int columns = array[0].length;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (target > array[i][array[0].length - 1]) {
                    break;
                }
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函
     * 数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public boolean Find_1(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0 || target < array[0][0] || target > array[array.length - 1][array[0].length - 1]) {
            return false;
        }
        int row = array.length - 1;
        int columns = 0;

        while (row >= 0 && columns < array[0].length) {
            if (target == array[row][columns]) {
                return true;
            } else if (target < array[row][columns]) {
                row--;
            } else {
                columns++;
            }
        }

        return false;
    }

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个
     * 函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public boolean Find_2(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0 || target < array[0][0] || target > array[array.length - 1][array[0].length - 1]) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            int left = 0;
            int right = array[0].length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target > array[i][mid]) {
                    left = mid + 1;
                } else if (target < array[i][mid]) {
                    right = mid - 1;
                }else {
                    return true;
                }
            }

        }

        return false;
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public String replaceSpace_1(StringBuffer str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.empty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode != null) {
            if (listNode.next != null) {
                arrayList.addAll(printListFromTailToHead_1(listNode.next));
            }
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历
     * 序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        int[][] temp = devideArray(0, pre.length - 1, in, pre[0]);

        return null;
    }

    public int[][] devideArray(int left, int right, int[] array, int target) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (array[i] == target) {
                answer = i;
                break;
            }
        }
        return new int[][]{{left, answer - 1}, {
                answer + 1, right}};

    }


}
