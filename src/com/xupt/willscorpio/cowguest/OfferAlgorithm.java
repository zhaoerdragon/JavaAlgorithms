package com.xupt.willscorpio.cowguest;

import com.xupt.willscorpio.datastructute.ListNode;

import java.util.*;


public class OfferAlgorithm {

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if(root == null) return 0;
        int left = getDepth(root.left);
        System.out.println("The left is: " + left);
        if(left == -1) return -1;
        int right = getDepth(root.right);
        System.out.println("The right is: " + right);
        if(right == -1) return -1;
        int value = Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
        System.out.println("The Value is: " + value);
        return value;
    }

    /**
     * 输入两个链表，找出它们的第一个公共结点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> nodeHashSet = new HashSet<>();
        while (pHead1 != null || pHead2 != null) {
            if (nodeHashSet.contains(pHead1)) {
                return pHead1;
            }
            if (pHead1 != null) {
                nodeHashSet.add(pHead1);
                pHead1 = pHead1.next;
            }
            if (nodeHashSet.contains(pHead2)) {
                return pHead2;
            }
            if (pHead2 != null) {
                nodeHashSet.add(pHead2);
                pHead2 = pHead2.next;
            }
        }
        return null;
    }

    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     *
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return getSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean getSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val &&
                getSymmetrical(left.left, right.right) &&
                getSymmetrical(left.right, right.left);
    }

    /**
     * 给定一个由不同的小写字母组成的字符串，输出这个字符串的所有全排列。
     * 我们假设对于小写字母有'a' < 'b' < ... < 'y' < 'z'，而且给定的字符串中的字母已经按照从小到大的顺序排列。
     */
    protected static void quanPaiLie() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] chars = string.toCharArray();
        Arrays.sort(chars);

        Set<String> stringSet = paiLie(chars, 0);
        Iterator iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }

    private static Set<String> paiLie(char[] chars, int start) {
        Set<String> stringSet = new TreeSet<>();
        if (start == chars.length - 1) {
            stringSet.add(String.valueOf(chars));
            return stringSet;
        }
        for (int j = start; j < chars.length; j++) {
            swap(chars, start, j);
            stringSet.addAll(paiLie(chars, start + 1));
            swap(chars, start, j);
        }
        return stringSet;
    }

    private static void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }

    /**
     * 会下国际象棋的人都很清楚：皇后可以在横、竖、斜线上不限步数地吃掉其他棋子。如何将 8 个皇后放在棋盘上（有8×8个方格），使它们谁也不能被吃掉
     * ！这就是著名的八皇后问题。
     * 对于某个满足要求的8皇后的摆放方法，定义一个皇后串a与之对应，即 a=b1b2...b8, 其中bi（1≤bi≤8）为相应摆法中第 i 行皇后所处的列数。已经知
     * 道8皇后问题一共有92组解（即92个不同的皇后串）。给出一个数n，要求输出第n个串。串的比较是这样的:皇后串x置于皇后串y之前，当且仅当将x视为整数
     * 时比y小。
     */
    public void eightHuangHou() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            integerList.add(scanner.nextInt());
        }

    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                sum++;
            }
            if (array[i] != k && sum != 0) {
                return sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        OfferAlgorithm offerAlgorithm = new OfferAlgorithm();
        int answer = offerAlgorithm.GetNumberOfK1(new int[]{1, 2, 2, 3}, 2);
        System.out.println(answer);
    }

    public int GetNumberOfK1(int[] array, int k) {
        return searchK(array, k + 0.5f) - searchK(array, k - 0.5f);
    }

    private int searchK(int[] array, float k) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] < k) {
                start = mid + 1;
            }else if(array[mid] > k){
                end = mid - 1;
            }
        }
        return start;
    }

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length || input.length == 0) {
            return new ArrayList<Integer>();
        }
        for (int i = (input.length - 1) / 2; i >= 0; i--) {
            adjustHeap(input, i, input.length - 1);
        }

        for (int i = input.length - 1; i >= input.length - k; i--) {
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;
            adjustHeap(input, 0, i);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = input.length - 1; i >= input.length - k; i--) {
            integers.add(input[i]);
        }

        return integers;
    }

    public void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && array[k + 1] < array[k]) {
                k++;
            }
            if (array[k] < temp) {
                array[i] = array[k];
                i = k;
            }else {
                break;
            }
        }
        array[i] = temp;
    }

    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

    }

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))) {
                int value = hashMap.get(str.charAt(i));
                value++;
                hashMap.put(str.charAt(i), value);
            } else {
                hashMap.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
     * abc,acb,bac,bca,cab和cba。
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

    }

    private ArrayList<String> permuta(String string, int length) {

    }


}
