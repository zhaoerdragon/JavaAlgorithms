package com.xupt.willscorpio.cowguest;

import com.xupt.willscorpio.datastructute.ListNode;

import javax.swing.*;
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
        return null;
    }

    private ArrayList<String> permuta(String string, int length) {
        return null;
    }

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印
     * 出这三个数字能排成的最小数字为321323。
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = "" + numbers[i];
        }
        StringBuilder answer = new StringBuilder();

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }

        });
        for (int i = 0; i < strings.length; i++) {
            answer.append(strings[i]);
        }

        return answer.toString();
    }

    /**
     * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的
     * 库函数。 数值为0或者字符串不是一个合法的数值则返回0。
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str.equals("") || str.length() == 0)
            return 0;
        char[] a = str.toCharArray();
        int fuhao = 0;
        if (a[0] == '-')
            fuhao = 1;
        int sum = 0;
        for (int i = fuhao; i < a.length; i++)
        {
            if (a[i] == '+')
                continue;
            if (a[i] < 48 || a[i] > 57)
                return 0;
            sum = sum * 10 + a[i] - 48;
        }
        return fuhao == 0 ? sum : sum * -1;
    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = HasSubtree2(root1, root2);
            }
            if(!result) result = HasSubtree(root1.left, root2);
            if(!result) result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    public boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null)  return false;
        if (root2 == null)  return true;
        if(root1.val != root2.val) return false;
        return HasSubtree2(root1.left, root2.left) && HasSubtree2(root1.right, root2.right);
    }

    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        HashSet<ListNode> hashSet = new HashSet<>();
        while (pHead.next != null) {
            if (hashSet.contains(pHead)) {
                return pHead;
            }
            hashSet.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }

    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoopV2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode quick = pHead;
        ListNode slow = pHead;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                slow = pHead;
                while (slow != quick) {
                    slow = slow.next;
                    quick = quick.next;
                }
                if(slow == quick) return slow;
            }
        }
        return null;
    }

    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请
     * 你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，
     * 搞定它！
     *
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str, int n) {
        if (n == 0 || str.equals("")) {

            return str;
        }
        String string1 = str.substring(0, n);
        String string2 = str.substring(n);
        return string2 + string1;
    }

    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;
        if(depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth -1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }

    /**
     * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个
     * 游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首
     * 歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小
     * 朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友
     * 的编号是从0到n-1)
     *
     * @return
     */
    public static void main(String[] args) {
        OfferAlgorithm offerAlgorithm = new OfferAlgorithm();
        offerAlgorithm.LastRemaining_Solution(5, 2);
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        int s = 0;
        for (int i = 2; i <= n; i++) {
            s = (s + m) % i;
        }
        return s;
    }
}
