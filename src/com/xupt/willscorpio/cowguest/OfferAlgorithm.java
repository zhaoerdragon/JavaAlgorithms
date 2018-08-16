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
        if(array.length < 2) return ;
        int myxor = 0;
        int flag = 1;
        for(int i = 0 ; i < array.length; ++ i )
            myxor ^= array[i];
        while((myxor & flag) == 0) flag <<= 1;
        // num1[0] = myxor;
        //num2[0] = myxor;
        for(int i = 0; i < array.length; ++ i ){
            if((flag & array[i]) == 0) num2[0]^= array[i];
            else num1[0]^= array[i];
        }
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

    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (array.length == 0) {
            return arrayList;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        int count = 0;
        int value = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
            if (array[i] == sum / 2) {
                count++;
            }
        }
        if (count >= 2) {
            arrayList.add(sum / 2);
            arrayList.add(sum / 2);
            value = (int) Math.pow(sum / 2, 2);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= sum) {
                break;
            }
            if (hashSet.contains(sum - array[i]) && ((sum - array[i]) * array[i]) < value) {
                arrayList.clear();
                arrayList.add(Math.min(sum - array[i], array[i]));
                arrayList.add(Math.max(sum - array[i], array[i]));
                value = (sum - array[i]) * array[i];
            }
        }
        return arrayList;
    }

    /**
     *  在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几
     *  次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean[] k = new boolean[length];
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        return null;
    }

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中
     * 出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int n = array.length;
        if (n == 0) return 0;

        int num = array[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (array[i] == num) count++;
            else count--;
            if (count == 0) {
                num = array[i];
                count = 1;
            }
        }
        // Verifying
        count = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == num) count++;
        }
        if (count * 2 > n) return num;
        return 0;
    }

    /**
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续
     * 的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也
     * 很快的找出所有和为S的连续正数序列? Good Luck!
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }


    /**
     * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气
     * ,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想
     * 了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!
     * ”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
     * 为了方便起见,你可以认为大小王是0。
     *
     * @param numbers
     * @return
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        if (numbers.length == 1) {
            return true;
        }
        Arrays.sort(numbers);
        int zero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                zero++;
            } else {
                break;
            }
        }
        int fu = 0;
        for (int i = zero; i < numbers.length - 1; i++) {
            if (numbers[i + 1] - numbers[i] == 1) {
                continue;
            } else if (numbers[i + 1] - numbers[i] == 0) {
                return false;
            } else {
                fu = fu + numbers[i + 1] - numbers[i] - 1;
            }
        }
        if (zero >= fu) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
     * 并将P对1000000007取模的结果输出。 即输出P%1000000007
     *
     * @param array
     * @return
     */
    public int InversePairs(int[] array) {
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    sum++;
                }
            }
        }
        return (int) (sum % 1000000007);
    }

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
     * 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>() ;
        if(matrix==null || matrix.length==0) { return result ; }

        printMatrixClockWisely(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);

        return result ;
    }

    public void printMatrixClockWisely(int[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer> result) {
        if(startRow<endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }   //Right
            for(int i=startRow+1; i<=endRow-1; i++) { result.add(matrix[i][endCol]) ; }     //Down
            for(int j=endCol; j>=startCol; j--) { result.add(matrix[endRow][j]) ; }     //Left
            for(int i=endRow-1; i>=startRow+1; i--) { result.add(matrix[i][startCol]) ; }   //Up
            printMatrixClockWisely(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, result) ;
        }else if(startRow==endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }
        }else if(startRow<endRow && startCol==endCol) {
            for(int i=startRow; i<=endRow; i++) { result.add(matrix[i][endCol]) ; }
        }else if(startRow==endRow && startCol==endCol) {
            result.add(matrix[startRow][startCol]) ;
        }else {
            return ;
        }
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();

        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode t = deque.pop();
            list.add(t.val);
            if(t.left != null) deque.add(t.left);
            if(t.right != null) deque.add(t.right);
        }
        return list;
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return IsTreeBST(sequence, 0, sequence.length-1);
    }

    public boolean IsTreeBST(int [] sequence,int start,int end ){
        if(end <= start) return true;
        int i = start;
        for (; i < end; i++) {
            if(sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if(sequence[j] < sequence[end]) return false;
        }
        return IsTreeBST(sequence, start, i-1) && IsTreeBST(sequence, i, end-1);
    }

    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数
     * 位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8
     * = 19。请问该机器人能够达到多少个格子？
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[] visited=new boolean[rows*cols];
        return movingCountCore(threshold, rows, cols, 0,0,visited);
    }
    private int movingCountCore(int threshold, int rows, int cols,
                                int row,int col,boolean[] visited) {
        if(row<0||row>=rows||col<0||col>=cols) return 0;
        int i=row*cols+col;
        if(visited[i]||!checkSum(threshold,row,col)) return 0;
        visited[i]=true;
        return 1+movingCountCore(threshold, rows, cols,row,col+1,visited)
                +movingCountCore(threshold, rows, cols,row,col-1,visited)
                +movingCountCore(threshold, rows, cols,row+1,col,visited)
                +movingCountCore(threshold, rows, cols,row-1,col,visited);
    }
    private boolean checkSum(int threshold, int row, int col) {
        int sum=0;
        while(row!=0){
            sum+=row%10;
            row=row/10;
        }
        while(col!=0){
            sum+=col%10;
            col=col/10;
        }
        if(sum>threshold) return false;
        return true;
    }

    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行
     * 以此类推。
     *
     * @return
     */
    /*public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> aList=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null)
            return aList;

        Stack<TreeNode> s1=new Stack<TreeNode>();
        s1.add(pRoot);
        Stack<TreeNode> s2=new Stack<TreeNode>();
        while(!s1.isEmpty()||!s2.isEmpty()){
            if(!s1.isEmpty()){
                ArrayList<Integer> aList2=new ArrayList<Integer>();
                while(!s1.isEmpty()){
                    TreeNode p=s1.pop();
                    aList2.add(p.val);
                    if(p.left!=null)
                        s2.add(p.left);
                    if(p.right!=null)
                        s2.add(p.right);
                }
                aList.add(aList2);

            }
            else {
                ArrayList<Integer> aList2=new ArrayList<Integer>();
                while(!s2.isEmpty()){

                    TreeNode p=s2.pop();
                    if(p.right!=null)
                        s1.add(p.right);
                    if(p.left!=null)
                        s1.add(p.left);
                    aList2.add(p.val);

                }
                aList.add(aList2);
            }
        }
        return aList;
    }*/
    public static void main(String[] args) {
        maxWork(new int[]{1, 3, 12, 6, 10});
    }

    /**
     * 最大工时
     * @param workinghours
     */
    public static int  maxWork(int[] workinghours) {
        if (workinghours.length == 0) {
            return 0;
        }
        Arrays.sort(workinghours);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < workinghours.length - 1; i++) {
            if (workinghours[i + 1] - workinghours[i] > max) {
                max = workinghours[i + 1] - workinghours[i];
            }
        }
        return max;
    }

}
